/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.gluonhq.charm.glisten.control.BottomNavigationButton;
import com.gluonhq.charm.glisten.control.Message;
import controller.traficController;
import entities.Ligne;
import entities.StatueTrafic;
import entities.Trafic;
import entities.TypeTrafic;
import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import service.ServiceLigne;

/**
 * FXML Controller class
 *
 * @author anefzaoui
 */
public class FXMLAddTraficController implements Initializable {

    @FXML
    private Button btnOverview;
    @FXML
    private Button btnOrders;
    @FXML
    private Button BTN_LINE_MANAGEMENT;
    @FXML
    private Button btnSettings;
    @FXML
    private Button btnMenus;
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
    private Label lblType;
    @FXML
    private ComboBox<TypeTrafic> typeTrafic;
    @FXML
    private Label lblStatue;
    @FXML
    private ComboBox<StatueTrafic> statueTrafic;
    @FXML
    private Label lbldd;
    @FXML
    private Label lbldf;
    @FXML
    private DatePicker dDebut;
    @FXML
    private DatePicker dFin;
    @FXML
    private Label lbldescri;
    @FXML
    private TextArea discTrafic;
    @FXML
    private Label lblLigne;
    @FXML
    private ComboBox<String> ligneTrafic;
    @FXML
    private Button Valider;
    @FXML
    private Button retourbtn;
      @FXML
    private AnchorPane BOX_NOTIF;
    @FXML
    private AnchorPane BOX_NOTIF_WARNING;
    
    @FXML
    private AnchorPane BOX_DATE_WARNING;

    /**
     * Initializes the controller class.
     */
    traficController service_controller = new traficController();
    ServiceLigne service_ligne = new ServiceLigne();
    @FXML
    private Label OP_SUCCESS;
    @FXML
    private Label OP_SUCCESS1;
    @FXML
    private Label OP_SUCCESS13;
    @FXML
    private Label H1_STATION_MANAGEMENT;
    @FXML
    private ImageView retour;
    @FXML
    private Button btnMenus1;
    @FXML
    private Button btnMenus2;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadpages();
        retourbtn.setOnAction(e->{
            Parent showligne;
            try {
                showligne = FXMLLoader.load(getClass().getResource("FXMLDisplayTrafic.fxml"));
                 Scene scene = new Scene(showligne);
        
        
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
            } catch (IOException ex) {
            }
       
        });
        
