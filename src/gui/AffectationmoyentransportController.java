/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import entities.Autobus;
import entities.Ligne;
import entities.Metro;
import entities.Train;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import service.AutobusService;
import service.MetroService;
import service.ServiceLigne;
import service.TrainService;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AffectationmoyentransportController implements Initializable {

    @FXML
    private Button btnMenus1;
    @FXML
    private Button btnOverview;
    @FXML
    private Button btnOrders;
    @FXML
    private Button BTN_LINE_MANAGEMENT;
    @FXML
    private Button btnSettings;
    @FXML
    private Button btnMenus;
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
    private JFXButton ADD_LINE_BTN;
    @FXML
    private Hyperlink PREV_LINK;
    @FXML
    private AnchorPane BOX_NOTIF;
    @FXML
    private Label OP_SUCCESS;
    @FXML
    private AnchorPane BOX_NOTIF_WARNING;
    @FXML
    private Label OP_SUCCESS1;
    @FXML
    private JFXRadioButton radio1;
    @FXML
    private JFXRadioButton radio3;
    @FXML
    private JFXRadioButton radio2;
    @FXML
    private JFXComboBox<Label> LINE_CAMBO_BAWKS;
    @FXML
    private Label tx1;
    @FXML
    private Label tx11;
    @FXML
    private JFXComboBox<Label> LINE_CAMBO_BAWKS1;

    TrainService train_service=new TrainService();
    MetroService metro_service=new MetroService();
    AutobusService bus_service=new AutobusService();
    ServiceLigne service_ligne=new ServiceLigne();
    @FXML
    private Button btnMenus2;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadpages();
        loaditems();
    }    
    
        public void loadpages()
 {
     
             btnMenus2.setOnAction(e->{
          Parent showligne;
             try {
                 showligne = FXMLLoader.load(getClass().getResource("FXMLDisplayTrafic.fxml"));
                  Scene scene = new Scene(showligne);
        
        
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
             } catch (IOException ex) {
                 Logger.getLogger(FXMLgestionstationsController.class.getName()).log(Level.SEVERE, null, ex);
             }
       
         });
     
             
              btnMenus1.setOnAction(e->{
          Parent showligne;
             try {
                 showligne = FXMLLoader.load(getClass().getResource("affectationmoyentransport.fxml"));
                  Scene scene = new Scene(showligne);
        
        
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
             } catch (IOException ex) {
                 Logger.getLogger(FXMLgestionstationsController.class.getName()).log(Level.SEVERE, null, ex);
             }
       
         });
     btnOverview.setOnAction(e->{
          Parent showligne;
             try {
                 showligne = FXMLLoader.load(getClass().getResource("HOME.fxml"));
                  Scene scene = new Scene(showligne);
        
        
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
             } catch (IOException ex) {
                 Logger.getLogger(FXMLgestionstationsController.class.getName()).log(Level.SEVERE, null, ex);
             }
       
         });
     
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
    
    
    
    
    
    
    
    
    
    public void loaditems()
    {
        
        LINE_CAMBO_BAWKS.setVisibleRowCount(4);
  final ToggleGroup group = new ToggleGroup();
  radio1.setToggleGroup(group);
  radio2.setToggleGroup(group);
  radio3.setToggleGroup(group);
  radio1.setUserData("Bus");
  radio1.setUserData("Train");
  radio1.setUserData("Metro");
  
  group.selectedToggleProperty().addListener(e->{
      RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
   String str = selectedRadioButton.getText();
   
      System.out.println(str);
   
    LINE_CAMBO_BAWKS.getItems().clear();
   
   List < Ligne > list_ligne = service_ligne.searchLineByNameTransport(str);

   for (Ligne l: list_ligne) {
    Label nom = new Label(l.getNom());
    LINE_CAMBO_BAWKS.getItems().add(nom);
   }
   
   
   
   
   
   
   
   tx1.setDisable(false);
    LINE_CAMBO_BAWKS.setDisable(false);
    tx11.setDisable(false);
   LINE_CAMBO_BAWKS1.setDisable(false);
       LINE_CAMBO_BAWKS1.getItems().clear();
   
       if (str.equals("Train"))
          {
         List<Train> list_train =    train_service.getAllTrain();
           for (Train l: list_train) {
               Label nom=new Label(l.getMatricule());
            
                LINE_CAMBO_BAWKS1.getItems().add(nom);
             }
              
          }
       else  if (str.equals("Metro"))
          {
         List<Metro> list_metro =    metro_service.getAllMetro();
           for (Metro l: list_metro) {
               Label nom=new Label(l.getMatricule());
             
                LINE_CAMBO_BAWKS1.getItems().add(nom);
             }
              
          }
       else if (str.equals("Bus"))
          {
         List<Autobus> list_bus =    bus_service.getAllBus();
           for (Autobus l: list_bus) {
               Label nom=new Label(l.getMatricule());
                LINE_CAMBO_BAWKS1.getItems().add(nom);
             }
              
          }
       
       
  });
  
  
  
  
    }

    @FXML
    private void handleClicks(ActionEvent event) {
    }

    @FXML
    private void Back(ActionEvent event) {
        
        Label lig=LINE_CAMBO_BAWKS.getValue();
        Label mat=LINE_CAMBO_BAWKS1.getValue();
       
        service_ligne.affectmeans(lig.getText(), mat.getText());
        
         Alert alert = new Alert(Alert.AlertType.WARNING);

alert.setHeaderText(null);
alert.setContentText("Vehicule affected to line successufly");

Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
    
        Parent parent;
             try {
                 parent = FXMLLoader.load(getClass().getResource("FXMLgestionlignes.fxml"));
                  Scene scene = new Scene(parent);
        
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
             } catch (IOException ex) {
                 Logger.getLogger(FXMLgestionstationsController.class.getName()).log(Level.SEVERE, null, ex);
             }
} 
        
    }
    
}
