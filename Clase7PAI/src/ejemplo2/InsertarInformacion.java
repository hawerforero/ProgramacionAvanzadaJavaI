/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class InsertarInformacion {
    public void insertar() throws SQLException{
       int res = 0;
       boolean error = false;
       PreparedStatement pstatement = null;
       ResultSet resultSet = null;
       String sql;
       Connection conne = BaseDatos.getConection();
       try{
          for (int i = 50; i < 60; i++) {
            sql = "insert into usuarios(id,usuario,clave) values(10723"+i+",'Hawer','Alberto')";
            pstatement = conne.prepareStatement(sql);
            res = pstatement.executeUpdate();
       } 
       conne.commit();
       }
       catch(Exception ex){
           conne.rollback();
           System.out.println("Error: "+ex);
       }
       
    }
    
}
