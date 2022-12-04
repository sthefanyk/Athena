package ifpr.proj.controllers;

import ifpr.proj.App;
import ifpr.proj.utils.Navigator.BorderPaneRegion;
import javafx.fxml.FXML;

public class CrudUsuarioController {

    @FXML
    private void usuario(){
        App.changeScreenRegion("CRUD_USUARIO", BorderPaneRegion.CENTER);
    }
    
    @FXML
    private void adicionar(){
        App.changeScreenRegion("CAD_USUARIO", BorderPaneRegion.CENTER);
    }
}
