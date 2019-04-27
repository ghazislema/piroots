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
public class Voyage {
    
    private int id;
    private String type;
    private String heure_depart;
    private String heure_arrive;
    private String destination_depart;
    private String destination_arrive;
    private int id_chauffeur;
    private int id_ligne;

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHeure_depart(String heure_depart) {
        this.heure_depart = heure_depart;
    }

    public void setHeure_arrive(String heure_arrive) {
        this.heure_arrive = heure_arrive;
    }

    public void setDestination_depart(String destination_depart) {
        this.destination_depart = destination_depart;
    }

    public void setDestination_arrive(String destination_arrive) {
        this.destination_arrive = destination_arrive;
    }

    public void setId_chauffeur(int id_chauffeur) {
        this.id_chauffeur = id_chauffeur;
    }

    public void setId_ligne(int id_ligne) {
        this.id_ligne = id_ligne;
    }

    
    public Voyage() {
    }

    public Voyage(int id, String type, String heure_depart, String heure_arrive, String destination_depart, String destination_arrive, int id_chauffeur, int id_ligne) {
        this.id = id;
        this.type = type;
        this.heure_depart = heure_depart;
        this.heure_arrive = heure_arrive;
        this.destination_depart = destination_depart;
        this.destination_arrive = destination_arrive;
        this.id_chauffeur = id_chauffeur;
        this.id_ligne = id_ligne;
    }

    
    
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getHeure_depart() {
        return heure_depart;
    }

    public String getHeure_arrive() {
        return heure_arrive;
    }

    public String getDestination_depart() {
        return destination_depart;
    }

    public String getDestination_arrive() {
        return destination_arrive;
    }

    public int getId_chauffeur() {
        return id_chauffeur;
    }

    public int getId_ligne() {
        return id_ligne;
    }
    
    
}
