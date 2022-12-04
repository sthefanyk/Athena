package ifpr.proj.controllers;

import ifpr.proj.App;
import ifpr.proj.utils.Navigator.BorderPaneRegion;
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

    @FXML
    private MFXComboBox cbUF;

    @FXML
    private TextField tfNomeMae;

    @FXML
    private TextField tfNomePai;

    @FXML
    private MFXCheckbox chbDef;




    @FXML
    private void usuario(){
        App.changeScreenRegion("CRUD_USUARIO", BorderPaneRegion.CENTER);
    }
}
