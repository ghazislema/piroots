/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entities.Ligne;
import interfaces.SCRUD;
import connection.MYSQLConnection;
import entities.Station;

/**
 *
 * @author ghazy
 */
public class ServiceLigne implements SCRUD < Ligne > {

  Connection con = MYSQLConnection.conncet();
  PreparedStatement ps;

  
  public void affectmeans(String nomligne,String matricule)
  {
        try {
   ps = con.prepareStatement("insert into vehiculeligne " +
    "              (ligne,vehicule)" +
    "               values(?,?)");


   ps.setString(1,nomligne);
   ps.setString(2, matricule);


   int i = ps.executeUpdate();

   if (i != 0) {
    System.out.println("Ligne ajouté avec success");
   } else {
    System.out.println("Operation non aboutie");
   }
  } catch (Exception e) {
   e.printStackTrace();
  }
      
  }
  
 public int lines_bybus()
 {
      int ret=0;
      try {
   ps = con.prepareStatement("SELECT count(*) FROM ligne WHERE moyenTransport like 'Bus'");
   ResultSet res = ps.executeQuery();

  
   if (res.next()) {
    ret=res.getInt(1);
    return ret;
   
   }
  } catch (SQLException ex) {
   System.out.println(ex);

  }
     return ret;
 }
  public int lines_bytrain()
 {
      int ret=0;
      try {
   ps = con.prepareStatement("SELECT count(*) FROM ligne WHERE moyenTransport like 'Train'");
   ResultSet res = ps.executeQuery();

  
   if (res.next()) {
    ret=res.getInt(1);
    return ret;
   
   }
  } catch (SQLException ex) {
   System.out.println(ex);

  }
     return ret;
 }
  
    public int lines_byMetro()
 {
      int ret=0;
      try {
   ps = con.prepareStatement("SELECT count(*) FROM ligne WHERE moyenTransport like 'Metro'");
   ResultSet res = ps.executeQuery();

  
   if (res.next()) {
    ret=res.getInt(1);
    return ret;
   
   }
  } catch (SQLException ex) {
   System.out.println(ex);

  }
     return ret;
 }
 
 
 public void MakeTraject(String nomligne,Station idstat, int order)
 {
      try {
   ps = con.prepareStatement("insert into lignestations " +
    "              (nom,id_station,order_s)" +
    "               values(?,?,?)");


   ps.setString(1, nomligne);
   ps.setInt(2, idstat.getId());
   ps.setInt(3, order);


   int i = ps.executeUpdate();

   if (i != 0) {
    System.out.println("Route ajouté avec success");
   } else {
    System.out.println("Operation non aboutie");
   }
  } catch (Exception e) {
   e.printStackTrace();
  }
     
 }
 
 public String id_station_depart(String nom)
 {
      String ret=null;
      try {
   ps = con.prepareStatement("SELECT * FROM lignestations WHERE nom='" + nom + "' order by order_s asc");
   ResultSet res = ps.executeQuery();

  
   if (res.next()) {
    ret=res.getString(2);
    return ret;
   
   }
  } catch (SQLException ex) {
   System.out.println(ex);
   

  }
     return ret;
 }
 
  public String id_station_arrive(String nom)
 {
      String ret=null;
      try {
   ps = con.prepareStatement("SELECT * FROM lignestations WHERE nom='" + nom + "' order by order_s desc");
   ResultSet res = ps.executeQuery();

  
   if (res.next()) {
    ret=res.getString(2);
    return ret;
   
   }
  } catch (SQLException ex) {
   System.out.println(ex);
   

  }
     return ret;
 }
    public List<Station> retrieve_stations_ofline(String nom) {

      List<Station> mylist=new ArrayList<>();
ServiceStation service_station=new ServiceStation();
  try {
     ps = con.prepareStatement("SELECT id_station FROM lignestations WHERE nom='" + nom + "' order by order_s asc");

     ResultSet res = ps.executeQuery();
     while (res.next()) {
         
     int id= res.getInt(1);
     Station station= service_station.searchByrealID(id+"");
        mylist.add(station);
   }
   return mylist;
 
  } catch (Exception e) {
      
   e.printStackTrace();
  }
return mylist;


 }
 
  public boolean checktraject(String nom) {


  try {
     ps = con.prepareStatement("SELECT * FROM lignestations WHERE nom='" + nom + "'");

     ResultSet res = ps.executeQuery();

   if (res.next()) {
    return true;
   }
 
  } catch (Exception e) {
   e.printStackTrace();
  }

return false;

 }
 
