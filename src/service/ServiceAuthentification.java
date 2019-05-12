/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import connection.MYSQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static service.ServiceLigne.ps;

/**
 *
 * @author user
 */
public class ServiceAuthentification {
    static Connection con = MYSQLConnection.conncet();
 static PreparedStatement ps;
 
 public String retrieve_userpw(String username)
 {
      String ret=null;
      try {
   ps = con.prepareStatement("SELECT password FROM user WHERE username='" + username + "'");
   ResultSet res = ps.executeQuery();

  
   if (res.next()) {
    ret=res.getString(1);
    return ret;
   
   }
  } catch (SQLException ex) {
   System.out.println(ex);
   

  }
     return ret;
 }
 
 
  public String retrieve_usernum(String username)
 {
      String ret=null;
      try {
   ps = con.prepareStatement("SELECT num FROM user WHERE username='" + username + "'");
   ResultSet res = ps.executeQuery();

  
   if (res.next()) {
    ret=res.getString(1);
    return ret;
   
   }
  } catch (SQLException ex) {
   System.out.println(ex);
   

  }
     return ret;
 }
}

