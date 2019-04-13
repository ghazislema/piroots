/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ItemController implements Initializable {

    @FXML
    private HBox itemC;
    @FXML
    public Label nom;
    @FXML
    private Label moyentransport;
    @FXML
    private ImageView edit;
    @FXML
    private ImageView delete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
