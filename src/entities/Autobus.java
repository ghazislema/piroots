/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author user
 */
public class Autobus {
    
    private int id;
    private String model;
    private double kilometrage;
     private Ligne ligne;
    private String matricule;
    private int nombreplace;
    private String datemiseencirculation;
    private String datemaintenance;
    private String datedernierrevision;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ligne getLigne() {
        return ligne;
    }

    public void setLigne(Ligne ligne) {
        this.ligne = ligne;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public int getNombreplace() {
        return nombreplace;
    }

    public void setNombreplace(int nombreplace) {
        this.nombreplace = nombreplace;
    }

    public String getDatemiseencirculation() {
        return datemiseencirculation;
    }

    public void setDatemiseencirculation(String datemiseencirculation) {
        this.datemiseencirculation = datemiseencirculation;
    }

    public String getDatemaintenance() {
        return datemaintenance;
    }

    public void setDatemaintenance(String datemaintenance) {
        this.datemaintenance = datemaintenance;
    }

    public String getDatedernierrevision() {
        return datedernierrevision;
    }

    public void setDatedernierrevision(String datedernierrevision) {
        this.datedernierrevision = datedernierrevision;
    }
    
     public Autobus(String matricule, int nombreplace, double kilometrage,  String datemiseencirculation, String datemaintenance, String revi, String model) {
        this.matricule = matricule;
        this.nombreplace = nombreplace;
        this.kilometrage = kilometrage;
        this.datemiseencirculation=datemiseencirculation;
        this.datemaintenance = datemaintenance;
        this.datedernierrevision = revi;
        this.model = model;
      
             
        
    }

    public Autobus() {
    }

    @Override
    public String toString() {
        return "Autobus{" + "id=" + id + ", model=" + model + ", kilometrage=" + kilometrage + ", ligne=" + ligne + ", matricule=" + matricule + ", nombreplace=" + nombreplace + ", datemiseencirculation=" + datemiseencirculation + ", datemaintenance=" + datemaintenance + ", datedernierrevision=" + datedernierrevision + '}';
    }



    public double getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(double kilometrage) {
        this.kilometrage = kilometrage;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
}
