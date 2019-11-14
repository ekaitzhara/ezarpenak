package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.BozkaketaDBKud;
import ehu.isad.controller.db.ParteHartzeaDBKud;
import ehu.isad.controller.model.Herrialde;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HerrialdeHautatuKud implements Initializable {

    // Reference to the main application.
    private Main mainApp;

    @FXML
    private ComboBox comboBox = new ComboBox();

    public void setMainApp(Main main) {
        this.mainApp = main;
    }

    @FXML
    public void onClick(ActionEvent actionEvent) {
        // Begiratu ea parte hartzen duen....
        // Dena ondo badoa sartu bozkatzera

        //comboBox.getValue()
        if (BozkaketaDBKud.getInstantzia().bozkatuDu(this.comboBox.getSelectionModel().getSelectedItem().toString())) {
            this.mainApp.erroreLeihoaErakutsi(this.comboBox.getSelectionModel().getSelectedItem().toString());
        } else { // Ez du bozkatu
            this.mainApp.bozkaketaPantailaErakusti(this.comboBox.getSelectionModel().getSelectedItem().toString());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // kudeatzaile bati deitu izen guztiak lortzeko
        List<Herrialde> herrialdeak = ParteHartzeaDBKud.getInstantzia().emanParteHartuHerrialdeak();

        this.comboBox.getItems().addAll(herrialdeak);



    }

}