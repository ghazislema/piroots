/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import properties.property;

/**
 *
 * @author ouagh
 */
public class MYSQLConnection {
    
//      private Connection cnx;
//    private static MYSQLConnection instance;
//     private MYSQLConnection() {
//        try {
//            cnx = DriverManager.getConnection(property.url
//                    , property.user, property.password);
//            System.out.println("Connexion établie");
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
//       
//        
//         public static MYSQLConnection getInstance(){
//        if(instance == null)
//            instance = new MYSQLConnection();
//        
//        return instance;
//    }
//
//    public Connection getCnx() {
//        return cnx;
//    }
    
    public static Connection conncet(){
            Connection con=null;
        try {
             
            con = DriverManager.getConnection(property.url, property.user, property.password);
            System.out.println("Connection success");                              
               
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
       
        }
        return con;
        }
    
}
