/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXTextField;
import entities.TypeTrafic;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import service.ServiceLigne;
import service.ServiceTrafic;

/**
 * FXML Controller class
 *
 * @author user
 */
public class HOMEController implements Initializable {
 @FXML
    private Button btnMenus1;
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
    private Label H1_STATION_MANAGEMENT;
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
    private Pane paneCharts;

  
    
    private final ObservableList<PieChart.Data> details = FXCollections.observableArrayList();
    
    private PieChart piechart;

    ServiceLigne service_ligne= new ServiceLigne();
    @FXML
    private Button btnMenus2;
    @FXML
    private Pane paneCharts1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadpages();
        paneCharts.setEffect(new DropShadow(5  , 5, 10, Color.GREY));
        double nb_bus=service_ligne.lines_bybus();
        double nb_train=service_ligne.lines_bytrain();
        double nb_metro=service_ligne.lines_byMetro();
        
        int n1= (int) (nb_bus*100/(nb_bus+nb_train+nb_metro));
        int n2= (int) (nb_train*100/(nb_bus+nb_train+nb_metro));
        int n3= (int) (nb_metro*100/(nb_bus+nb_train+nb_metro));
  
        
        details.addAll(new PieChart.Data("Bus lines "+ n1+"%", nb_bus),
                new PieChart.Data("Train lines "+n2+"%", nb_train),
                new PieChart.Data("Tramway lines "+n3+"%", nb_metro));
        
        piechart = new PieChart();
         piechart.setPrefSize(325, 325);
        piechart.setData(details);
       piechart.setTitle("Lines by Means of transport");
   //     piechart.setLegendSide(Side.TOP);
        piechart.setLabelsVisible(true);
       paneCharts.getChildren().add(piechart);
         CategoryAxis xAxis = new CategoryAxis();
         NumberAxis yAxis = new NumberAxis();
      BarChart<String,Number> bc = new BarChart<>(xAxis,yAxis);
        bc.setTitle("Trafic Par Année");
        xAxis.setLabel("year");       
        yAxis.setLabel("number");
        ServiceTrafic st = new ServiceTrafic();
          XYChart.Series series1 = new XYChart.Series();
        series1.setName("2019");       
        series1.getData().add(new XYChart.Data(TypeTrafic.maintenance.toString(), st.traficmain()));
        series1.getData().add(new XYChart.Data(TypeTrafic.mesuresDeSecurite.toString(), st.traficMS()));
        series1.getData().add(new XYChart.Data(TypeTrafic.facteursNaturels.toString(),st.trafiFN())); 
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("2020");
        series2.getData().add(new XYChart.Data(TypeTrafic.maintenance.toString(), st.traficmain()));
        series2.getData().add(new XYChart.Data(TypeTrafic.mesuresDeSecurite.toString(), st.traficMS()));
        series2.getData().add(new XYChart.Data(TypeTrafic.facteursNaturels.toString(),st.trafiFN())); 
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("2021");
        series1.getData().add(new XYChart.Data(TypeTrafic.maintenance.toString(), st.traficmain()));
        series1.getData().add(new XYChart.Data(TypeTrafic.mesuresDeSecurite.toString(), st.traficMS()));
        series1.getData().add(new XYChart.Data(TypeTrafic.facteursNaturels.toString(),st.trafiFN())); 
        
        bc.getData().addAll(series1, series2, series3);
        
         bc.setPrefSize(500, 325);
         paneCharts1.setEffect(new DropShadow(5  , 5, 10, Color.GREY));
        paneCharts1.getChildren().add(bc);
        
        
    }    

    @FXML
    private void handleClicks(ActionEvent event) {
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
