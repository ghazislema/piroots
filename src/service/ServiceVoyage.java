/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import connection.MYSQLConnection;
import entities.Ligne;
import entities.Voyage;
import interfaces.SCRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static service.ServiceLigne.ps;

/**
 *
 * @author gslema
 */
public class ServiceVoyage implements SCRUD < Voyage >{
    
    static Connection con = MYSQLConnection.conncet();
 static PreparedStatement ps;

    @Override
    public void insert(Voyage a) {
        
        try {
   ps = con.prepareStatement("insert into voyage " +
    "              (type,heure_depart,heure_arrive,destination_depart,destination_arrive,id_chauffeur,id_ligne)" +
    "               values(?,?,?,?,?,?,?)");


   ps.setString(1, a.getType());
   ps.setString(2, a.getHeure_depart());
   ps.setString(2, a.getHeure_arrive());
   ps.setString(2, a.getDestination_depart());
   ps.setString(2, a.getDestination_arrive());
   ps.setInt(2, a.getId_chauffeur());
   ps.setInt(2, a.getId_ligne());


   int i = ps.executeUpdate();

   if (i != 0) {
    System.out.println("Voyage ajouté avec success");
   } else {
    System.out.println("Operation non aboutie");
   }
  } catch (Exception e) {
   e.printStackTrace();
  }
        
    }

    @Override
    public void delete(int id) {
          try {
   ps = con.prepareStatement("delete from voyage where id=?");
   ps.setInt(1, id);
   int i = ps.executeUpdate();
   if (i != 0) {
    System.out.println("row deleted");
   } else {
    System.out.println("not deleted");
   }
  } catch (SQLException e) {
      System.out.println(e);
  }
        
    }

    @Override
    public void update(Voyage a) {
        
          try {
   ps = con.prepareStatement("update voyage set type=?,heure_depart=?,heure_arrive=?,destination_depart=?,destination_arrive=?,"
           + "id_chauffeur=?,id_ligne=?" +
            "where id=?");
   ps.setString(1, a.getType());
   ps.setString(2, a.getHeure_arrive());
   ps.setString(2, a.getHeure_arrive());
   ps.setString(2, a.getDestination_depart());
   ps.setString(2, a.getDestination_arrive());
   ps.setInt(2, a.getId_chauffeur());
   ps.setInt(2, a.getId_ligne());



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

//    public int getNbrVoyage()
//    {
//        
//         try {
//             int n=0;
//   ps = con.prepareStatement("select count(*) from voyage");
//   ResultSet res = ps.executeQuery();
//   while (res.next()) {
//    Voyage voy = new Voyage();
//    voy.setId(res.getInt(1));
//    voy.setType(res.getString(2));
//    voy.setHeure_depart(res.getString(3));
//    voy.setHeure_arrive(res.getString(4));
//    voy.setDestination_depart(res.getString(5));
//    voy.setDestination_arrive(res.getString(6));
//    voy.setId_chauffeur(res.getInt(7));
//    voy.setId_ligne(res.getInt(8));
//
//
//    voyages.add(voy);
//   }
//  } catch (SQLException ex) {
//   System.out.println(ex.getMessage());
//  }
//    }
    @Override
    public ArrayList<Voyage> findAll() {
        
         ArrayList < Voyage > voyages = new ArrayList < > ();


  try {
   ps = con.prepareStatement("select * from voyage");
   ResultSet res = ps.executeQuery();
   while (res.next()) {
    Voyage voy = new Voyage();
    voy.setId(res.getInt(1));
    voy.setType(res.getString(2));
    voy.setHeure_depart(res.getString(3));
    voy.setHeure_arrive(res.getString(4));
    voy.setDestination_depart(res.getString(5));
    voy.setDestination_arrive(res.getString(6));
    voy.setId_chauffeur(res.getInt(7));
    voy.setId_ligne(res.getInt(8));


    voyages.add(voy);
   }
  } catch (SQLException ex) {
   System.out.println(ex.getMessage());
  }
  return voyages;
    }
    
}
