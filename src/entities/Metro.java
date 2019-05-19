package entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Metro {
    
    public Metro(String matricule, int nbrplace, String datemiseencirculation, String datemaintenance, String revi, String statut) {
        
        this.matricule = matricule;
        this.nombreplace = nbrplace;
        this.datemiseencirculation = datemiseencirculation;
        this.datemaintenance = datemaintenance;
        this.datedernierrevision =revi;
        this.statut = statut;
        
    }
    
    private String statut ;

    public Metro() {
       
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
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
    
    private int id ; 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String matricule;
    private int nombreplace;
    private String datemiseencirculation;
    private String datemaintenance;
    private String datedernierrevision;
    
    public String getStatus() {
        return statut;
    }

    public void setStatus(String statut) {
        this.statut = statut;
    }
}
