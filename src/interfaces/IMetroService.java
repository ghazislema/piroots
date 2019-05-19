/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Metro;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public interface IMetroService {
    
       public void addMetro(Metro a);
    public ArrayList<Metro> getAllMetro();
    public void deleteMetro(Metro a);
    public void deleteMetroM(String matricule);
    public Metro getMetro(String matricule);
    public void updateDateMaintenance(String matricule, String datemaintenance);
    
    public void updateStatut(String matricule, String statut);
    public void afficherAllMetro();
    public void afficherMetro(String matricule);
    public void searchMetro(String matricule);
    
}
