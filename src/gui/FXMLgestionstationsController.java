/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXTextField;
import entities.Ligne;
import entities.Station;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import jdk.nashorn.internal.objects.Global;
import service.ServiceLigne;
import service.ServiceStation;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLgestionstationsController implements Initializable {

    @FXML
    private Button btnOverview;
    @FXML
    private Button btnOrders;
    @FXML
    private Button BTN_LINE_MANAGEMENT;
    @FXML
    private Button btnMenus;
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
    private TextField SEARCH_BAR;
    @FXML
    private Label H1_STATION_MANAGEMENT;
    @FXML
    private VBox pnItems;
    @FXML
    private Label BTN_ADD_NEW_STATION;
    @FXML
    private Label COL2_LIST_STATION;
    @FXML
    private Label COL1_LIST_STATION;
    @FXML
    private AnchorPane ANCHOR_UPDATE;
    @FXML
    private JFXTextField LINE_NAME;
    @FXML
    private ComboBox<?> COMBO_BOX_TRANSP;
    @FXML
    private ImageView SAVE_ICON;
    @FXML
    private ImageView EXIT_ICON;
    @FXML
    private Label LINE_ID;
    @FXML
    private ImageView RELOAD_BTN;
    @FXML
    private ImageView RELOAD_BTN1;

    public ServiceStation service = new ServiceStation();
    @FXML
    private ImageView RELOAD_BTN2;
    /**
     * Initializes the controller class.
     */
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadpages();
        search_line();
         recupererStations(service.findAll());
       
         BTN_ADD_NEW_STATION.setOnMouseClicked(e->{
             Parent showligne;
             try {
                 showligne = FXMLLoader.load(getClass().getResource("FXMLaddStation.fxml"));
                  Scene scene = new Scene(showligne);
        
        
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
             } catch (IOException ex) {
                 Logger.getLogger(FXMLgestionstationsController.class.getName()).log(Level.SEVERE, null, ex);
             }
       
         });
    }    

    @FXML
    private void handleClicks(ActionEvent event) {
    }
    
    public void search_line() {
  // recherche synchro
  SEARCH_BAR.textProperty().addListener((observable, oldValue, newValue) -> {
   pnItems.getChildren().clear();
   List < Station > list = null;
   list = service.search(SEARCH_BAR.getText());
   recupererStations(list);
  });
    }
    
    
    
     public void loadpages()
 {
     btnOrders.setOnAction(e->{
          Parent showligne;
             try {
                 showligne = FXMLLoader.load(getClass().getResource("FXMLgestionvoyage.fxml"));
                  Scene scene = new Scene(showligne);
        
        
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
             } catch (IOException ex) {
                 Logger.getLogger(FXMLgestionstationsController.class.getName()).log(Level.SEVERE, null, ex);
             }
       
         });
     
     BTN_LINE_MANAGEMENT.setOnAction(e->{
         
          Parent showligne;
             try {
                 showligne = FXMLLoader.load(getClass().getResource("FXMLgestionlignes.fxml"));
                  Scene scene = new Scene(showligne);
        
        
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
             } catch (IOException ex) {
                 Logger.getLogger(FXMLgestionstationsController.class.getName()).log(Level.SEVERE, null, ex);
             }
         
     });
     
     btnSettings.setOnAction(e->{
         Parent showligne;
             try {
                 showligne = FXMLLoader.load(getClass().getResource("RoadConstruction.fxml"));
                  Scene scene = new Scene(showligne);
        
        
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
             } catch (IOException ex) {
                 Logger.getLogger(FXMLgestionstationsController.class.getName()).log(Level.SEVERE, null, ex);
             }
         
     });
     btnMenus.setOnAction(e->{
         Parent showligne;
             try {
                 showligne = FXMLLoader.load(getClass().getResource("FXMLgestionstations.fxml"));
                  Scene scene = new Scene(showligne);
        
        
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
             } catch (IOException ex) {
                 Logger.getLogger(FXMLgestionstationsController.class.getName()).log(Level.SEVERE, null, ex);
             }
         
     });
     btnSignout.setOnAction(e->{
          Parent showligne;
             try {
                 showligne = FXMLLoader.load(getClass().getResource("FXMLlogin.fxml"));
                  Scene scene = new Scene(showligne);
        
        
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
             } catch (IOException ex) {
                 Logger.getLogger(FXMLgestionstationsController.class.getName()).log(Level.SEVERE, null, ex);
             }
         
     });
        
 }
     public void recupererStations(List<Station> list) {


  for (Station s: list) {

   HBox h1 = new HBox();
   h1.setAlignment(Pos.CENTER_LEFT);
   h1.maxHeight(Global.Infinity);
   h1.setPadding(Insets.EMPTY);

   h1.setSpacing(30.0);

   h1.setStyle("-fx-background-color: #E6E9ED; -fx-background-radius: 5; -fx-background-insets: 0;");

   Label idline = new Label(s.getId() + "");
   idline.setVisible(false);
   idline.setMaxSize(0, 0);
   
   Label espace = new Label("");
   Label espace2 = new Label("");
   Label espace3 = new Label("");
   Label espace4 = new Label("");
   Label espace5 = new Label("");
   Label espace6 = new Label("");
   Label espace7 = new Label("");
   Label espace8 = new Label("");


   Label nom = new Label(s.getNom());
   nom.setPrefSize(75, 15);
   nom.setMaxSize(75, 15);
   Label coord = new Label(s.getLongitude()+ " , "+s.getLatitude());


   coord.setPrefSize(160, 15);
   coord.setMaxSize(160, 15);




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


      ImageView inspect = new ImageView();
   inspect.setFitWidth(27.0);
   inspect.setFitHeight(23.0);
   inspect.setPickOnBounds(true);
   inspect.setPreserveRatio(true);
   inspect.setImage(new Image("@../../ressources/images/icons8-search-48.png"));


   h1.getChildren().addAll(idline, nom, espace2, coord, espace4, inspect ,espace,espace5,espace6,espace7, edit, espace3, delete);

   h1.setId(s.getId() + "");

   pnItems.getChildren().add(h1);

   delete.setOnMouseClicked(e -> {
     Alert alert = new Alert(AlertType.CONFIRMATION);
alert.setTitle("Confirmation alert");
alert.setHeaderText("Are you sure you want to delete the following station: "+nom.getText());
alert.setContentText("This action cannot be reverted !");

Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
        service.delete(s.getId());
        service.deletet_fromtraject(s.getId());
    pnItems.getChildren().remove(h1);

} 

   });

   edit.setOnMouseClicked(e -> {

 
       try {
           
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("FXMLupdateStation.fxml"));
           Parent updatestation = loader.load();
           Scene updatescene = new Scene(updatestation);
           
           FXMLupdateStationController controller=  loader.getController();
           controller.initData(s);
        
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(updatescene);
        stage.show();

       } catch (IOException ex) {
           Logger.getLogger(FXMLgestionstationsController.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        
        
       
   });
   
   inspect.setOnMouseClicked(e->{
      
        Parent root;
       
           double longi=s.getLongitude();
           double lat=s.getLatitude();
           String nom2=s.getNom();
           MapExample map=new MapExample(lat, longi, nom2);
           Stage stage=new Stage();
            map.start(stage);
   
   });

  }
 }
    
}
