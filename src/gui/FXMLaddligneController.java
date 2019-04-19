/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entities.Ligne;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import service.ServiceLigne;

/**
 * FXML Controller class
 *
 * @author ghazy
 */
public class FXMLaddligneController implements Initializable {

    @FXML
    private Label OP_SUCCESS;
    @FXML
    private AnchorPane BOX_NOTIF;
    @FXML
    private AnchorPane BOX_NOTIF_WARNING;
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
    private Hyperlink PREV_LINK;
    @FXML
    private ComboBox COMBO_BOX_TRANSP;
    @FXML
    private JFXTextField LINE_NAME;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        COMBO_BOX_TRANSP.getItems().addAll("Bus","Train","Metro");
        
        ADD_LINE_BTN.setOnAction(e->{
            
            if (COMBO_BOX_TRANSP.getValue()==null || LINE_NAME.getText()=="" )
                {
                        BOX_NOTIF_WARNING.setVisible(true);
                }
            else
                {
                
            ServiceLigne service=new ServiceLigne();
            String nom= LINE_NAME.getText();
            String transp= (String) COMBO_BOX_TRANSP.getValue();
            Ligne ligne=new Ligne();
            ligne.setNom(nom);
            ligne.setMoyentransport(transp);
            service.insert(ligne);
            
            BOX_NOTIF.setVisible(true);
            
                
                }
        });
    }    

    @FXML
    private void handleClicks(ActionEvent event) {
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
        
        Parent showligne = FXMLLoader.load(getClass().getResource("FXMLgestionlignes.fxml"));
        Scene scene = new Scene(showligne);
        
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
}
