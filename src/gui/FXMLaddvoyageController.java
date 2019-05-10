/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author ghazy
 */
public class FXMLaddvoyageController implements Initializable {

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
    private JFXComboBox<?> line_trip;
    @FXML
    private JFXComboBox<?> type_trip;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadform();
    }   
    
    public void loadform()
    {
        type_trip.setOnAction(e->{
            depart_time.setDisable(false);
            arrival_time.setDisable(false);
        });
        
        arrival_time.setOnAction(e->{
            date_trip.setDisable(false);
        });
        
        date_trip.setOnAction(e->{
            SAVE_BTN.setDisable(false);
        });
        
        SAVE_BTN.setOnAction(e->{
            System.out.println(line_trip.getValue());
            System.out.println(type_trip.getValue());
            System.out.println(depart_time.getValue());
            System.out.println(arrival_time.getValue());
        });
        
        
        
    }

    @FXML
    private void handleClicks(ActionEvent event) {
    }

    @FXML
    private void Back(ActionEvent event) {
    }
    
}
