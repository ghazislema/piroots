/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Train;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public interface ITrainService {
    
     public void addTrain(Train a);
    public ArrayList<Train> getAllTrain();
    public void deleteTrain(Train a);
    public void deleteTrainM(String matricule);
    public Train getTrain(String matricule);
    public void updateDateMaintenance(String matricule, String datemaintenance);
    
    
    public void afficherAllTrain();
    public void afficherTrain(String matricule);
    public void searchTrain(String matricule);
    
}
