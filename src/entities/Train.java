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
public class Train {
    
     private int nbrWagon;

    public Train() {
        
    }

    public int getNbrWagon() {
        return nbrWagon;
    }

    public void setNbrWagon(int nbrWagon) {
        this.nbrWagon = nbrWagon;
    }
    
    public Train(String matricule, int nbrplace, int nbrWagon, String datemiseencirculation, String datemaintenance, String revi) {
        
        this.matricule = matricule;
        this.nombreplace = nbrplace;
        this.datemiseencirculation = datemiseencirculation;
        this.datemaintenance = datemaintenance;
        this.datedernierrevision =revi;
        this.nbrWagon = nbrWagon;
    }
    
    private int id ;
    private String matricule;

    @Override
    public String toString() {
        return "Train{" + "id=" + id  + "nbrWagon=" + nbrWagon +  ", matricule=" + matricule + ", nombreplace=" + nombreplace + ", datemiseencirculation=" + datemiseencirculation + ", datemaintenance=" + datemaintenance + ", datedernierrevision=" + datedernierrevision + '}';
    }
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

    
}
