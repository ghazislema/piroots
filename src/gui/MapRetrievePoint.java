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
import com.teamdev.jxmaps.MapMouseEvent;
import com.teamdev.jxmaps.MapOptions;
import com.teamdev.jxmaps.MapReadyHandler;
import com.teamdev.jxmaps.MapStatus;
import com.teamdev.jxmaps.MapTypeControlOptions;
import com.teamdev.jxmaps.MapViewOptions;
import com.teamdev.jxmaps.Marker;
import com.teamdev.jxmaps.javafx.MapView;
import static gui.MapExample.nom;
import static gui.MapExample.x;
import static gui.MapExample.y;
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
 * @author ghazy
 */
public class MapRetrievePoint extends Application {
   
    public static double y=9.55265;
    public static double x=35.523842;
    public static String nom;
    
    
    @Override
    public void start(Stage primaryStage) {
        
        
        // Creation of a JavaFX map view
           MapViewOptions options = new MapViewOptions();
       
        options.importPlaces();
         options.setApiKey("AIzaSyDHNR3vAW0ePVGSFhG8ABlI5LIbAHo_5FY&fbclid=IwAR2aEAzW3rxWmB4hh5Fu74bJQ3roda6Z4-f8O45jINB3z7rasfCeXhS4Qu8&libraries=places&callback=initMap");
     
        final MapView mapView = new MapView(options);

        // Setting of a ready handler to MapView object. onMapReady will be called when map initialization is done and
        // the map object is ready to use. Current implementation of onMapReady customizes the map object.
        mapView.setOnMapReadyHandler(new MapReadyHandler() {
            @Override
            public void onMapReady(MapStatus status) {
                // Check if the map is loaded correctly
                if (status == MapStatus.MAP_STATUS_OK) {
                    // Getting the associated map object
                    final Map map = mapView.getMap();
                    
                    // Creating a map options object
                    MapOptions options = new MapOptions();
                 
                    // Creating a map type control options object
                    MapTypeControlOptions controlOptions = new MapTypeControlOptions();
                    // Changing position of the map type control
                    controlOptions.setPosition(ControlPosition.TOP_RIGHT);
                    // Setting map type control options
                    options.setMapTypeControlOptions(controlOptions);
                    // Setting map options
                    map.setOptions(options);
                    // Setting the map center
                    map.setCenter(new LatLng(x, y));
                    // Setting initial zoom value
                    map.setZoom(10.0);
                
                    
                   
                     map.addEventListener("click", new MapMouseEvent() {
                         @Override
                        public void onEvent(com.teamdev.jxmaps.MouseEvent me) {
                            // Closing initially created info window
                      
                            // Creating a new marker
                            Marker marker = new Marker(map);
                            // Move marker to the position where user clicked
                            marker.setPosition(me.latLng());
                            
                            FXMLaddStationController.generated_lat=me.latLng().getLat()+"";
                            FXMLaddStationController.generated_long=me.latLng().getLng()+"";
                             System.out.println(me.latLng().getLat());
                            // Adding event listener that intercepts clicking on marker
                            marker.addEventListener("click", new MapMouseEvent() {
                             

                                @Override
                                public void onEvent(com.teamdev.jxmaps.MouseEvent me) {
                                   marker.remove(); //To change body of generated methods, choose Tools | Templates.
                                }
                            });
                        }

                     
                    });
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
