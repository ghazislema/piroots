/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Autobus;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public interface IAutobusService {
    
       public void addBus(Autobus a);
    public ArrayList<Autobus> getAllBus();
    public void deleteBus(Autobus a);
    public Autobus getBus(String matricule);
    public void updateDateMaintenance(String matricule, String datemaintenance);
    public void updateKilometrage(String matricule, double distance);
    
    public void afficherAllBus();
    public void afficherBus(String matricule);
    public void searchBus(String matricule);
    
}
