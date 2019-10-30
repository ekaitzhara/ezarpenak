package ehu.isad.controller.ui;

import ehu.isad.Main;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class NagusiaKud implements Initializable {

  // Reference to the main application.
  private Main mainApp;


  public void setMainApp(Main main) {
    this.mainApp = main;
  }

  @FXML
  public void onClick(ActionEvent actionEvent) {
    this.mainApp.ezarpenakErakutsi();
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {

  }

}