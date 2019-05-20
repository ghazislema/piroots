/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Timestamp;

/**
 *
 * @author Adly
 */
public class Trafic {
    
    private int id;
    private TypeTrafic type;
    private StatueTrafic statue;
    private String description;
    private String dateDebut;
    private String dateFin;
    private int idLigne;
 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeTrafic getType() {
        return type;
    }

    public void setType(TypeTrafic type) {
        this.type = type;
    }

    public StatueTrafic getStatue() {
        return statue;
    }

    public void setStatue(StatueTrafic statue) {
        this.statue = statue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdLigne() {
        return idLigne;
    }

    public void setIdLigne(int idLigne) {
        this.idLigne = idLigne;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public Trafic(int id, TypeTrafic type, StatueTrafic statue, String description, String dateDebut, String dateFin, int idLigne) {
        this.id = id;
        this.type = type;
        this.statue = statue;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.idLigne = idLigne;
    }
    public Trafic(TypeTrafic type, StatueTrafic statue, String description, String dateDebut, String dateFin, int idLigne) {
      
        this.type = type;
        this.statue = statue;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.idLigne = idLigne;
    }

    @Override
    public String toString() {
        return "Trafic{" + "id=" + id + ", type=" + type + ", statue=" + statue + ", description=" + description + ", ateDebut=" + dateDebut + ", dateFin=" + dateFin + ", idLigne=" + idLigne + '}';
    }

   
    
    
}
