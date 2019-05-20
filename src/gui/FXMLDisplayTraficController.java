/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import com.jfoenix.controls.JFXTextField;
import controller.traficController;
import entities.Ligne;
import entities.StatueTrafic;
import entities.Trafic;
import entities.TypeTrafic;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import jdk.nashorn.internal.objects.Global;
import org.controlsfx.control.Notifications;
import service.ServiceLigne;

/**
 * FXML Controller class
 *
 * @author anefzaoui
 */
public class FXMLDisplayTraficController implements Initializable {

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
    private TextField SEARCH_BAR;
    @FXML
    private Label H1_STATION_MANAGEMENT;
    @FXML
    private VBox pnItems;
    @FXML
    private Label COL2_LIST_TRAFIC;
    @FXML
    private Label COL1_LIST_TRAFIC;
    @FXML
    private Label COL3_LIST_TRAFIC;
    @FXML
    private Label COL4_LIST_TRAFIC;
    @FXML
    private Label lblresult;
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
    private Label BTN_ADD_NEW_Trafic;

    /**
     * Initializes the controller class.
     */
    traficController service_controller = new traficController();
    ServiceLigne service_ligne = new ServiceLigne();
    @FXML
    private Button btnMenus1;
    @FXML
    private Button btnMenus2;
    @FXML
    private ImageView retour;
    @FXML
    private Label COL5_LIST_TRAFIC;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        BTN_ADD_NEW_Trafic.setOnMouseClicked(e -> {
            Parent showligne;
            try {
                showligne = FXMLLoader.load(getClass().getResource("FXMLAddTrafic.fxml"));
                Scene scene = new Scene(showligne);

                Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
            }

        });

