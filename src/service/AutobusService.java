/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import connection.MYSQLConnection;
import entities.Autobus;
import interfaces.IAutobusService;
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
public class AutobusService implements IAutobusService{
    static Connection con = MYSQLConnection.conncet();
    static PreparedStatement ps ;   
        
    @Override
    public void addBus(Autobus a) {
        try {
	    	ps = con.prepareStatement("insert into bus "
                        + "              (matricule,model,nbr_places,kilometrage,"
                        + "               date_mise_circulation,date_maintenance,date_derniere_revision)"
                        + "               values(?,?,?,?,?,?,?)");
    	
	    	ps.setString(1, a.getMatricule());
	    	ps.setString(2, a.getModel());   	
	    	ps.setInt   (3, a.getNombreplace());
                ps.setDouble(4, a.getKilometrage());	    	
		ps.setString(5, a.getDatemiseencirculation());
		ps.setString(6, a.getDatemaintenance());
		ps.setString(7, a.getDatedernierrevision());
              //  ps.setInt(8,a.getLigne().getId());
			
		    int i = ps.executeUpdate();
                    
		    if (i != 0) {
		        System.out.println("Autobus ajouté avec success");
		    } else {
		        System.out.println("Operation non aboutie");
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}
    }
    
    @Override
    public ArrayList<Autobus> getAllBus() {
        ArrayList<Autobus> bus= new ArrayList<>();
        
        String req="SELECT * FROM `bus` ";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rst = st.executeQuery(req);
            while(rst.next()){
                Autobus a = new Autobus();
                
                a.setId(rst.getInt("id"));
                a.setMatricule(rst.getString("matricule"));
                a.setModel(rst.getString("model"));
                a.setNombreplace(rst.getInt("nbr_places"));
                a.setKilometrage(rst.getDouble("kilometrage"));
                a.setDatemiseencirculation(rst.getString("date_mise_circulation"));
                a.setDatemaintenance(rst.getString("date_maintenance"));
         //       a.setDatedernierrevision(rst.getString("date_derniere_revision"));
               
                
                bus.add(a);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return bus;
        
    }

    @Override
    public void deleteBus(Autobus a) {
        try {
    ps = con.prepareStatement("delete from bus where matricule=?");
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
    public Autobus getBus(String matricule) {
        Autobus bus = new Autobus();
try {
    
    ps = con.prepareStatement("select * from bus where matricule=?");
    ps.setString(1, matricule);
    
    ResultSet res = ps.executeQuery();
    if (res.next()) {
        bus.setId(res.getInt("id"));
        bus.setMatricule(res.getString(2));
        bus.setModel(res.getString(3));
        bus.setNombreplace(res.getInt(4));
        bus.setKilometrage(res.getDouble(5));
        bus.setDatemiseencirculation(res.getString(6));
        bus.setDatemaintenance(res.getString(7));
        bus.setDatedernierrevision(res.getString(8));
     
        
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

return bus;
    }
    
    public String getData(String matricule) {
            String Lastdate = null;
                try {
                    ps = con.prepareStatement("select * from bus where matricule=?");
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
    ps = con.prepareStatement("update bus set date_maintenance=? where matricule=?");
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
    
   ps = con.prepareStatement("update bus "
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
    public void updateKilometrage(String matricule, double distance) {
         try {
    ps = con.prepareStatement("update bus set kilometrage=? where matricule=?");
    ps.setDouble(1, distance);
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
    public void afficherAllBus() {
       getAllBus().forEach(System.out::println);
    }

    @Override
    public void afficherBus(String matricule) {
        
        System.out.println(getBus(matricule).toString());
    }

    @Override
    public void searchBus(String matricule) {
          try{
    ps = con.prepareStatement("SELECT * FROM bus WHERE matricule='"+matricule+"'");
    ResultSet res = ps.executeQuery();
    res.last();
    int nbre = res.getRow();
    if(nbre != 0)
    {
        System.out.println("BUS trouvé");
        afficherBus(matricule);
    }else{
        System.out.println("BUS non trouvé");}
    }           catch (SQLException ex) {
                    System.out.println(ex);
                }
    }
    
}
