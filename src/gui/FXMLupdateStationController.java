/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import appMainClasses.LigneMain;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entities.Station;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import service.ServiceStation;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLupdateStationController implements Initializable {

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
    private JFXButton ADD_LINE_BTN;
    @FXML
    private JFXButton UPDATE_BTN_STATION;
    @FXML
    private Hyperlink PREV_LINK;
    @FXML
    private ComboBox<?> COMBO_BOX_TRANSP;
    @FXML
    private JFXTextField LINE_NAME;
    @FXML
    private AnchorPane BOX_NOTIF;
    @FXML
    private Label OP_SUCCESS;
    @FXML
    private AnchorPane BOX_NOTIF_WARNING;
    @FXML
    private Label OP_SUCCESS1;
    @FXML
    private JFXTextField STATION_NAME;
    @FXML
    private JFXTextField LONGITUDE;
    @FXML
    private JFXTextField LATITUDE;
    @FXML
    private Label chooseMap;
    
    private ResourceBundle bundle;

    
    
    private int id;
    /**
     * Initializes the controller class.
     */
    ServiceStation service=  new ServiceStation();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         //Chargement langage
  Loadlang(LigneMain.language);
  
        PREV_LINK.setOnAction(e->{
            Parent showligne;
            try {
                showligne = FXMLLoader.load(getClass().getResource("FXMLgestionstations.fxml"));
                 Scene scene = new Scene(showligne);
        
        
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLupdateStationController.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        });
        
        UPDATE_BTN_STATION.setOnAction(e->{
            Station a= new Station();
            a.setNom(STATION_NAME.getText());
          
            a.setLongitude(Double.parseDouble(LONGITUDE.getText()));
            a.setLatitude(Double.parseDouble(LATITUDE.getText()));
            a.setId(id);
            service.update(a);
        });
    }    

    @FXML
    private void handleClicks(ActionEvent event) {
    }

    @FXML
    private void Back(ActionEvent event) {
    }
    
    public void initData(Station s)
    {
        STATION_NAME.setText(s.getNom());
        LONGITUDE.setText(Double.toString(s.getLongitude()));
        LATITUDE.setText(Double.toString(s.getLatitude()));
        id=s.getId();
    }
    
      private void Loadlang(String lang) {
  Locale locale = new Locale(lang);
  bundle = ResourceBundle.getBundle("i18n.mybundle", locale);
  
   btnOrders.setText(bundle.getString("BTN_TRIPS_MANAGEMENT"));
    BTN_LINE_MANAGEMENT.setText(bundle.getString("BTN_LINE_MANAGEMENT"));
            btnMenus.setText(bundle.getString("BTN_STATION_MANAGEMENT"));
            btnSignout.setText(bundle.getString("BTN_SIGN_OUT"));

  PREV_LINK.setText(bundle.getString("PREV_PAGE"));
  
                    STATION_NAME.setPromptText(bundle.getString("STATION_NAME"));
                    LONGITUDE.setPromptText(bundle.getString("LONGITUDE"));
                            LATITUDE.setPromptText(bundle.getString("LATITUDE"));
                            chooseMap.setText(bundle.getString("CHOSE_MAP"));
                                    UPDATE_BTN_STATION.setText(bundle.getString("SAVE"));

 }
    
}
