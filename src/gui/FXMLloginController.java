/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLloginController implements Initializable {

    @FXML
    private Hyperlink EN_BTN;
    
    @FXML
    private Hyperlink FR_BTN;
    
    @FXML
    private JFXTextField USERNAME;
    @FXML
    private JFXPasswordField PASSWORD;
    @FXML
    private JFXButton SIGNIN_BTN;
    @FXML
    private CheckBox REMEMBER_ME;
    @FXML
    private Hyperlink FORGOTPW_LINK;
    @FXML
    private Label H1;
    @FXML
    private Label H2;
    @FXML
    private JFXButton SIGNUP_BTN;
    @FXML
    private Label H3;
    @FXML
    private Label H4;
    @FXML
    private Label H5;
    @FXML
    private Label H6;

    private ResourceBundle bundle;
    private Locale locale;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }    
    
    @FXML
    private void btn_en(ActionEvent event) 
    {
        Loadlang("en");
    }
    @FXML
    private void btn_fr(ActionEvent event) 
    {
        Loadlang("fr");
    }
    
    private void Loadlang(String lang)
    {
         Locale locale= new Locale(lang);
         bundle = ResourceBundle.getBundle("i18n.mybundle",locale);
         
         USERNAME.setPromptText(bundle.getString("USERNAME"));
         PASSWORD.setPromptText(bundle.getString("PASSWORD"));
         SIGNIN_BTN.setText(bundle.getString("LOGIN_BTN"));
         REMEMBER_ME.setText(bundle.getString("REMEMBER_ME"));
         FORGOTPW_LINK.setText(bundle.getString("FORGOT_PW"));
         
         H1.setText(bundle.getString("H1"));
         H2.setText(bundle.getString("H2"));
         H3.setText(bundle.getString("H3"));
         H4.setText(bundle.getString("H4"));
         H5.setText(bundle.getString("H5"));
         H6.setText(bundle.getString("H6"));
         SIGNUP_BTN.setText(bundle.getString("SIGNUP"));
         
        
            
//         FXMLgestionlignesController gestionLignes = new FXMLgestionlignesController();
//         gestionLignes.loadLoginGuiLang(bundle);
        
    }
    
    @FXML
    public void Back(ActionEvent event) throws IOException {

       
        Parent showligne = FXMLLoader.load(getClass().getResource("FXMLgestionlignes.fxml"));
        Scene scene = new Scene(showligne);
        
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
   
    
}
