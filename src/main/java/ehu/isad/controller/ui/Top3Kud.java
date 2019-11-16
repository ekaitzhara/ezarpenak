package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.OrdezkaritzaDBKud;
import ehu.isad.controller.model.BozkatzekoDatuak;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Top3Kud implements Initializable {

    // Reference to the main application.
    private Main mainApp;

    @FXML
    private Button okBotoia;

    @FXML
    private ImageView bandera1 = new ImageView();

    @FXML
    private ImageView bandera2 = new ImageView();

    @FXML
    private ImageView bandera3 = new ImageView();

    @FXML
    private Label top1;

    @FXML
    private Label top2;

    @FXML
    private Label top3;

    public void setMainApp(Main main) {
        this.mainApp = main;
    }

    @FXML
    public void onClick(ActionEvent actionEvent) {

        this.mainApp.itxi();
    }

    public void jarriDatuak() {

        List<BozkatzekoDatuak> datuak = OrdezkaritzaDBKud.getInstantzia().emanTop3();


        this.bandera1.setImage(datuak.get(0).getBanderaImage());
        this.bandera1.setVisible(true);

        this.bandera2.setImage(datuak.get(1).getBanderaImage());
        this.bandera2.setVisible(true);


        this.bandera3.setImage(datuak.get(2).getBanderaImage());
        this.bandera3.setVisible(true);


        this.top1.setText(datuak.get(0).getHerrialdea() + " - " + datuak.get(0).getPuntuak() + " puntu");
        this.top2.setText(datuak.get(1).getHerrialdea() + " - " + datuak.get(1).getPuntuak() + " puntu");
        this.top3.setText(datuak.get(2).getHerrialdea() + " - " + datuak.get(2).getPuntuak() + " puntu");


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // argazkiena
        //this.bandera1 = new ImageView();
        this.bandera1.setFitHeight(50);
        this.bandera1.setFitWidth(50);

        //this.bandera2 = new ImageView();
        this.bandera2.setFitHeight(50);
        this.bandera2.setFitWidth(50);

        //this.bandera3 = new ImageView();
        this.bandera3.setFitHeight(50);
        this.bandera3.setFitWidth(50);
    }

}