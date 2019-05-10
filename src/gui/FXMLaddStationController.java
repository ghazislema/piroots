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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import service.ServiceStation;

/**
 * FXML Controller class
 *
 * @author gslema
 */
public class FXMLaddStationController implements Initializable {

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
    private JFXButton UPDATE_BTN_STATION;
    @FXML
    private Hyperlink PREV_LINK;
    @FXML
    private JFXTextField STATION_NAME;
    @FXML
    private AnchorPane BOX_NOTIF;
    @FXML
    private Label OP_SUCCESS;
    @FXML
    private AnchorPane BOX_NOTIF_WARNING;
    @FXML
    private Label OP_SUCCESS1;
    @FXML
    public JFXTextField LONGITUDE;
    @FXML
    public JFXTextField LATITUDE;
    @FXML
    private Label chooseMap;
    @FXML
    private ImageView MAP_ID;
    @FXML
    private ImageView reload_data;
    ServiceStation service = new ServiceStation();
    private ResourceBundle bundle;
    
    
    public static String generated_long;
    public static String generated_lat;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        //Chargement langage
  Loadlang(LigneMain.language);
  
  
        // TODO
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
            service.insert(a);
        });
                
                
                MAP_ID.setOnMouseClicked(e->{
                     Parent root;
       
           MapRetrievePoint map=new MapRetrievePoint();
           Stage stage=new Stage();
        map.start(stage);
        
  
                });
                
                reload_data.setOnMouseClicked(ev->{
                          LONGITUDE.setText(generated_long);
        LATITUDE.setText(generated_lat);
                });
    }    

    @FXML
    private void handleClicks(ActionEvent event) {
    }

    @FXML
    private void Back(ActionEvent event) {
    }
    
     private void Loadlang(String lang) {
  Locale locale = new Locale(lang);
  bundle = ResourceBundle.getBundle("i18n.mybundle", locale);

  PREV_LINK.setText(bundle.getString("PREV_PAGE"));
   btnOrders.setText(bundle.getString("BTN_TRIPS_MANAGEMENT"));
    BTN_LINE_MANAGEMENT.setText(bundle.getString("BTN_LINE_MANAGEMENT"));
            btnMenus.setText(bundle.getString("BTN_STATION_MANAGEMENT"));
            btnSignout.setText(bundle.getString("BTN_SIGN_OUT"));
                    STATION_NAME.setPromptText(bundle.getString("STATION_NAME"));
                    LONGITUDE.setPromptText(bundle.getString("LONGITUDE"));
                            LATITUDE.setPromptText(bundle.getString("LATITUDE"));
                            chooseMap.setText(bundle.getString("CHOSE_MAP"));
                                    UPDATE_BTN_STATION.setText(bundle.getString("SAVE"));

 }
    
}
