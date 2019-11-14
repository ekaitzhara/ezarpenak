package ehu.isad.controller.ui;

import ehu.isad.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ErroreaKud implements Initializable {

    // Reference to the main application.
    private Main mainApp;

    @FXML
    private Label testua;


    public void setMainApp(Main main) {
        this.mainApp = main;
    }

    @FXML
    public void onClick(ActionEvent actionEvent) {

        //this.mainApp.herrialdeHautatuErakutsi();
        this.mainApp.itxi();
    }

    public void setTestua(String herrialdea) {
        this.testua.setText( herrialdea + " jada banatu ditu bere puntuak");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}