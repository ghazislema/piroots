/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.ServiceLigne;
import entities.Ligne;

/**
 * FXML Controller class
 *
 * @author ghazy
 */
public class FXMLaddligneController implements Initializable {

    @FXML
    private TextField d_depart;
    @FXML
    private TextField d_arrive;
    @FXML
    private Button ajouter;
    @FXML
    private JFXTimePicker heure_arrive;
    @FXML
    private JFXTimePicker heure_depart;
    @FXML
    private JFXDatePicker date_depart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
         ajouter.setOnAction((event) -> {
           
            String depart=d_depart.getText();
            String arrive=d_arrive.getText();

            
            LocalTime heured=heure_depart.getValue();
            LocalTime heurea=heure_arrive.getValue();
            
            LocalDate date=date_depart.getValue();
            System.out.println(""+depart+ "   "+arrive+ " depart = "+heured);
            
            String timed=heured+"";
            String timea=heurea+"";
            String dateligne=date+"";
            
            ServiceLigne service=new ServiceLigne();
            
//            Ligne a=new Ligne(depart, arrive, timed , timea , dateligne);
//            service.insert(a);
            
        });
    }    
    
    @FXML
    public void ShowListLignes(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("FXMLlistelignes.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
