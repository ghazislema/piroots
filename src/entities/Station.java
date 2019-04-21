/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ghazy
 */
public class Station {
    
    private int id;
    private double longitude;
    private double latitude;
    private String nom;

    public Station() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    
    
    public Station(int id, double longitude, double latitude, String nom) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
    
    
}
