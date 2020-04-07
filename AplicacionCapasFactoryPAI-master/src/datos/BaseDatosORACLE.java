/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class BaseDatosORACLE extends BaseDatos{
    
    @Override
    public Connection getConection() {
         String ip = "172.16.201.212";
        String instancia = "XE";
        String usuario = "repositorio1";
        String pass = "unillanos";
        String puerto = "1521";
        String url = "jdbc:oracle:thin:@"+ip+":"+puerto+":"+instancia;
        String sql = "";
        
        try{
            if (BaseDatosORACLE.connection==null) {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                BaseDatosORACLE.connection = DriverManager.getConnection(url,usuario,pass); 
                BaseDatosORACLE.connection.setAutoCommit(false);
                return BaseDatosORACLE.connection;
                
            }
        }
        catch(Exception ex){
            System.out.println("ERROR EN EL DRIVER \n ERROR: "+ex.getMessage());
             try {
                 // Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE,null,ex);
                 BaseDatosORACLE.connection.close();
             } catch (SQLException ex1) {
                 java.util.logging.Logger.getLogger(BaseDatosORACLE.class.getName()).log(Level.SEVERE, null, ex1);
             }
        }
        return BaseDatosORACLE.connection;
    }
    private static Connection connection=null;
    /*public static Connection getConection()throws SQLException{
          
        String ip = "172.16.201.212";
        String instancia = "XE";
        String usuario = "repositorio1";
        String pass = "unillanos";
        String puerto = "1521";
        String url = "jdbc:oracle:thin:@"+ip+":"+puerto+":"+instancia;
        String sql = "";
        
        try{
            if (BaseDatosORACLE.connection==null) {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                BaseDatosORACLE.connection = DriverManager.getConnection(url,usuario,pass); 
                BaseDatosORACLE.connection.setAutoCommit(false);
                return BaseDatosORACLE.connection;
                
            }
        }
        catch(Exception ex){
            System.out.println("ERROR EN EL DRIVER \n ERROR: "+ex.getMessage());
           // Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE,null,ex);
           BaseDatosORACLE.connection.close();
        }
        return BaseDatosORACLE.connection;
    }*/

    
}
