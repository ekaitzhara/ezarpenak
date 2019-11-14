package ehu.isad.controller.ui;

import ehu.isad.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class Top3Kud implements Initializable {

    // Reference to the main application.
    private Main mainApp;


    public void setMainApp(Main main) {
        this.mainApp = main;
    }

    @FXML
    public void onClick(ActionEvent actionEvent) {

        this.mainApp.itxi();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}