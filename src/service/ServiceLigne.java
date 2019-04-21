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

/**
 *
 * @author ghazy
 */
public class ServiceLigne implements SCRUD < Ligne > {

 static Connection con = MYSQLConnection.conncet();
 static PreparedStatement ps;

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



 public ArrayList < Ligne > searchLineByNameTransport(String str) {
  ArrayList < Ligne > lignes = new ArrayList < > ();
  try {

   ps = con.prepareStatement("select * from ligne where UCASE(nom) like UCASE(?) or UCASE(moyenTransport) like UCASE(?)");
   ps.setString(1, "%"+str+"%");
   ps.setString(2, "%"+str+"%");

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





}