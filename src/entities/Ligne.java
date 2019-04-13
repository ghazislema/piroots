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
public class Ligne {
    
    private int id;
    private String nom;
    private String moyentransport;
    

   

    
    public Ligne()
    {
        
    }

    public void setMoyentransport(String moyentransport) {
        this.moyentransport = moyentransport;
    }

    public String getMoyentransport() {
        return moyentransport;
    }



    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public Ligne(int id, String nom, String moyentransport) {
        this.id = id;
        this.nom = nom;
        this.moyentransport = moyentransport;
    }

  

    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    
    
    
}
