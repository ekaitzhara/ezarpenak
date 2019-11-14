package ehu.isad;

import ehu.isad.controller.ui.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

  private Parent hasieraUI;
  private Parent herrialdeHautatuUI;
  private Parent erroreaUI;
  private Parent bozkatuUI;
  private Parent top3UI;

  private Stage stage;

  private NagusiaKud nagusiaKud;
  private EzarpenakKud ezarpenakKud;
  private HasieraKud hasieraKud;
  private HerrialdeHautatuKud herrialdeHautatuKud;
  private ErroreaKud erroreaKud;
  private BozkatuKud bozkatuKud;
  private Top3Kud top3Kud;


  @Override
  public void start(Stage primaryStage) throws Exception {

    stage = primaryStage;
    pantailakKargatu();

    stage.setTitle("Eurovision");
    stage.setScene(new Scene(hasieraUI, 450, 275));
    stage.show();
  }

  private void pantailakKargatu() throws IOException {

    FXMLLoader loaderKautotu = new FXMLLoader(getClass().getResource("/hasiera.fxml"));
    hasieraUI = (Parent) loaderKautotu.load();
    hasieraKud = loaderKautotu.getController();
    hasieraKud.setMainApp(this);

    FXMLLoader loaderHerrialdeHautatu = new FXMLLoader(getClass().getResource("/herrialdeHautatu.fxml"));
    herrialdeHautatuUI = (Parent) loaderHerrialdeHautatu.load();
    herrialdeHautatuKud = loaderHerrialdeHautatu.getController();
    herrialdeHautatuKud.setMainApp(this);

    FXMLLoader loaderErrorea = new FXMLLoader(getClass().getResource("/errorea.fxml"));
    erroreaUI = (Parent) loaderErrorea.load();
    erroreaKud = loaderErrorea.getController();
    erroreaKud.setMainApp(this);

    FXMLLoader loaderBozkatu = new FXMLLoader(getClass().getResource("/bozkatu.fxml"));
    bozkatuUI = (Parent) loaderBozkatu.load();
    bozkatuKud = loaderBozkatu.getController();
    bozkatuKud.setMainApp(this);

    FXMLLoader loaderTop = new FXMLLoader(getClass().getResource("/top3.fxml"));
    top3UI = (Parent) loaderTop.load();
    top3Kud = loaderTop.getController();
    top3Kud.setMainApp(this);
  }


  public static void main(String[] args) {
    launch(args);
  }


  public void itxi() {
    stage.close();
  }

  public void herrialdeHautatuErakutsi() {
    stage.setScene(new Scene(herrialdeHautatuUI));
    stage.show();
  }

  public void erroreLeihoaErakutsi(String herrialdea) {
      erroreaKud.setTestua(herrialdea);
      stage.setScene(new Scene(erroreaUI));
      stage.show();
  }

  public void bozkaketaPantailaErakusti(String herri) {
      bozkatuKud.jarriZeinHerrialdeaNaiz(herri);
      stage.setScene(new Scene(bozkatuUI));
      stage.show();
  }
}
