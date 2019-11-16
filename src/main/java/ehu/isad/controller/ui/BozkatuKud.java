package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.BozkaketaDBKud;
import ehu.isad.controller.db.OrdezkaritzaDBKud;
import ehu.isad.controller.model.Artista;
import ehu.isad.controller.model.BozkatzekoDatuak;
import ehu.isad.controller.model.Herrialde;
import ehu.isad.controller.model.Ordezkaritza;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BozkatuKud implements Initializable {

    // Reference to the main application.
    private Main mainApp;

    @FXML
    private TableView<BozkatzekoDatuak> tbData;

    @FXML
    private TableColumn<BozkatzekoDatuak, String> herrialdea;

    @FXML
    private TableColumn<BozkatzekoDatuak, String> artista;

    @FXML
    private TableColumn<BozkatzekoDatuak, String> abestia;

    @FXML
    private TableColumn<BozkatzekoDatuak, Image> bandera;

    @FXML
    private TableColumn<BozkatzekoDatuak, Integer> puntuak;

    @FXML
    private Label goiTestua = new Label();

    @FXML
    private Button bozkatuBotoia;

    private static String zeinHerrialdeaNaiz;

    // add your data here from any source
    private ObservableList<BozkatzekoDatuak> taulaModels = FXCollections.observableArrayList(
            OrdezkaritzaDBKud.getInstantzia().emanBozkatzekoDatuak()
    );


    public void setMainApp(Main main) {
        this.mainApp = main;
    }

    @FXML
    public void onClick(ActionEvent actionEvent) {
        // Bozkaketa gorde behar da
        // 5 puntu dira banatzeko, lehenengo 5ak hartu eta gorde
        // ez dakit insert-a eta update-a, biak, egin behar diren

        int totalPunt = 5;

        for (int i = 0; i < tbData.getItems().size(); i++) {
            BozkatzekoDatuak datuak = tbData.getItems().get(i);
            if (datuak.getPuntuak() != 0 && totalPunt != 0) {
                System.out.println(datuak.getPuntuak());

                BozkaketaDBKud.getInstantzia().bozkaketaBerria(zeinHerrialdeaNaiz, datuak.getHerrialdea(), datuak.getPuntuak());
                OrdezkaritzaDBKud.getInstantzia().botoakEguneratu(datuak.getHerrialdea(), datuak.getPuntuak());
                totalPunt = totalPunt - datuak.getPuntuak();
            }
        }
        this.mainApp.top3PantailaErakusti();

    }


    public void jarriZeinHerrialdeaNaiz(String herrialde) {

        zeinHerrialdeaNaiz = herrialde;

        this.goiTestua.setText(zeinHerrialdeaNaiz + "k horrela nahi ditu bere puntuak banatu:");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tbData.setEditable(true);
        //make sure the property value factory should be exactly same as the e.g getStudentId from your model class
        herrialdea.setCellValueFactory(new PropertyValueFactory<>("herrialdea"));
        artista.setCellValueFactory(new PropertyValueFactory<>("artista"));
        abestia.setCellValueFactory(new PropertyValueFactory<>("abestia"));
        puntuak.setCellValueFactory(new PropertyValueFactory<>("puntuak"));


        // Callback<TableColumn<BozkatzekoDatuak, String>, TableCell<BozkatzekoDatuak, String>> defaultTextFieldCellFactory
        //        = TextFieldTableCell.<BozkatzekoDatuak>forTableColumn();

        Callback<TableColumn<BozkatzekoDatuak, Integer>, TableCell<BozkatzekoDatuak, Integer>> defaultTextFieldCellFactory
                = TextFieldTableCell.<BozkatzekoDatuak, Integer>forTableColumn(new IntegerStringConverter());

        //puntuak.setCellFactory(TextFieldTableCell.<BozkatzekoDatuak, Integer>forTableColumn(new IntegerStringConverter()));

        puntuak.setCellFactory(col -> {
            TableCell<BozkatzekoDatuak, Integer> cell = defaultTextFieldCellFactory.call(col);
            cell.itemProperty().addListener((obs, oldValue, newValue) -> {
                TableRow row = cell.getTableRow();
                if (row == null) {
                    cell.setEditable(false);
                } else {
                    BozkatzekoDatuak item = (BozkatzekoDatuak) cell.getTableRow().getItem();
                    if (item == null) {
                        cell.setEditable(false);
                    } else {
                        cell.setEditable(!item.getHerrialdea().equals(zeinHerrialdeaNaiz));
                    }
                }
            });
            return cell ;
        });


        puntuak.setOnEditCommit(
                t -> t.getTableView().getItems().get(t.getTablePosition().getRow())
                        .setPuntuak(t.getNewValue())
        );




        bandera.setCellValueFactory(new PropertyValueFactory<BozkatzekoDatuak, Image>("banderaImage"));

        bandera.setCellFactory(p -> new TableCell<>() {
            public void updateItem(Image image, boolean empty) {
                if (image != null && !empty){
                    final ImageView imageview = new ImageView();
                    imageview.setFitHeight(25);
                    imageview.setFitWidth(25);
                    imageview.setImage(image);
                    setGraphic(imageview);
                    setAlignment(Pos.CENTER);
                    // tbData.refresh();
                }else{
                    setGraphic(null);
                    setText(null);
                }
            };
        });

        //add your data to the table here.
        tbData.setItems(taulaModels);

    }


}