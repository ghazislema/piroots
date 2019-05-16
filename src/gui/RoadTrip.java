/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.teamdev.jxmaps.ControlPosition;
import com.teamdev.jxmaps.InfoWindow;
import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.MapOptions;
import com.teamdev.jxmaps.MapReadyHandler;
import com.teamdev.jxmaps.MapStatus;
import com.teamdev.jxmaps.MapTypeControlOptions;
import com.teamdev.jxmaps.MapViewOptions;
import com.teamdev.jxmaps.Marker;
import com.teamdev.jxmaps.Polyline;
import com.teamdev.jxmaps.PolylineOptions;
import com.teamdev.jxmaps.javafx.MapView;
import entities.Station;
import static gui.MapExample.nom;
import static gui.TestingTraject.list;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class RoadTrip extends Application {
    public static List < Station > list = new ArrayList < > ();
 public static double x = 36.832130;
 public static double y = 36.832130;
 public static String nom;
    @Override
    public void start(Stage primaryStage) {
        MapViewOptions options = new MapViewOptions();

  options.importPlaces();
  options.setApiKey("AIzaSyDHNR3vAW0ePVGSFhG8ABlI5LIbAHo_5FY&fbclid=IwAR2aEAzW3rxWmB4hh5Fu74bJQ3roda6Z4-f8O45jINB3z7rasfCeXhS4Qu8&libraries=places&callback=initMap");

  final MapView mapView = new MapView(options);

  mapView.setOnMapReadyHandler(new MapReadyHandler() {
   @Override
   public void onMapReady(MapStatus status) {

    if (status == MapStatus.MAP_STATUS_OK) {

     final Map map = mapView.getMap();


     MapOptions options = new MapOptions();


     MapTypeControlOptions controlOptions = new MapTypeControlOptions();

     controlOptions.setPosition(ControlPosition.TOP_RIGHT);

     options.setMapTypeControlOptions(controlOptions);

     map.setOptions(options);

     map.setCenter(new LatLng(y, x));

     map.setZoom(10.0);

     int n = list.size();
     

     for (int i = 0; i < list.size(); i++) {
         Marker marker = new Marker(map);
     marker.setPosition(new LatLng(list.get(i).getLatitude(),
      list.get(i).getLongitude()));
     
     if (i==0)
     {
     final InfoWindow window = new InfoWindow(map);
                                window.setContent("Departure point: "+list.get(i).getNom());
                                window.open(map, marker);    
         
     }
     if (i==list.size()-1)
     {
       final InfoWindow window = new InfoWindow(map);
                                window.setContent("Arrival point: "+list.get(i).getNom());
                                window.open(map, marker);    
     }
     }


 int nn = list.size();
     LatLng[] path = new LatLng[nn];

for (int i = 0; i < list.size(); i++) {
      path[i] = new LatLng(list.get(i).getLatitude(), list.get(i).getLongitude());
     }


     Polyline polyline = new Polyline(map);


     polyline.setPath(path);

     PolylineOptions options2 = new PolylineOptions();
 

 

     options2.setGeodesic(true);

     options2.setStrokeColor("#FF0000");

     options2.setStrokeOpacity(1.0);

     options2.setStrokeWeight(2.0);

     polyline.setOptions(options2);

     Marker marker = new Marker(map);
     marker.setPosition(new LatLng(list.get(0).getLatitude(),
      list.get(0).getLongitude()));


     Marker marker2 = new Marker(map);
     marker2.setPosition(new LatLng(list.get(list.size() - 1).getLatitude(),
      list.get(list.size() - 1).getLongitude()));


    }
   }
  });

  Scene scene = new Scene(new BorderPane(mapView), 700, 500);
  primaryStage.setScene(scene);
  primaryStage.show();
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
