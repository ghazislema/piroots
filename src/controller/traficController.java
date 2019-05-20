/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Ligne;
import entities.Trafic;
import java.util.ArrayList;
import service.ServiceLigne;
import service.ServiceTrafic;

/**
 *
 * @author anefzaoui
 */
public class traficController {
    
    ServiceTrafic str = new ServiceTrafic();
    ServiceLigne ls = new ServiceLigne();
    
    public void ajouterTrafic(Trafic t){
        str.add(t);
    }
    public void supprimerTrafic(Trafic t)
    {
        str.delete(t);
    }
    public void modifierTrafic(Trafic t,String s, String b, int y)
    {
        str.update(t,s,b,y);
    }
     public ArrayList<Trafic> getAllTrafic(){
        ArrayList<Trafic> allTrafic = new ArrayList<>();
        str.display(allTrafic);
        return allTrafic;
    }
      public void chercherTraficparStatue(String s){
        str.findTraficByTraficStatue(s);
    }
       public Trafic getTraficbyid(int id){
        Trafic t = null;
        return str.getTrafic(t,id);
    }
       
      public ArrayList < Ligne > findAll()
    {
    
        ArrayList<Ligne> lignes = new ArrayList<>();
        lignes = ls.findAll();
        return lignes;
        
    }
}
