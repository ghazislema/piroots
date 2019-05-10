/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXAutoCompletePopup;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import entities.Ligne;
import entities.Station;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import service.ServiceLigne;
import service.ServiceStation;

/**
 * FXML Controller class
 *
 * @author user
 */
public class RoadConstructionController implements Initializable {

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
    private Label H1_LINE_MANAGEMENT;
    @FXML
    private VBox pnItems;
    @FXML
    private Label COL2_LIST_LIGNE;
    @FXML
    private Label COL1_LIST_LIGNE;
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
    @FXML
    private Label BTN_ADD_NEW_LINE;
    @FXML
    private JFXComboBox<Label> LINE_CAMBO_BAWKS;
    @FXML
    private RadioButton radio1;
    @FXML
    private RadioButton radio2;
    @FXML
    private RadioButton radio3;
    @FXML
    private Label tx1;
    @FXML
    private Label tx2;
    @FXML
    private JFXComboBox combo_depart;
    @FXML
    private JFXComboBox combo_arrive;
    @FXML
    private Label tx3;
    @FXML
    private JFXRadioButton manual;
    @FXML
    private JFXRadioButton Automatic1;
    @FXML
    private Hyperlink next1;
    @FXML
    private AnchorPane STEP1_ANCHOR;
    @FXML
    private AnchorPane STEP2_ANCHOR;
    

    ServiceStation serv_station= new ServiceStation();
    ServiceLigne serv_ligne= new ServiceLigne();
    /**
     * Initializes the controller class.
     */
    
    public void retrievedata()
    {
        
        LINE_CAMBO_BAWKS.setVisibleRowCount(4);
        final ToggleGroup group = new ToggleGroup();
        radio1.setToggleGroup(group);
        radio2.setToggleGroup(group);
        radio3.setToggleGroup(group);
        
        group.selectedToggleProperty().addListener(e->{
            RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
            String str = selectedRadioButton.getText();
            System.out.println(str);
            List<Ligne> list_ligne= serv_ligne.searchLineByNameTransport(str);
            
            LINE_CAMBO_BAWKS.setDisable(false);
            tx1.setDisable(false); 
            
            for (Ligne l : list_ligne)
                 {
                 Label nom=new Label(l.getNom());
                 LINE_CAMBO_BAWKS.getItems().add(nom);
                 }
            
        });
          LINE_CAMBO_BAWKS.setOnAction(ex->{
                 String line=LINE_CAMBO_BAWKS.getValue().getText();
                 System.out.println(line);
                 
                 combo_depart.setDisable(false);
                 tx2.setDisable(false);
                 combo_arrive.setDisable(false);
                 
             });
          
          List<Station> list_station= serv_station.findAll();
          list_station.stream().map((s) -> s.getNom()).map((nom) -> {
              combo_arrive.getItems().add(nom);
            return nom;
        }).forEachOrdered((nom) -> {
            combo_depart.getItems().add(nom);
        });
          
          
          combo_arrive.setOnAction(evv->{
              tx3.setDisable(false);
              manual.setDisable(false);
              Automatic1.setDisable(false);
              
              
          });
          
          next1.setOnAction(ev2->{
              STEP1_ANCHOR.setVisible(false);
              STEP2_ANCHOR.setVisible(true);
          });
          
          
          
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
     retrievedata();
    List<Station> list_station=  serv_station.findAll();
//    List<Ligne> list_ligne= serv_ligne.searchLineByNameTransport(str);
//     LINE_CAMBO_BAWKS.setVisibleRowCount(5);

 

        
    }    

    @FXML
    private void handleClicks(ActionEvent event) {
    }
    @FXML
    private void Back(ActionEvent event) {
    }
    
}
