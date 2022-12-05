package ifpr.proj;


import ifpr.proj.controllers.LoginController;
import ifpr.proj.controllers.ViewModels.CadUsuarioViewModel;
import ifpr.proj.model.FabricaConexoes;
import ifpr.proj.model.daos.JDBCPessoaDAO;
import ifpr.proj.model.daos.PessoaDAO;
import ifpr.proj.model.repositories.PessoaRepository;
import ifpr.proj.controllers.AdminController;
import ifpr.proj.controllers.CadUsuarioController;
import ifpr.proj.controllers.CrudUsuarioController;
import ifpr.proj.utils.Navigator.BaseAppNavigator;
import ifpr.proj.utils.Navigator.ScreenRegistryFXML;

/**
 * JavaFX App
 */
public class App extends BaseAppNavigator{

    private PessoaDAO pessoaDao;
    private PessoaRepository pessoaRepository;

    @Override
    public void init() throws Exception {
        // TODO Auto-generated method stub
        super.init();

        pessoaDao = new JDBCPessoaDAO(FabricaConexoes.getInstance());
        pessoaRepository = new PessoaRepository(pessoaDao);
    }

    @Override
    public String getHome() {
        // TODO Auto-generated method stub
        return "LOGIN";
    }

    @Override
    public String getAppTitle() {
        // TODO Auto-generated method stub
        return "Athena";
    }

    // new CadUsuarioViewModel(pessoasRepository)
    @Override
    public void registrarTelas() {
        registraTela("LOGIN", new ScreenRegistryFXML(getClass(), "view/login.fxml", (o)->new LoginController()));
        registraTela("ADMIN", new ScreenRegistryFXML(getClass(), "view/admin.fxml", (o)->new AdminController()));
        registraTela("CRUD_USUARIO", new ScreenRegistryFXML(getClass(), "view/crudUsuario.fxml", (o)->new CrudUsuarioController()));
        registraTela("CAD_USUARIO", new ScreenRegistryFXML(getClass(), "view/cadUsuario.fxml", (o)->new CadUsuarioController(new CadUsuarioViewModel(pessoaRepository))));
    }

}