/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import connection.MYSQLConnection;
import entities.Train;
import interfaces.ITrainService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class TrainService implements ITrainService{
    
    static Connection con = MYSQLConnection.conncet();
	static PreparedStatement ps ;

    @Override
    public void addTrain(Train a) {
try {
	    	ps = con.prepareStatement("insert into train "
                        + "              (matricule,nbr_places,nb_wagon,date_mise_circulation,date_maintenance,date_derniere_revision)"
                        + "               values(?,?,?,?,?,?,?)");
              
	    	
	    	ps.setString(1, a.getMatricule());	   	
	    	ps.setInt   (2, a.getNombreplace());
                ps.setInt(3, a.getNbrWagon());	    	
		ps.setString(4, a.getDatemiseencirculation());
		ps.setString(5, a.getDatemaintenance());
		ps.setString(6, a.getDatedernierrevision());
			
		    int i = ps.executeUpdate();
                    
		    if (i != 0) {
		        System.out.println("Train ajouté avec success");
		    } else {
		        System.out.println("Operation non aboutie");
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}
    }

    @Override
    public ArrayList<Train> getAllTrain() {
 ArrayList<Train> train= new ArrayList<>();
        
        String req="SELECT * FROM `train` ";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rst = st.executeQuery(req);
            while(rst.next()){
                Train a = new Train();
                
                a.setId(rst.getInt("id"));
                a.setMatricule(rst.getString("matricule"));
                a.setNbrWagon(rst.getInt("nb_wagon"));
                a.setNombreplace(rst.getInt("nbr_places"));
                a.setDatemiseencirculation(rst.getString("date_mise_circulation"));
                a.setDatemaintenance(rst.getString("date_maintenance"));
       //         a.setDatedernierrevision(rst.getString("date_derniere_revision"));
               
                
                train.add(a);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return train;
        
    }

    @Override
    public void deleteTrain(Train a) {
         try {
    ps = con.prepareStatement("delete from train where matricule=?");
    ps.setString(1, a.getMatricule());
    int i = ps.executeUpdate();
    if (i != 0) {
        System.out.println("deleted");
    } else {
        System.out.println("not deleted");
    }
} catch (Exception e) {
    e.printStackTrace();
}
    }

    @Override
    public void deleteTrainM(String matricule) {
         try {
    ps = con.prepareStatement("delete from train where matricule=?");
    ps.setString(1, matricule);
    int i = ps.executeUpdate();
    if (i != 0) {
        System.out.println("deleted");
    } else {
        System.out.println("not deleted");
    }
} catch (Exception e) {
    e.printStackTrace();
}
    }

    @Override
    public Train getTrain(String matricule) {
        Train train = new Train();
try {
    
    ps = con.prepareStatement("select * from train where matricule=?");
    ps.setString(1, matricule);
    
    ResultSet res = ps.executeQuery();
    if (res.next()) {
        train.setId(res.getInt("id"));
        train.setMatricule(res.getString(2));
        train.setNbrWagon(res.getInt(3));
        train.setNombreplace(res.getInt(4));
        train.setDatemiseencirculation(res.getString(5));
        train.setDatemaintenance(res.getString(6));
        train.setDatedernierrevision(res.getString(7));
     
        
        /* System.out.print(" Matricule: "+res.getString(2));
        System.out.print(" Model: "+res.getString(3));
        System.out.print(" Nbre place: "+res.getInt(4));
        System.out.print(" Kilometrage: "+res.getDouble(5));    
        System.out.print(" Date mise en circulation: "+res.getString(6));
        System.out.print(" Date maintenance: "+res.getString(7));
        System.out.println(" Date dernier revision: "+res.getString(8));*/
        
        
    }
} catch (Exception e) {
    e.printStackTrace();
}

return train;
    }
    
     public String getData(String matricule) {
            String Lastdate = null;
                try {
                    ps = con.prepareStatement("select * from train where matricule=?");
                    ps.setString(1, matricule);
                    ResultSet res = ps.executeQuery();
                    if (res.next()){
                    Lastdate=res.getString(7);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
    
                return Lastdate;
        }

    @Override
    public void updateDateMaintenance(String matricule, String datemaintenance) {
         String na = null;
        na=getData(matricule);
        try {
    ps = con.prepareStatement("update train set date_maintenance=? where matricule=?");
    ps.setString(1, datemaintenance);
    ps.setString(2, matricule);

    int i = ps.executeUpdate();
   
    if (i != 0) {
        System.out.println("updated");
    } else {
        System.out.println("not updated");
    }
} catch (Exception e) {
    e.printStackTrace();
}
        try {
    
   ps = con.prepareStatement("update train "
                        + "              set date_derniere_revision=?  "
                        + "              where matricule=?"); 
                        
                  ps.setString(1, na); 
                  ps.setString(2, matricule);

    int i = ps.executeUpdate();
    if (i != 0) {
        System.out.println("updated");
    } else {
        System.out.println("not updated");
    }
} catch (Exception e) {
    e.printStackTrace();
}
}
    

    @Override
    public void afficherAllTrain() {
         getAllTrain().forEach(System.out::println);
    }

    @Override
    public void afficherTrain(String matricule) {
        System.out.println(getTrain(matricule).toString());
    }

    @Override
    public void searchTrain(String matricule) {
        try{
    ps = con.prepareStatement("SELECT * FROM train WHERE matricule='"+matricule+"'");
    ResultSet res = ps.executeQuery();
    res.last();
    int nbre = res.getRow();
    if(nbre != 0)
    {
        System.out.println("TRAIN trouvé");
        afficherTrain(matricule);
    }else{
        System.out.println("TRAIN non trouvé");}
    }           catch (SQLException ex) {
                    System.out.println(ex);;
                }
    }
    
}