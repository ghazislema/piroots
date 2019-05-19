/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import connection.MYSQLConnection;
import entities.Metro;
import interfaces.IMetroService;
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
public class MetroService implements IMetroService{
    
    	static Connection con = MYSQLConnection.conncet();
	static PreparedStatement ps ;

    @Override
    public void addMetro(Metro a) {
          try {
	    	ps = con.prepareStatement("insert into metro "
                        + "              (matricule,nbr_places,status,date_mise_circulation,date_maintenance,date_derniere_revision)"
                        + "               values(?,?,?,?,?,?)");
	    	
	    	ps.setString(1, a.getMatricule());
	    	ps.setInt(   2, a.getNombreplace());
                ps.setString(3, a.getStatus());
	    	ps.setString(4, a.getDatemiseencirculation());
		ps.setString(5, a.getDatemaintenance());
		ps.setString(6, a.getDatedernierrevision());
		
		
		    
		    int i = ps.executeUpdate();
		    if (i != 0) {
		        System.out.println("metro ajouté avec success");
		    } else {
		        System.out.println("Operation non aboutie");
		    }
		} catch (Exception e) {
		  e.printStackTrace();
                 
		}
    
    }

    @Override
    public ArrayList<Metro> getAllMetro() {
        ArrayList<Metro> metro= new ArrayList<>();
        
        String req="SELECT * FROM `metro` ";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rst = st.executeQuery(req);
            while(rst.next()){
                Metro a = new Metro();
                
                a.setId(rst.getInt("id"));
                a.setMatricule(rst.getString("matricule"));               
                a.setNombreplace(rst.getInt("nbr_places"));
                a.setDatemiseencirculation(rst.getString("date_mise_circulation"));
                a.setDatemaintenance(rst.getString("date_maintenance"));
        //        a.setDatedernierrevision(rst.getString("date_derniere_revision"));
                a.setStatus(rst.getString("status"));
               
                
                metro.add(a);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return metro;
        
    }

    @Override
    public void deleteMetro(Metro a) {
          try {
    ps = con.prepareStatement("delete from metro where matricule=?");
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
    public void deleteMetroM(String matricule) {
          try {
    ps = con.prepareStatement("delete from metro where matricule=?");
    ps.setString(1, matricule);
    int i = ps.executeUpdate();
    if (i != 0) {
        System.out.println("deleted");
    } else {
        System.out.println("not deleted");
    }
} catch (SQLException e) {
}
    }

    @Override
    public Metro getMetro(String matricule) {
        Metro metro = new Metro();
try {
    
    ps = con.prepareStatement("select * from metro where matricule=?");
    ps.setString(1, matricule);
    
    ResultSet res = ps.executeQuery();
    if (res.next()) {
        metro.setId(res.getInt("id"));
        metro.setMatricule(res.getString(2));
        metro.setNombreplace(res.getInt(3));
        metro.setDatemiseencirculation(res.getString(4));
        metro.setDatemaintenance(res.getString(5));
        metro.setDatedernierrevision(res.getString(6));
        metro.setStatus(res.getString(7));
     
        
        /* System.out.print(" Matricule: "+res.getString(2));
        System.out.print(" Model: "+res.getString(3));
        System.out.print(" Nbre place: "+res.getInt(4));
        System.out.print(" Kilometrage: "+res.getDouble(5));    
        System.out.print(" Date mise en circulation: "+res.getString(6));
        System.out.print(" Date maintenance: "+res.getString(7));
        System.out.println(" Date dernier revision: "+res.getString(8));*/
        
        
    }
} catch (SQLException e) {
}

return metro;
    }
    
    public String getData(String matricule){
            String Lastdate = null;
                try {
                    ps = con.prepareStatement("select * from metro where matricule=?");
                    ps.setString(1, matricule);
                    ResultSet res = ps.executeQuery();
                    if (res.next()){
                    Lastdate=res.getString(6);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
                return Lastdate;
        }

    @Override
    public void updateDateMaintenance(String matricule, String datemaintenance) {
       String na = "null";
        na=getData(matricule);
        try {
    ps = con.prepareStatement("update metro set date_maintenance=? where matricule=?");
    ps.setString(1, datemaintenance);
    ps.setString(2, matricule);
    int i = ps.executeUpdate();
    if (i != 0) {
        System.out.println("updated");
    } else {
        System.out.println("not updated");
    }
} catch (SQLException e) {
}
        
        try {
    
   ps = con.prepareStatement("update metro set date_derniere_revision=? where matricule=?"); 
                        
                  ps.setString(1, na); 
                  ps.setString(2, matricule);

    int i = ps.executeUpdate();
    if (i != 0) {
        System.out.println("updated");
    } else {
        System.out.println("not updated");
    }
} catch (SQLException e) {
}
    }
    
    @Override
    public void updateStatut(String matricule, String statut) {
        try {
    ps = con.prepareStatement("update train set statut=? where matricule=?");
    ps.setString(1, statut);
    ps.setString(2, matricule);
   
    
    int i = ps.executeUpdate();
    if (i != 0) {
        System.out.println("updated");
    } else {
        System.out.println("not updated");
    }
} catch (SQLException e) {
}
    }
  
    @Override
    public void afficherAllMetro() {
      getAllMetro().forEach(System.out::println);
    }

    @Override
    public void afficherMetro(String matricule) {
      System.out.println(getMetro(matricule).toString());
    }

    @Override
    public void searchMetro(String matricule) {
           try{
    ps = con.prepareStatement("SELECT * FROM metro WHERE matricule='"+matricule+"'");
    ResultSet res = ps.executeQuery();
    res.last();
    int nbre = res.getRow();
    if(nbre != 0)
    {
        System.out.println("METRO trouvé");
        afficherMetro(matricule);
    }else{
        System.out.println("METRO non trouvé");}
    }           catch (SQLException ex) {
                    System.out.println(ex);;
                }
    }

   
    
}