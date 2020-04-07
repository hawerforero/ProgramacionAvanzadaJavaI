/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class BaseDatosMySQL extends BaseDatos{
    private static Connection connection=null;
    
     @Override
    public Connection getConection() {
        String ip = "172.16.201.212";
        String instancia = "repositorio3";
        String usuario = "root";
        String pass = "unillanos";
        String puerto = "3306";
        String url = "jdbc:mysql://"+ip+":"+puerto+"/"+instancia;
        String sql = "";
        
         
       try{
            if (BaseDatosMySQL.connection==null) {
                Class.forName("com.mysql.jdbc.Driver");
                BaseDatosMySQL.connection = DriverManager.getConnection(url,usuario,pass); 
                BaseDatosMySQL.connection.setAutoCommit(false);
                return BaseDatosMySQL.connection;
                
            }
        }
        catch(Exception ex){
            System.out.println("ERROR EN EL DRIVER \n ERROR: "+ex.getMessage());
            try {
                // Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE,null,ex);
                BaseDatosMySQL.connection.close();
            } catch (SQLException ex1) {
                Logger.getLogger(BaseDatosMySQL.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return BaseDatosMySQL.connection;
    }
    }
    
    /*public static Connection getConection()throws SQLException{
          
          
        String ip = "172.16.201.212";
        String instancia = "repositorio3";
        String usuario = "root";
        String pass = "unillanos";
        String puerto = "3306";
        String url = "jdbc:mysql://"+ip+":"+puerto+"/"+instancia;
        String sql = "";
        
         
       try{
            if (BaseDatosMySQL.connection==null) {
                Class.forName("com.mysql.jdbc.Driver");
                BaseDatosMySQL.connection = DriverManager.getConnection(url,usuario,pass); 
                BaseDatosMySQL.connection.setAutoCommit(false);
                return BaseDatosMySQL.connection;
                
            }
        }
        catch(Exception ex){
            System.out.println("ERROR EN EL DRIVER \n ERROR: "+ex.getMessage());
           // Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE,null,ex);
           BaseDatosMySQL.connection.close();
        }
        return BaseDatosMySQL.connection;
    }*/

   
