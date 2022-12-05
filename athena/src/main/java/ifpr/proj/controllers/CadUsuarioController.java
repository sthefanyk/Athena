package ifpr.proj.controllers;

import java.util.ArrayList;
import java.util.List;

import ifpr.proj.App;
import ifpr.proj.controllers.ViewModels.CadUsuarioViewModel;
import ifpr.proj.model.entities.Cidade;
import ifpr.proj.model.entities.Estado;
import ifpr.proj.model.entities.Pais;
import ifpr.proj.utils.Navigator.BorderPaneRegion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class CadUsuarioController {

    @FXML
    private TextField tfNomeCompl;

    @FXML
    private MFXDatePicker dpData;

    @FXML
    private TextField tfNaturalidade;

    /*@FXML
    private MFXComboBox<Str> cbUF;*/

    @FXML
    private TextField tfNomeMae;

    @FXML
    private TextField tfNomePai;

    @FXML
    private MFXCheckbox chbDef;

    @FXML
    private MFXComboBox<String> cbTipo;

    private ObservableList<String> tipos = FXCollections.observableArrayList();
    private ObservableList<String> estados = FXCollections.observableArrayList();

    private CadUsuarioViewModel viewModel;


    public CadUsuarioController(CadUsuarioViewModel viewModel){
        this.viewModel = viewModel;
    }

    @FXML
    private void initialize(){

        Pais pais = new Pais(0, "Brasil");
        Pais pais2 = new Pais(0, "Argentina");
        Pais pais3 = new Pais(0, "Alemanha");
        Estado estado = new Estado(0, "Parana", pais3);
        Estado estado2 = new Estado(0, "Minas Gerais", pais3);
        Estado estado3 = new Estado(0, "São Paulo", pais3);
        Cidade cidade = new Cidade(0, "Curitiba", estado);
        Cidade cidade1 = new Cidade(0, "Paranagua", estado);
        Cidade cidade2 = new Cidade(0, "São Paulo", estado3);

        estados.setAll(estado.getNome(), estado2.getNome(), estado3.getNome());

        //this.cbUF.setItems(estados);
        
        tipos.setAll("Aluno", "Professor", "Coordenação");

        this.cbTipo.setItems(tipos);
    }




    @FXML
    private void usuario(){
        App.changeScreenRegion("CRUD_USUARIO", BorderPaneRegion.CENTER);
    }

    @FXML
    private void cadastrar(){
        viewModel.cadastrar();
    }

}
