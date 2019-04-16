/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
import javafx.geometry.Insets;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLgestionlignesController implements Initializable {

    @FXML
    private Button btnOverview;
    @FXML
    private Button btnOrders;
    @FXML
    private Button btnCustomers;
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
    private HBox itemC;
    @FXML
    private Button btnOrders1;

    ObservableList<Ligne> lignes = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        recupererLignes();
        
    }    

      public void recupererLignes() {

        
        lignes.clear();
        List<Ligne> list = null;
        ServiceLigne service= new ServiceLigne();
        
        list = service.findAll();
       
        for (Ligne ligne : list) {
            
             HBox h1 = new HBox();
             h1.setAlignment(Pos.CENTER_LEFT);
             h1.maxHeight(Global.Infinity);
             h1.setPadding(Insets.EMPTY);
             h1.setPrefHeight(70.0);
             h1.setPrefWidth(733.0);
            h1.setSpacing(55.0);
            
            
            h1.setStyle("-fx-background-color: #E6E9ED; -fx-background-radius: 5; -fx-background-insets: 0;");
       
             Label espace = new Label("");
             Label espace2 = new Label("");
             Label espace3 = new Label("");
             Label espace4 = new Label("");
             Label espace5 = new Label("");
            
             
             Label nom=new Label(ligne.getNom());
             nom.prefHeight(17.0);
             nom.prefWidth(234.0);
             
             Label moyenTransp = new Label(ligne.getMoyentransport());
             moyenTransp.prefHeight(17.0);
             moyenTransp.prefWidth(234.0);
             moyenTransp.setPrefSize(75 , 15);
            moyenTransp.setMaxSize(75      , 15);
             
             
             moyenTransp.prefHeight(17.0);
             moyenTransp.prefWidth(112.0);
            
             
             
                   
                    ImageView edit= new ImageView();
                   edit.setFitWidth(42.0);
                   edit.setFitHeight(23.0);
                   edit.setPickOnBounds(true);
                   edit.setPreserveRatio(true);
                  edit.setImage(new Image("@../../ressources/images/edit.png"));
                
                   
                    ImageView delete= new ImageView();
                   delete.setFitWidth(27.0);
                   delete.setFitHeight(23.0);
                   delete.setPickOnBounds(true);
                   delete.setPreserveRatio(true);
                   delete.setImage(new Image("@../../ressources/images/trash.png"));
                   
                  
                    h1.getChildren().addAll(espace,nom,espace2,moyenTransp,espace4,espace5
                            ,edit,espace3,delete);
                    pnItems.getChildren().add(h1);
           
        }
        
    
}
    @FXML
    private void handleClicks(ActionEvent event) {
    }
    
}
