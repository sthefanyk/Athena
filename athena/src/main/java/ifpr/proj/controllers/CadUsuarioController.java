package ifpr.proj.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.proj.App;
import ifpr.proj.controllers.ViewModels.CadUsuarioViewModel;
import ifpr.proj.model.entities.Cidade;
import ifpr.proj.model.entities.Contato;
import ifpr.proj.model.entities.CorRaca;
import ifpr.proj.model.entities.Email;
import ifpr.proj.model.entities.Endereco;
import ifpr.proj.model.entities.Estado;
import ifpr.proj.model.entities.Nivel;
import ifpr.proj.model.entities.Pessoa;
import ifpr.proj.model.entities.Rg;
import ifpr.proj.model.entities.Sexo;
import ifpr.proj.model.entities.Telefone;
import ifpr.proj.model.results.Result;
import ifpr.proj.utils.Navigator.BorderPaneRegion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXComboBox;

public class CadUsuarioController extends BaseController implements Initializable{

    @FXML
    private MFXTextField tfNomeCompl;

    @FXML
    private MFXDatePicker dpData;

    @FXML
    private MFXComboBox<Cidade> cbNaturalidade;

    @FXML
    private MFXComboBox<Estado> cbNaturalidadeUF;

    @FXML
    private MFXTextField tfNomeMae;

    @FXML
    private MFXTextField tfNomePai;

    @FXML
    private MFXComboBox<Sexo> cbSexo;

    @FXML
    private MFXComboBox<CorRaca> cbCorRaca;

    @FXML
    private MFXCheckbox chbDef;

    @FXML
    private MFXTextField tfCep;

    @FXML
    private MFXComboBox<Estado> cbUF;

    @FXML
    private MFXComboBox<Cidade> cbMunicipio;

    @FXML
    private MFXTextField tfLogradouro;

    @FXML
    private MFXTextField tfBairro;

    @FXML
    private MFXTextField tfNumero;

    @FXML
    private MFXTextField tfComplemento;

    @FXML
    private MFXTextField tfCpf;

    @FXML
    private MFXTextField tfRg;

    @FXML
    private MFXTextField tfRgExp;

    @FXML
    private MFXComboBox<Estado> cbRgUF;

    @FXML
    private MFXTextField tfOrgao;

    @FXML
    private MFXTextField tfEmail;

    @FXML
    private MFXTextField tfTelefone;

    @FXML
    private MFXComboBox<Nivel> cbTipo;

    private CadUsuarioViewModel viewModel;

    public CadUsuarioController(CadUsuarioViewModel viewModel){
        this.viewModel = viewModel;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        this.cbNaturalidade.setItems(viewModel.getCidades());
        this.cbNaturalidadeUF.setItems(viewModel.getEstados());
        this.cbSexo.setItems(viewModel.getSexos());
        this.cbUF.setItems(viewModel.getEstados());
        this.cbMunicipio.setItems(viewModel.getCidades());
        this.cbRgUF.setItems(viewModel.getEstados());
        this.cbCorRaca.setItems(viewModel.getCorRacas());
        this.cbTipo.setItems(viewModel.getNivels());

        tfNomeCompl.textProperty().bindBidirectional(view.);
    }

    @FXML
    private void usuario(){
        App.changeScreenRegion("CRUD_USUARIO", BorderPaneRegion.CENTER);
    }

    @FXML
    private void cadastrar(){
        Result resultado = viewModel.cadastrar();
        showMessage(resultado);
    }


    

}
