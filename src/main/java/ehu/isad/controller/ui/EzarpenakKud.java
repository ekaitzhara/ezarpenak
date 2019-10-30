package ehu.isad.controller.ui;

import ehu.isad.controller.db.EzarpenakDBKud;
import ehu.isad.Main;
import ehu.isad.controller.model.Ezarpena;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class EzarpenakKud implements Initializable {

  // Reference to the main application.
  private Main mainApp;

  @FXML
  private TableView<Ezarpena> tbData;
  @FXML
  public TableColumn<Ezarpena, Integer> userId;

  @FXML
  public TableColumn<Ezarpena, String> key;

  @FXML
  public TableColumn<Ezarpena, String> value;

  // add your data here from any source
  private ObservableList<Ezarpena> ezarpenakModels = FXCollections.observableArrayList(EzarpenakDBKud.getInstantzia().lortuEzarpenak());

  public void setMainApp(Main main) {
    this.mainApp = mainApp;
  }


  /*
  public void getEzarpenak() {
    // Datu basetik atzitu ezarpenak
    ezarpenak.setText("Proba");
    List<Ezarpena> lista = EzarpenakDBKud.getInstantzia().lortuEzarpenak();

    ezarpenak.setText(lista.toString());
  }
   */

  @FXML
  public void onClick(ActionEvent actionEvent) {
    this.mainApp.itxi();
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    //make sure the property value factory should be exactly same as the e.g getStudentId from your model class
    userId.setCellValueFactory(new PropertyValueFactory<>("userId"));
    key.setCellValueFactory(new PropertyValueFactory<>("key"));
    value.setCellValueFactory(new PropertyValueFactory<>("value"));
    //add your data to the table here.
    tbData.setItems(ezarpenakModels);

  }

}