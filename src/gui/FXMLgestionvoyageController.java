/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXTextField;
import entities.Station;
import entities.Voyage;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import jdk.nashorn.internal.objects.Global;
import service.ServiceStation;
import service.ServiceVoyage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLgestionvoyageController implements Initializable {

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
    private TextField SEARCH_BAR;
    @FXML
    private Label H1_STATION_MANAGEMENT;
    @FXML
    private VBox pnItems;
    @FXML
    private Label COL2_LIST_STATION;
    @FXML
    private Label COL1_LIST_STATION;
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
    private ImageView RELOAD_BTN2;
    @FXML
    private Label BTN_ADD_NEW_TRIP;
    @FXML
    private Label   COL2_LIST_STATION11;
;
    @FXML
    private Label COL2_LIST_STATION1;
    @FXML
    private AnchorPane AnchorPANEid;
    private ResourceBundle bundle;

public ServiceVoyage service = new ServiceVoyage();
    /**
     * Initializes the controller class.
     */
    List<Voyage> list= service.findAll();
    Pagination pagination;
    
    public int itemsPerPage() {
        return 8;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
     float n = list.size();
     int pages = (int) Math.ceil(n/8);
        System.out.println(pages);
       pagination = new Pagination(pages , 0);
        pagination.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer pageIndex) {
                return remplir(pageIndex);
            }
        });
        
        AnchorPANEid.setTopAnchor(pagination, 10.0);
        AnchorPANEid.setBottomAnchor(pagination, 10.0);
        AnchorPANEid.setLeftAnchor(pagination, 10.0);
        AnchorPANEid.setRightAnchor(pagination, 10.0);
        
        AnchorPANEid.getChildren().add(pagination);
        
        BTN_ADD_NEW_TRIP.setOnMouseClicked(e->{
             Parent showligne;
             try {
                 showligne = FXMLLoader.load(getClass().getResource("FXMLaddvoyage.fxml"));
                  Scene scene = new Scene(showligne);
        
        
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
             } catch (IOException ex) {
                 Logger.getLogger(FXMLgestionstationsController.class.getName()).log(Level.SEVERE, null, ex);
             }
       
         });
    }  
    
    public VBox remplir(int pageIndex)
    {
        
      VBox box = new VBox(8);
      int page = pageIndex * itemsPerPage();
      
      
        
        for (int i = page; i < page + itemsPerPage(); i++) {
            
            try
            {
             HBox h1 = new HBox();
        h1.setAlignment(Pos.CENTER_LEFT);
   h1.maxHeight(Global.Infinity);
   h1.setPadding(Insets.EMPTY);
   h1.setSpacing(30.0);
             h1.setStyle("-fx-background-color: #E6E9ED; -fx-background-radius: 5; -fx-background-insets: 0;");
            Label idline = new Label(list.get(i).getId() + "");
   idline.setVisible(false);
   Label espace = new Label("");
   Label espace2 = new Label("");
   Label espace3 = new Label("");
   Label espace4 = new Label("");
   Label espace5 = new Label("");
   Label espace6 = new Label("");
   Label espace7 = new Label("");
   Label espace8 = new Label("");


   Label depart = new Label(list.get(i).getDestination_depart());
   depart.setPrefSize(75, 15);
   depart.setMaxSize(75, 15);
   
   Label arrive = new Label(list.get(i).getDestination_arrive());
    arrive.setPrefSize(110, 15);
   arrive.setMaxSize(110, 15);
   
   Label hdepart = new Label(list.get(i).getHeure_depart());
   hdepart.setPrefSize(80, 15);
   hdepart.setMaxSize(80, 15);
   
   Label harrive = new Label(list.get(i).getHeure_arrive());
   harrive.setPrefSize(75, 15);
   harrive.setMaxSize(75, 15);
   





   ImageView edit = new ImageView();
   edit.setFitWidth(42.0);
   edit.setFitHeight(23.0);
   edit.setPickOnBounds(true);
   edit.setPreserveRatio(true);
   edit.setImage(new Image("@../../ressources/images/icons8-search-48.png"));


   ImageView delete = new ImageView();
   delete.setFitWidth(27.0);
   delete.setFitHeight(23.0);
   delete.setPickOnBounds(true);
   delete.setPreserveRatio(true);
   delete.setImage(new Image("@../../ressources/images/trash.png"));


    

   h1.getChildren().addAll(idline, depart, espace2, arrive  ,hdepart,harrive,espace7, edit,espace5,delete);

   h1.setId(list.get(i).getId() + "");
    box.getChildren().add(h1);
        }
            catch (Exception e)
            {
                
            }
        }
 
   return box;
    }
   

    @FXML
    private void handleClicks(ActionEvent event) {
    }
       private void Loadlang(String lang) {
  Locale locale = new Locale(lang);
  bundle = ResourceBundle.getBundle("i18n.mybundle", locale);
  
   btnOrders.setText(bundle.getString("BTN_TRIPS_MANAGEMENT"));
    BTN_LINE_MANAGEMENT.setText(bundle.getString("BTN_LINE_MANAGEMENT"));
            btnMenus.setText(bundle.getString("BTN_STATION_MANAGEMENT"));
            btnSignout.setText(bundle.getString("BTN_SIGN_OUT"));

  COL1_LIST_STATION.setText(bundle.getString("DEPARTURE_STATION"));
  COL2_LIST_STATION.setText(bundle.getString("TERMINUS"));
  COL2_LIST_STATION1.setText(bundle.getString("DEPARTURE"));
  COL2_LIST_STATION11.setText(bundle.getString("ARRIVAL"));
  SEARCH_BAR.setText(bundle.getString("SEARCH_BAR"));
  BTN_ADD_NEW_TRIP.setText(bundle.getString("ADD_VOYAGE"));
  H1_STATION_MANAGEMENT.setText(bundle.getString("H1_TRIP_MANAGEMENT"));
  

 }
}