 @Override
 public void insert(Ligne a) {


  try {
   ps = con.prepareStatement("insert into ligne " +
    "              (nom,moyentransport)" +
    "               values(?,?)");


   ps.setString(1, a.getNom());
   ps.setString(2, a.getMoyentransport());


   int i = ps.executeUpdate();

   if (i != 0) {
    System.out.println("Ligne ajouté avec success");
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
   ps = con.prepareStatement("delete from ligne where id=?");
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
 
 public void delete_trajectline(String nom) {
  try {
   ps = con.prepareStatement("delete from lignestations where nom=?");
   ps.setString(1, nom);
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

 

 public void update(Ligne a) {
  try {
   ps = con.prepareStatement("update ligne set nom=?,moyentransport=?" +
    "where id=?");
   ps.setString(1, a.getNom());
   ps.setString(2, a.getMoyentransport());
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






 public Ligne searchLigneById(int id) {
  try {
   ps = con.prepareStatement("SELECT * FROM ligne WHERE id='" + id + "'");
   ResultSet res = ps.executeQuery();

   Ligne lig = new Ligne();
   if (res.next()) {
    lig.setId(res.getInt(1));
    lig.setNom(res.getString(2));
    lig.setMoyentransport(res.getString(3));
   
   }

   return lig;
  } catch (SQLException ex) {
   System.out.println(ex);
    return null;

  }


 }
 
 public boolean searchLigne(String nom) {
  try {
   ps = con.prepareStatement("SELECT * FROM ligne WHERE UCASE(nom)='" + nom.toUpperCase() + "'");
   ResultSet res = ps.executeQuery();

   if (res.next()) {
    return true;
   
   }

   
  } catch (SQLException ex) {
   System.out.println(ex);
  }
    return false;

 }



 public ArrayList < Ligne > searchLineByNameTransport(String str) {
  ArrayList < Ligne > lignes = new ArrayList < > ();
  
  String str2=new String();
  if (str.equals("Tramway"))
      str2="Metro";
  else
      str2=str;
  try {

   ps = con.prepareStatement("select * from ligne where UCASE(nom) like UCASE(?) or UCASE(moyenTransport) like UCASE(?)");
   ps.setString(1, "%"+str2+"%");
   ps.setString(2, "%"+str2+"%");

   ResultSet res = ps.executeQuery();
   while (res.next()) {


    Ligne lig = new Ligne();
    lig.setId(res.getInt(1));
    lig.setNom(res.getString(2));
    lig.setMoyentransport(res.getString(3));
  
    lignes.add(lig);
   }

  } catch (Exception e) {
   e.printStackTrace();
   return null;
  }
  return lignes;
 }
  public Ligne searchLineByName(String str) {
  Ligne lig = new Ligne();
  try {

   ps = con.prepareStatement("select * from ligne where nom = '"+str+"'");


   ResultSet res = ps.executeQuery();
   if (res.next()) {


   
    lig.setId(res.getInt(1));
    lig.setNom(res.getString(2));
    lig.setMoyentransport(res.getString(3));
 
   }
   return lig;

  } catch (Exception e) {
   e.printStackTrace();
   return lig;
  }

 }

 
 
 @Override
 public ArrayList < Ligne > findAll() {
  ArrayList < Ligne > lignes = new ArrayList < > ();


  try {
   ps = con.prepareStatement("select * from ligne");
   ResultSet res = ps.executeQuery();
   while (res.next()) {
    Ligne lig = new Ligne();
    lig.setId(res.getInt(1));
    lig.setNom(res.getString(2));
    lig.setMoyentransport(res.getString(3));


    lignes.add(lig);
   }
  } catch (SQLException ex) {
   System.out.println(ex.getMessage());
  }
  return lignes;
 }
 
  public ArrayList < Ligne > findAll_linestrajects() {
  ArrayList < Ligne > lignes = new ArrayList < > ();


  try {
   ps = con.prepareStatement("select * from ligne l where l.nom in (select nom from lignestations) ");
   ResultSet res = ps.executeQuery();
   while (res.next()) {
    Ligne lig = new Ligne();
    lig.setId(res.getInt(1));
    lig.setNom(res.getString(2));
    lig.setMoyentransport(res.getString(3));


    lignes.add(lig);
   }
  } catch (SQLException ex) {
   System.out.println(ex.getMessage());
  }
  return lignes;
 }





}