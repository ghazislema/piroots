/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import connection.MYSQLConnection;
import entities.Ligne;
import entities.Station;
import interfaces.SCRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static service.ServiceLigne.ps;

/**
 *
 * @author user
 */
public class ServiceStation implements SCRUD < Station >{

   static Connection con = MYSQLConnection.conncet();
    static PreparedStatement ps;
    
    
    
     public ArrayList < Station > search(String str) {
  ArrayList < Station > lignes = new ArrayList < > ();
  try {

   ps = con.prepareStatement("select * from station where UCASE(nom) like UCASE(?) or longitude like ? or latitude like ?");
   ps.setString(1, "%"+str+"%");
   ps.setString(2, "%"+str+"%");
   ps.setString(3, "%"+str+"%");

   ResultSet res = ps.executeQuery();
   while (res.next()) {

Station sta= new Station();
sta.setId(res.getInt(1));
sta.setNom(res.getString(2));
sta.setLongitude(res.getDouble(3));
sta.setLatitude(res.getDouble(4));

    lignes.add(sta);
   }

  } catch (Exception e) {
   e.printStackTrace();
   return null;
  }
  return lignes;
 }
    @Override
    public void insert(Station a) {
        try {
   ps = con.prepareStatement("insert into Station " +
    "              (nom,longitude,latitude)" +
    "               values(?,?,?)");


   ps.setString(1, a.getNom());
   ps.setDouble(2, a.getLongitude());
   ps.setDouble(3, a.getLatitude());


   int i = ps.executeUpdate();

   if (i != 0) {
    System.out.println("station ajouté avec success");
   } else {
    System.out.println("Operation non aboutie");
   }
  } catch (Exception e) {
   e.printStackTrace();
  }
    }

     public boolean searchStation(String nom) {
  try {
   ps = con.prepareStatement("SELECT * FROM station WHERE UCASE(nom)='" + nom.toUpperCase() + "'");
   ResultSet res = ps.executeQuery();

   if (res.next()) {
    return true;
   
   }

   
  } catch (SQLException ex) {
   System.out.println(ex);
  }
    return false;

 }
    
    
    @Override
    public void delete(int id) {
     try {
        ps = con.prepareStatement("delete from station where id=?");
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
    
     public void deletet_fromtraject(int id) {
     try {
        ps = con.prepareStatement("delete from lignestations where id_station=?");
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
    public void update(Station a) {
     try {
   ps = con.prepareStatement("update station set nom=?,longitude=?,latitude=?" +
    "where id=?");
   ps.setString(1, a.getNom());
   ps.setDouble(2, a.getLongitude());
    ps.setDouble(3,a.getLatitude());
    ps.setInt(4,a.getId());



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
    public ArrayList<Station> findAll() {
        
         ArrayList < Station > stations = new ArrayList < > ();


  try {
   ps = con.prepareStatement("select * from station");
   ResultSet res = ps.executeQuery();
   while (res.next()) {
    Station s = new Station();
    s.setId(res.getInt(1));
    s.setNom(res.getString(2));
    s.setLongitude(res.getDouble(3));
    s.setLatitude(res.getDouble(4));


    stations.add(s);
   }
  } catch (SQLException ex) {
   System.out.println(ex.getMessage());
  }
  return stations;
    }
    
     public Station searchById(String nom) {
  try {
   ps = con.prepareStatement("SELECT * FROM station WHERE UCASE(nom) = UCASE('" + nom + "')");
   ResultSet res = ps.executeQuery();

   Station lig = new Station();
   if (res.next()) {
    lig.setId(res.getInt(1));
    lig.setNom(res.getString(2));
    lig.setLongitude(res.getDouble(3));
    lig.setLatitude(res.getDouble(4));
   // à finir
   }

   return lig;
  } catch (SQLException ex) {
   System.out.println(ex);
    return null;

  }


 }
     
        public Station searchByrealID(String nom) {
  try {
   ps = con.prepareStatement("SELECT * FROM station WHERE id = " + nom + "");
   ResultSet res = ps.executeQuery();

   Station lig = new Station();
   if (res.next()) {
    lig.setId(res.getInt(1));
    lig.setNom(res.getString(2));
    lig.setLongitude(res.getDouble(3));
    lig.setLatitude(res.getDouble(4));
   // à finir
   }

   return lig;
  } catch (SQLException ex) {
   System.out.println(ex);
    return null;

  }


 }
    
    
}
