package ifpr.proj;


import ifpr.proj.controllers.LoginController;
import ifpr.proj.controllers.AdminController;
import ifpr.proj.controllers.CadUsuarioController;
import ifpr.proj.controllers.CrudUsuarioController;
import ifpr.proj.controllers.PostController;
import ifpr.proj.utils.Navigator.BaseAppNavigator;
import ifpr.proj.utils.Navigator.ScreenRegistryFXML;

/**
 * JavaFX App
 */
public class App extends BaseAppNavigator{

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

    @Override
    public void registrarTelas() {
        registraTela("LOGIN", new ScreenRegistryFXML(getClass(), "view/login.fxml", (o)->new LoginController()));
        registraTela("ADMIN", new ScreenRegistryFXML(getClass(), "view/admin.fxml", (o)->new AdminController()));
        registraTela("CRUD_USUARIO", new ScreenRegistryFXML(getClass(), "view/crudUsuario.fxml", (o)->new CrudUsuarioController()));
        registraTela("CAD_USUARIO", new ScreenRegistryFXML(getClass(), "view/cadUsuario.fxml", (o)->new CadUsuarioController()));
    }

}