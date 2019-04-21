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
    
    
    @Override
    public void insert(Station a) {
        try {
   ps = con.prepareStatement("insert into Station " +
    "              (nom,longitude,latitude)" +
    "               values(?,?,?)");


   ps.setString(1, a.getNom());
   ps.setDouble(2, a.getLongitude());
   ps.setDouble(2, a.getLatitude());


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

    @Override
    public void update(Station a) {
     try {
   ps = con.prepareStatement("update station set nom=?,longitude=?,latitude=?" +
    "where id=?");
   ps.setString(1, a.getNom());
   ps.setDouble(2, a.getLongitude());
    ps.setDouble(3,a.getLatitude());
    ps.setInt(3,a.getId());



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
    
    
}
