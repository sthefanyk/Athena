package ifpr.proj.controllers;

import ifpr.proj.App;
import javafx.fxml.FXML;

public class LoginController {
    @FXML
    private void entrar(){
        App.pushScreen("ADMIN");
    }
}
