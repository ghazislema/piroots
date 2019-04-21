/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXTextField;
import entities.Ligne;
import entities.Station;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import jdk.nashorn.internal.objects.Global;
import service.ServiceLigne;
import service.ServiceStation;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLgestionstationsController implements Initializable {

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
    private Button BTN_ADD_NEW_STATION;
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

    public ServiceStation service = new ServiceStation();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         recupererStations(service.findAll());
    }    

    @FXML
    private void handleClicks(ActionEvent event) {
    }
    
    
    
     public void recupererStations(List<Station> list) {


  for (Station s: list) {

   HBox h1 = new HBox();
   h1.setAlignment(Pos.CENTER_LEFT);
   h1.maxHeight(Global.Infinity);
   h1.setPadding(Insets.EMPTY);

   h1.setSpacing(30.0);

   h1.setStyle("-fx-background-color: #E6E9ED; -fx-background-radius: 5; -fx-background-insets: 0;");

   Label idline = new Label(s.getId() + "");
   idline.setVisible(false);
   Label espace = new Label("");
   Label espace2 = new Label("");
   Label espace3 = new Label("");
   Label espace4 = new Label("");
   Label espace5 = new Label("");
   Label espace6 = new Label("");
   Label espace7 = new Label("");
   Label espace8 = new Label("");


   Label nom = new Label(s.getNom());
   nom.setPrefSize(75, 15);
   nom.setMaxSize(75, 15);
   Label coord = new Label(s.getLongitude()+ " , "+s.getLatitude());


   coord.setPrefSize(160, 15);
   coord.setMaxSize(160, 15);




   ImageView edit = new ImageView();
   edit.setFitWidth(42.0);
   edit.setFitHeight(23.0);
   edit.setPickOnBounds(true);
   edit.setPreserveRatio(true);
   edit.setImage(new Image("@../../ressources/images/edit.png"));


   ImageView delete = new ImageView();
   delete.setFitWidth(27.0);
   delete.setFitHeight(23.0);
   delete.setPickOnBounds(true);
   delete.setPreserveRatio(true);
   delete.setImage(new Image("@../../ressources/images/trash.png"));


      ImageView inspect = new ImageView();
   inspect.setFitWidth(27.0);
   inspect.setFitHeight(23.0);
   inspect.setPickOnBounds(true);
   inspect.setPreserveRatio(true);
   inspect.setImage(new Image("@../../ressources/images/icons8-search-48.png"));


   h1.getChildren().addAll(idline, nom, espace2, coord, espace4, inspect ,espace,espace5,espace6,espace7, edit, espace3, delete);

   h1.setId(s.getId() + "");

   pnItems.getChildren().add(h1);

   delete.setOnMouseClicked(e -> {
    service.delete(s.getId());

    pnItems.getChildren().remove(h1);

   });

   edit.setOnMouseClicked(e -> {

    ANCHOR_UPDATE.setVisible(true);
    LINE_NAME.setText(nom.getText());
    int id = s.getId();
    LINE_ID.setText(id + "");

   });

  }
 }
    
}
