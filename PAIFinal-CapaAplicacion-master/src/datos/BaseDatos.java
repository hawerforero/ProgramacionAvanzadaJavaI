/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dto.EmpleadoDTO;
import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Level;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public abstract class BaseDatos {
    private static Connection connection=null;
    
    public abstract Connection getConection();
    
    /*public static Connection getConection2()throws SQLException{
          
          
        String ip = "172.16.201.212";
        String instancia = "repositorio3";
        String usuario = "root";
        String pass = "unillanos";
        String puerto = "3306";
        String url = "jdbc:mysql://"+ip+":"+puerto+"/"+instancia;
        String sql = "";
        
         
       try{
            if (BaseDatos.connection==null) {
                Class.forName("com.mysql.jdbc.Driver");
                BaseDatos.connection = DriverManager.getConnection(url,usuario,pass); 
                BaseDatos.connection.setAutoCommit(false);
                return BaseDatos.connection;
                
            }
        }
        catch(Exception ex){
            System.out.println("ERROR EN EL DRIVER \n ERROR: "+ex.getMessage());
           // Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE,null,ex);
           BaseDatos.connection.close();
        }
        return BaseDatos.connection;
    }*/
}
