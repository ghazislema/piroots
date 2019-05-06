/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import appMainClasses.LigneMain;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import jdk.nashorn.internal.objects.Global;
import service.ServiceLigne;
import entities.Ligne;
import java.io.IOException;
import java.util.Locale;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLgestionlignesController implements Initializable {

 public ServiceLigne service = new ServiceLigne();
 @FXML
 private AnchorPane ANCHOR_UPDATE;
 @FXML
 private Label LINE_ID;
 @FXML
 private JFXTextField LINE_NAME;
 @FXML
 private ComboBox COMBO_BOX_TRANSP;
 @FXML
 private ImageView EXIT_ICON;
 @FXML
 private ImageView SAVE_ICON;
 @FXML
 private TextField SEARCH_BAR;
 @FXML
 private Label COL1_LIST_LIGNE;
 @FXML
 private Label COL2_LIST_LIGNE;
 @FXML
 private Label H1_LINE_MANAGEMENT;
 @FXML
 private Label BTN_ADD_NEW_LINE;
 @FXML
 private Button btnOverview;
 @FXML
 private Button btnOrders;
 @FXML
 private Button BTN_LINE_MANAGEMENT;
 @FXML
 private Button btnMenus;
 @FXML
 private Button btnPackages;
 @FXML
 private Button btnSettings;
 @FXML
 private Button btnSignout;
 @FXML
 private Pane pnlCustomer;
 @FXML
 private Pane pnlOrders;
 @FXML
 private Pane pnlMenus;
 @FXML
 private Pane pnlOverview;
 @FXML
 private VBox pnItems;
 @FXML
 private Button btnOrders1;

 private ResourceBundle bundle;
 private Locale locale;

 /**
  * Initializes the controller class.
  * @param url
  * @param rb
  */


 @Override
 public void initialize(URL url, ResourceBundle rb) {
  // TODO

  //Chargement langage
  Loadlang(LigneMain.language);

  COMBO_BOX_TRANSP.getItems().addAll("Bus", "Train", "Metro");

  //remplir le vbox
  recupererLignes(service.findAll());

  //go to add line page
  goToAdd();
  
  //methode pour fermer l'update box
  exit_update();

  //appel service update
  update_line();

  //methode pour la barre de recherche
  search_line();

 }

 public void goToAdd()
 {
     BTN_ADD_NEW_LINE.setOnMouseClicked(e->{
             Parent showligne;
             try {
                 showligne = FXMLLoader.load(getClass().getResource("FXMLaddligne.fxml"));
                  Scene scene = new Scene(showligne);
        
        
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
             } catch (IOException ex) {
                 Logger.getLogger(FXMLgestionstationsController.class.getName()).log(Level.SEVERE, null, ex);
             }
       
         });
 }

 public void recupererLignes(List < Ligne > list) {


  for (Ligne ligne: list) {

   HBox h1 = new HBox();
   h1.setAlignment(Pos.CENTER_LEFT);
   h1.maxHeight(Global.Infinity);
   h1.setPadding(Insets.EMPTY);

   h1.setSpacing(55.0);

   h1.setStyle("-fx-background-color: #E6E9ED; -fx-background-radius: 5; -fx-background-insets: 0;");

   Label idline = new Label(ligne.getId() + "");
   idline.setVisible(false);
   Label espace2 = new Label("");
   Label espace3 = new Label("");
   Label espace4 = new Label("");
   Label espace5 = new Label("");


   Label nom = new Label(ligne.getNom());
   nom.setPrefSize(75, 15);
   nom.setMaxSize(75, 15);
   Label moyenTransp = new Label(ligne.getMoyentransport());


   moyenTransp.setPrefSize(75, 15);
   moyenTransp.setMaxSize(75, 15);


   moyenTransp.prefHeight(17.0);
   moyenTransp.prefWidth(112.0);




   ImageView edit = new ImageView();
   edit.setFitWidth(42.0);
   edit.setFitHeight(23.0);
   edit.setPickOnBounds(true);
   edit.setPreserveRatio(true);
   edit.setImage(new Image("@../../ressources/images/edit.png"));


   ImageView delete = new ImageView();
   delete.setFitWidth(27.0);
   delete.setFitHeight(23.0);
   delete.setPickOnBounds(true);
   delete.setPreserveRatio(true);
   delete.setImage(new Image("@../../ressources/images/trash.png"));




   h1.getChildren().addAll(idline, nom, espace2, moyenTransp, espace4, espace5, edit, espace3, delete);

   h1.setId(ligne.getId() + "");

   pnItems.getChildren().add(h1);

   delete.setOnMouseClicked(e -> {
       Alert alert = new Alert(AlertType.CONFIRMATION);
alert.setTitle("Confirmation alert");
alert.setHeaderText("Are you sure you want to delete the following line: "+nom.getText());
alert.setContentText("This action cannot be reverted !");

Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
    service.delete(ligne.getId());

    pnItems.getChildren().remove(h1);
} 
    

   });

   edit.setOnMouseClicked(e -> {

    ANCHOR_UPDATE.setVisible(true);
    LINE_NAME.setText(nom.getText());
    COMBO_BOX_TRANSP.setValue(moyenTransp.getText());
    int id = ligne.getId();
    LINE_ID.setText(id + "");

   });

  }
 }
 
 private void Loadlang(String lang) {
  Locale locale = new Locale(lang);
  bundle = ResourceBundle.getBundle("i18n.mybundle", locale);

  BTN_LINE_MANAGEMENT.setText(bundle.getString("BTN_LINE_MANAGEMENT"));
  H1_LINE_MANAGEMENT.setText(bundle.getString("H1_LINE_MANAGEMENT"));
  BTN_ADD_NEW_LINE.setText(bundle.getString("BTN_ADD_NEW_LINE"));
  COL1_LIST_LIGNE.setText(bundle.getString("COL1_LIST_LIGNE"));
  COL2_LIST_LIGNE.setText(bundle.getString("COL2_LIST_LIGNE"));
  SEARCH_BAR.setPromptText(bundle.getString("SEARCH_BAR"));


 }

 @FXML
 private void handleClicks(ActionEvent event) {}

 public void exit_update() {
  //exit icone update
  EXIT_ICON.setOnMouseClicked(e -> {
   ANCHOR_UPDATE.setVisible(false);
  });
  //
 }

 public void update_line() {
  //partie update 
  SAVE_ICON.setOnMouseClicked(e -> {
    
   if (!LINE_NAME.getText().isEmpty())
   {
   String style = "-fx-background-color: #DAE5CC";
   ANCHOR_UPDATE.setStyle(style);


   ServiceLigne service = new ServiceLigne();
   String nom = LINE_NAME.getText();
   String transp = (String) COMBO_BOX_TRANSP.getValue();

   System.out.println(nom + " a" + transp);
   Ligne ligne = new Ligne();
   ligne.setNom(nom);
   ligne.setMoyentransport(transp);
   ligne.setId(Integer.parseInt(LINE_ID.getText()));
   service.update(ligne);

   //Change color after x secs
   PauseTransition delay = new PauseTransition(Duration.millis(1000));
   delay.setOnFinished(event -> {
    String style2 = "-fx-background-color: #DEEAF2";
    ANCHOR_UPDATE.setStyle(style2);
   });
   delay.play();
   }
   else
   {
        String style = "-fx-background-color: #FFE2CC";
        ANCHOR_UPDATE.setStyle(style);
        PauseTransition delay = new PauseTransition(Duration.millis(1000));
   delay.setOnFinished(event -> {
    String style2 = "-fx-background-color: #DEEAF2";
    ANCHOR_UPDATE.setStyle(style2);
   });
       
   }
   //
  });

 }

 public void search_line() {
  // recherche synchro
  SEARCH_BAR.textProperty().addListener((observable, oldValue, newValue) -> {
   pnItems.getChildren().clear();
   List < Ligne > list = null;
   list = service.searchLineByNameTransport(SEARCH_BAR.getText());
   recupererLignes(list);
  });

 }



}