        Valider.setOnAction(e->{
        if (ligneTrafic.getValue()==null || typeTrafic.getValue() == null || statueTrafic == null || discTrafic.getText()==null
                    || dDebut.getValue() == null || dFin.getValue() == null )
                {
                    BOX_NOTIF_WARNING.setVisible(true);
                    BOX_NOTIF.setVisible(false);
                    BOX_DATE_WARNING.setVisible(false);
                }
       
        else {
            if (dDebut.getValue().isAfter(dFin.getValue()))
        {
                    BOX_DATE_WARNING.setVisible(true);
                    BOX_NOTIF.setVisible(false);
                    BOX_NOTIF_WARNING.setVisible(false);
                }
            else 
                {
                    
                
            traficController tc = new traficController();
            
            String tt =(String) typeTrafic.getValue().toString() ;
            String ts = (String) statueTrafic.getValue().toString();
            String td =  lbldescri.getText();
            String ln = (String) ligneTrafic.getValue() ;
            String dd = dDebut.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
           String df = dFin.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
          Ligne l =  service_ligne.searchLineByName(ln);
           Trafic t = new Trafic(TypeTrafic.valueOf(tt), StatueTrafic.valueOf(ts), td, dd, df, l.getId());
           tc.ajouterTrafic(t);
           BOX_NOTIF.setVisible(true);
            
                     PauseTransition delay = new PauseTransition(Duration.seconds(5));
                    delay.setOnFinished( event -> 
                     {
                     BOX_NOTIF.setVisible(true);
                     BOX_DATE_WARNING.setVisible(false);
                     Notifications notificationsajout = Notifications.create().title("ajout de trafic").text("Ajout avec success").graphic(null)
                            .hideAfter(Duration.seconds(5)).position(Pos.BASELINE_RIGHT);
                    notificationsajout.showConfirm();
                     });
                    delay.play();
                 
                    
            
            
            BOX_NOTIF_WARNING.setVisible(false);
            BOX_DATE_WARNING.setVisible(false);
            
            //MAIL
            /*
            try{
            String host ="smtp.gmail.com" ;
            String user = "dournath@gmail.com";
            String pass = "kteckgjstjxvjulx";
            String to = "ouaghlani.karimm@gmail.com";
            String from = "dournath@gmail.com";
            String subject = "Trafic";
            String messageText = "Messsageé";
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
        }catch(Exception ex)
        {
            System.out.println(ex);
        }*/
            
            
            
            
            Parent showligne;
            try {
                showligne = FXMLLoader.load(getClass().getResource("FXMLDisplayTrafic.fxml"));// bdaelha lel main page
                 Scene scene = new Scene(showligne);
        
        
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
            } catch (IOException ex) {
            }
        }}
        });
        laoddata();
       
    }    

    @FXML
    private void handleClicks(ActionEvent event) {
    }
        public void retour(ActionEvent event) throws IOException {

        FXMLLoader Loder = new FXMLLoader();
                        Loder.setLocation(getClass().getResource("FXMLDisplayTrafic.fxml"));
                        Loder.load();
                      
                        Parent AnchorPane = Loder.getRoot();
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                          Scene scene = new Scene(AnchorPane);
                         stage.setScene(scene);
                        stage.showAndWait();
    }
        
        
        public void laoddata()
    {
        
    typeTrafic.setItems( FXCollections.observableArrayList( TypeTrafic.values()));
    statueTrafic.setItems( FXCollections.observableArrayList( StatueTrafic.values()));
    List<Ligne> list=service_ligne.findAll();
    for(Ligne l : list)
    {
        String v = l.getNom();
        ligneTrafic.setItems(FXCollections.observableArrayList(l.getNom()));
   
    }
    
    }
            public void loadpages()
 {
     
             btnMenus2.setOnAction(e->{
          Parent showligne;
             try {
                 showligne = FXMLLoader.load(getClass().getResource("FXMLDisplayTrafic.fxml"));
                  Scene scene = new Scene(showligne);
        
        
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
             } catch (IOException ex) {
                 Logger.getLogger(FXMLgestionstationsController.class.getName()).log(Level.SEVERE, null, ex);
             }
       
         });
     
             
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
     
      btnOrders.setOnAction(e->{
          Parent showligne;
             try {
                 showligne = FXMLLoader.load(getClass().getResource("FXMLgestionvoyage.fxml"));
                  Scene scene = new Scene(showligne);
        
        
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
             } catch (IOException ex) {
                 Logger.getLogger(FXMLgestionstationsController.class.getName()).log(Level.SEVERE, null, ex);
             }
       
         });
     
     BTN_LINE_MANAGEMENT.setOnAction(e->{
         
          Parent showligne;
             try {
                 showligne = FXMLLoader.load(getClass().getResource("FXMLgestionlignes.fxml"));
                  Scene scene = new Scene(showligne);
        
        
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
             } catch (IOException ex) {
                 Logger.getLogger(FXMLgestionstationsController.class.getName()).log(Level.SEVERE, null, ex);
             }
         
     });
     
     btnSettings.setOnAction(e->{
         Parent showligne;
             try {
                 showligne = FXMLLoader.load(getClass().getResource("RoadConstruction.fxml"));
                  Scene scene = new Scene(showligne);
        
        
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
             } catch (IOException ex) {
                 Logger.getLogger(FXMLgestionstationsController.class.getName()).log(Level.SEVERE, null, ex);
             }
         
     });
     btnMenus.setOnAction(e->{
         Parent showligne;
             try {
                 showligne = FXMLLoader.load(getClass().getResource("FXMLgestionstations.fxml"));
                  Scene scene = new Scene(showligne);
        
        
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
             } catch (IOException ex) {
                 Logger.getLogger(FXMLgestionstationsController.class.getName()).log(Level.SEVERE, null, ex);
             }
         
     });
     btnSignout.setOnAction(e->{
          Parent showligne;
             try {
                 showligne = FXMLLoader.load(getClass().getResource("FXMLlogin.fxml"));
                  Scene scene = new Scene(showligne);
        
        
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
             } catch (IOException ex) {
                 Logger.getLogger(FXMLgestionstationsController.class.getName()).log(Level.SEVERE, null, ex);
             }
         
     });
        
 }
    
    
}