        laoddata();

    }

    public void laoddata() {
        loadpages();
        List<Trafic> list = service_controller.getAllTrafic();

        for (Trafic t : list) {

            HBox h1 = new HBox();
            h1.setAlignment(Pos.CENTER_LEFT);
            h1.maxHeight(Global.Infinity);
            h1.setPadding(Insets.EMPTY);

            h1.setSpacing(55.0);

            h1.setStyle("-fx-background-color: #E6E9ED; -fx-background-radius: 5; -fx-background-insets: 0;");

            Label espace2 = new Label("");
            Label espace3 = new Label("");
            Label espace4 = new Label("");
            Label espace5 = new Label("");

            Label type = new Label(t.getType().toString());
            type.setPrefSize(75, 15);
            type.setMaxSize(75, 15);
            Label status = new Label(t.getStatue().toString());

            status.setPrefSize(75, 15);
            status.setMaxSize(75, 15);

            status.prefHeight(17.0);
            status.prefWidth(112.0);

            Label date_d = new Label(t.getDateDebut() + "");
            date_d.setPrefSize(75, 15);
            date_d.setMaxSize(75, 15);

            date_d.prefHeight(17.0);
            date_d.prefWidth(112.0);

            Label date_f = new Label(t.getDateFin() + "");

            date_f.setPrefSize(75, 15);
            date_f.setMaxSize(75, 15);

            date_f.prefHeight(17.0);
            date_f.prefWidth(112.0);

            int id = t.getIdLigne();

            String nomLigne = service_ligne.searchLigneById(id).getNom();
            //   System.out.println(nomLigne+"B");

            Label nomline = new Label(nomLigne);
            nomline.setPrefSize(75, 15);
            nomline.setMaxSize(75, 15);

            nomline.prefHeight(17.0);
            nomline.prefWidth(112.0);

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

            h1.getChildren().addAll(type, status, date_d, date_f, nomline, edit, delete);

            pnItems.getChildren().add(h1);

            delete.setOnMouseClicked(e -> {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Delete Traifc");
                alert.setHeaderText("Are you sure you want to delete the following trafic: " + t.getType() + "au niveau de :" + nomLigne + "qui start le :" + t.getDateFin());
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    service_controller.supprimerTrafic(t);
                    pnItems.getChildren().remove(h1);
                }

            });

            edit.setOnMouseClicked(e -> {
                HBox v1 = new HBox();
                v1.setPrefHeight(322.0);
                v1.setPrefWidth(614.0);
                v1.setVisible(false);
                AnchorPane anchorPane = new AnchorPane();
                Label lblType = new Label();
                ComboBox<TypeTrafic> typeTrafic = new ComboBox<TypeTrafic>();
                Label lblStatue = new Label();
                ComboBox<StatueTrafic> statueTrafic = new ComboBox<StatueTrafic>();
                Label lblLigne = new Label();
                ComboBox<String> ligneTrafic = new ComboBox<String>();
                ImageView imageView = new ImageView();
                H1_STATION_MANAGEMENT = new Label();
                ImageView imageView0 = new ImageView();
                ImageView imageView1 = new ImageView();
                v1.setHgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
                anchorPane.setMaxHeight(-1.0);
                anchorPane.setMaxWidth(-1.0);
                anchorPane.setPrefHeight(258.0);
                anchorPane.setPrefWidth(481.0);
                anchorPane.setStyle("-fx-background-color: #171D26;");

                lblType.setLayoutX(297.0);
                lblType.setLayoutY(57.0);
                lblType.setPrefHeight(18.0);
                lblType.setPrefWidth(58.0);
                lblType.setStyle("-fx-background-color: #f9d900;");
                lblType.getStylesheets().add("/gui/../ressources/css/myDialogs.css");
                lblType.setText("Type:");

                typeTrafic.setLayoutX(413.0);
                typeTrafic.setLayoutY(52.0);
                typeTrafic.setPrefWidth(150.0);

                lblStatue.setLayoutX(297.0);
                lblStatue.setLayoutY(129.0);
                lblStatue.setPrefHeight(18.0);
                lblStatue.setPrefWidth(58.0);
                lblStatue.setStyle("-fx-background-color: #f9d900;");
                lblStatue.setText("Statue :");

                statueTrafic.setLayoutX(413.0);
                statueTrafic.setLayoutY(124.0);
                statueTrafic.setPrefWidth(150.0);

                lblLigne.setLayoutX(297.0);
                lblLigne.setLayoutY(196.0);
                lblLigne.setPrefHeight(21.0);
                lblLigne.setPrefWidth(66.0);
                lblLigne.setStyle("-fx-background-color: #f9d900;");
                lblLigne.setText("Ligne");

                ligneTrafic.setLayoutX(404.0);
                ligneTrafic.setLayoutY(191.0);
                ligneTrafic.setPrefHeight(28.0);
                ligneTrafic.setPrefWidth(196.0);

                imageView.setFitHeight(113.0);
                imageView.setFitWidth(119.0);
                imageView.setLayoutX(91.0);
                imageView.setLayoutY(42.0);
                imageView.setPickOnBounds(true);
                imageView.setPreserveRatio(true);
                imageView.setImage(new Image(getClass().getResource("../ressources/images/arrows.png").toExternalForm()));

                H1_STATION_MANAGEMENT.setLayoutX(8.0);
                H1_STATION_MANAGEMENT.setLayoutY(179.0);
                H1_STATION_MANAGEMENT.setPrefHeight(35.0);
                H1_STATION_MANAGEMENT.setPrefWidth(278.0);
                H1_STATION_MANAGEMENT.setText("Trafic Management - Edit");
                H1_STATION_MANAGEMENT.setTextFill(javafx.scene.paint.Color.valueOf("#fc7556"));
                H1_STATION_MANAGEMENT.setFont(new Font(24.0));

                imageView0.setFitHeight(59.0);
                imageView0.setFitWidth(76.0);
                imageView0.setLayoutX(422.0);
                imageView0.setLayoutY(249.0);
                imageView0.setPickOnBounds(true);
                imageView0.setPreserveRatio(true);
                imageView0.setImage(new Image(getClass().getResource("../ressources/images/Adlyvalidetbutton.png").toExternalForm()));

                imageView1.setFitHeight(59.0);
                imageView1.setFitWidth(66.0);
                imageView1.setLayoutX(504.0);
                imageView1.setLayoutY(249.0);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setImage(new Image(getClass().getResource("../ressources/images/error.png").toExternalForm()));

                anchorPane.getChildren().add(lblType);
                anchorPane.getChildren().add(typeTrafic);
                anchorPane.getChildren().add(lblStatue);
                anchorPane.getChildren().add(statueTrafic);
                anchorPane.getChildren().add(lblLigne);
                anchorPane.getChildren().add(ligneTrafic);
                anchorPane.getChildren().add(imageView);
                anchorPane.getChildren().add(H1_STATION_MANAGEMENT);
                anchorPane.getChildren().add(imageView0);
                anchorPane.getChildren().add(imageView1);
                v1.getChildren().add(anchorPane);
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.APPLICATION_MODAL);
                v1.setVisible(true);
                typeTrafic.setItems(FXCollections.observableArrayList(TypeTrafic.values()));
                typeTrafic.getSelectionModel().selectFirst();
                statueTrafic.setItems(FXCollections.observableArrayList(StatueTrafic.values()));
                statueTrafic.getSelectionModel().selectFirst();
                List<Ligne> listt = service_ligne.findAll();
                for (Ligne l : listt) {
                    String v = l.getNom();
                    ligneTrafic.setItems(FXCollections.observableArrayList(l.getNom()));

                }
                ligneTrafic.getSelectionModel().selectFirst();
                Scene s1 = new Scene(v1);
                dialogStage.setScene(s1);
                dialogStage.show();
                imageView0.setOnMouseClicked(ea
                        -> {

                    String tt = (String) typeTrafic.getValue().toString();
                    String ts = (String) statueTrafic.getValue().toString();
                    String ln = (String) ligneTrafic.getValue();
                    Ligne l = service_ligne.searchLineByName(ln);
                    service_controller.modifierTrafic(t, tt, ts, l.getId());

                    dialogStage.close();

                    Notifications notificationedit = Notifications.create().title("Edit Complet").text("Modifée avec success").graphic(null)
                            .hideAfter(Duration.seconds(5)).position(Pos.TOP_LEFT);
                    notificationedit.showInformation();
                });
            });
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
    

    @FXML
    private void handleClicks(ActionEvent event) {
    }
}
