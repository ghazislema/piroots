/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.InfoWindow;
import com.lynden.gmapsfx.javascript.object.InfoWindowOptions;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.sun.prism.PhongMaterial.MapType;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author ghazy
 */
public class FXMLmaptesterController implements Initializable,MapComponentInitializedListener {

    @FXML
    private GoogleMapView mapView;
    
    private GoogleMap map;
    
    public static double x=36.832130;
    public static double y=36.832130;
    public static String nom="Lac 2, Tunis";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mapView =new GoogleMapView("en-US", "AIzaSyDHNR3vAW0ePVGSFhG8ABlI5LIbAHo_5FY");
         mapView.addMapInializedListener(this);
    }    
    
    public void mapInitialized() {
        
        
        //Set the initial properties of the map.
        MapOptions mapOptions = new MapOptions();
      
        mapOptions.center(new LatLong(47.6097, -122.3331))
                .mapType(MapTypeIdEnum.ROADMAP)
                
                .zoom(12);
                   
        map = mapView.createMap(mapOptions);

        //Add markers to the map
      
    }   
    
}
