/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import entities.Ligne;
import entities.Station;
import entities.Voyage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;
import service.ServiceLigne;
import service.ServiceStation;
import service.ServiceVoyage;

/**
 * FXML Controller class
 *
 * @author ghazy
 */
public class FXMLaddvoyageController implements Initializable {
 @FXML
    private Button btnMenus1;
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
 private JFXButton SAVE_BTN;
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
 private JFXComboBox < ? > line_trip;
 @FXML
 private JFXComboBox < String > type_trip;
 @FXML
 private ImageView MAP_ID1;
 @FXML
 private ImageView MAP_ID11;
 @FXML
 private JFXTimePicker depart_time;
 @FXML
 private JFXTimePicker arrival_time;
 @FXML
 private ImageView MAP_ID111;
 @FXML
 private JFXDatePicker date_trip;
 @FXML
 private JFXTextField test;
 @FXML
 private AnchorPane step2anchor;
 @FXML
 private AnchorPane step3anchor;


 ServiceLigne serv_ligne = new ServiceLigne();
 ServiceVoyage serv_voy = new ServiceVoyage();
 ServiceStation serv_sta = new ServiceStation();
 /**
  * Initializes the controller class.
  */
 @Override
 public void initialize(URL url, ResourceBundle rb) {
  // TODO

  loadpages();
  loadform();

  PREV_LINK.setOnAction(e -> {
   Parent showligne;
   try {
    showligne = FXMLLoader.load(getClass().getResource("FXMLgestionvoyage.fxml"));
    Scene scene = new Scene(showligne);


    Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
   } catch (IOException ex) {
    Logger.getLogger(FXMLupdateStationController.class.getName()).log(Level.SEVERE, null, ex);
   }

  });

 }


 public void loadform() {
  // ici à changer, njib ken les lignes bel trajts
  List < String > l = new ArrayList < > ();
  List < Ligne > list_l = serv_ligne.findAll_linestrajects();

  for (Ligne ligne: list_l) {
   l.add(ligne.getNom());
  }

  TextFields.bindAutoCompletion(test, l);
  type_trip.getItems().addAll("Daily", "Weekly", "Event");

  type_trip.setOnAction(e -> {
   step2anchor.setDisable(false);

  });
  arrival_time.setOnAction(e -> {
   step3anchor.setDisable(false);

  });
  date_trip.setOnAction(e -> {
   SAVE_BTN.setDisable(false);
  });

  // à corriger ici
  SAVE_BTN.setOnAction(e -> {

   Voyage a = new Voyage();

   a.setDate(date_trip.getValue() + "");
   a.setHeure_depart(depart_time.getValue() + "");
   a.setHeure_arrive(arrival_time.getValue() + "");
   a.setType(type_trip.getValue());

   try {


    Ligne ligne = serv_ligne.searchLineByName(test.getText());

    if (ligne.getNom() != null) {

     String id_station_depart = serv_ligne.id_station_depart(ligne.getNom());
     Station stat_depart = serv_sta.searchByrealID(id_station_depart);

     String id_station_arrive = serv_ligne.id_station_arrive(ligne.getNom());
     Station stat_arrive = serv_sta.searchByrealID(id_station_arrive);

     a.setDestination_depart(stat_depart.getNom());
     a.setDestination_arrive(stat_arrive.getNom());

     a.setId_ligne(ligne.getId());

     String nomligne = ligne.getNom();

     if (serv_ligne.checktraject(nomligne)) {

      serv_voy.insert(a);
      Alert alert = new Alert(Alert.AlertType.INFORMATION);

      alert.setHeaderText(null);
      alert.setContentText("Trip has been created successfully.");

      Optional < ButtonType > result = alert.showAndWait();
      if (result.get() == ButtonType.OK) {

       Parent parent;
       try {
        parent = FXMLLoader.load(getClass().getResource("FXMLgestionvoyage.fxml"));
        Scene scene = new Scene(parent);


        Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
       } catch (IOException ex) {
        Logger.getLogger(FXMLgestionstationsController.class.getName()).log(Level.SEVERE, null, ex);
       }
      }
     } else {
      Alert alert = new Alert(Alert.AlertType.WARNING);

      alert.setHeaderText("Line doesn't have a traject.");
      alert.setContentText("PS : Lines with existing trajects will appear in suggestions when typing.");
     }

    } else {
     Alert alert = new Alert(Alert.AlertType.WARNING);

     alert.setHeaderText("Line doesn't exist");
     alert.setContentText("PS : Lines with existing trajects will appear in suggestions when typing.");
     alert.showAndWait();
    }

   } catch (Exception ee) {
    Alert alert = new Alert(Alert.AlertType.WARNING);

    alert.setHeaderText("Line doesn't exist");
    alert.setContentText("PS : Valid Lines with existing trajects will appear in suggestions when typing.");
    alert.showAndWait();
   }



  });



 }

 @FXML
 private void handleClicks(ActionEvent event) {}

 @FXML
 private void Back(ActionEvent event) {}
 public void loadpages() {
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
  btnOrders.setOnAction(e -> {
   Parent showligne;
   try {
    showligne = FXMLLoader.load(getClass().getResource("FXMLgestionvoyage.fxml"));
    Scene scene = new Scene(showligne);


    Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
   } catch (IOException ex) {
    Logger.getLogger(FXMLgestionstationsController.class.getName()).log(Level.SEVERE, null, ex);
   }

  });

  BTN_LINE_MANAGEMENT.setOnAction(e -> {

   Parent showligne;
   try {
    showligne = FXMLLoader.load(getClass().getResource("FXMLgestionlignes.fxml"));
    Scene scene = new Scene(showligne);


    Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
   } catch (IOException ex) {
    Logger.getLogger(FXMLgestionstationsController.class.getName()).log(Level.SEVERE, null, ex);
   }

  });

  btnSettings.setOnAction(e -> {
   Parent showligne;
   try {
    showligne = FXMLLoader.load(getClass().getResource("RoadConstruction.fxml"));
    Scene scene = new Scene(showligne);


    Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
   } catch (IOException ex) {
    Logger.getLogger(FXMLgestionstationsController.class.getName()).log(Level.SEVERE, null, ex);
   }

  });
  btnMenus.setOnAction(e -> {
   Parent showligne;
   try {
    showligne = FXMLLoader.load(getClass().getResource("FXMLgestionstations.fxml"));
    Scene scene = new Scene(showligne);


    Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
   } catch (IOException ex) {
    Logger.getLogger(FXMLgestionstationsController.class.getName()).log(Level.SEVERE, null, ex);
   }

  });
  btnSignout.setOnAction(e -> {
   Parent showligne;
   try {
    showligne = FXMLLoader.load(getClass().getResource("FXMLlogin.fxml"));
    Scene scene = new Scene(showligne);


    Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
   } catch (IOException ex) {
    Logger.getLogger(FXMLgestionstationsController.class.getName()).log(Level.SEVERE, null, ex);
   }

  });

 }
}