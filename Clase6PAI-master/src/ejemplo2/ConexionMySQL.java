/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class ConexionMySQL {
     public static void main(String[] args)  {
     // TODO code application logic here
        Connection connection = null;
        PreparedStatement pstatement=null;
        ResultSet resultSet = null;
        
        String ip = "172.16.201.212";
        String instancia = "repositorio2";
        String usuario = "root";
        String pass = "unillanos";
        String puerto = "3306";
        String url = "jdbc:mysql://"+ip+":"+puerto+"/"+instancia;
        String sql = "";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,usuario,pass);
            connection.setAutoCommit(false);
            int res = 0;
            boolean error = false;
//            for (int i = 50; i < 60; i++) {
//                 sql = "insert into usuarios(id,usuario,clave) values(1072394"+i+",'Alberto','Forero')";
//                pstatement = connection.prepareStatement(sql);
//                res = pstatement.executeUpdate();
//                if(res !=1)
//                {
//                      System.out.println("Error al insertar en la tabla usuarios");
//                      error=true;
//                      break;
//                }
//           
//            }
//            if(error==false)
//                connection.commit();
//            else{
//                connection.rollback();
//            }
            
           
            sql ="select * from usuarios";
            pstatement = connection.prepareStatement(sql);
            resultSet = pstatement.executeQuery();
            ResultSetMetaData info = resultSet.getMetaData();
            int cantidad = info.getColumnCount();
            for (int i = 1; i <=cantidad; i++) {
                System.out.println("Nombre: "+info.getColumnName(i)+" Tipo: "+info.getColumnTypeName(i)+" Precisión: "+info.getPrecision(i)+" Nulo: "+info.isNullable(i));
            }
        }
        catch(SQLException ex){System.out.println("VERIFIQUE SUS DATOS \n ERROR: "+ex.getMessage());}
        catch(ClassNotFoundException ex){System.out.println("ERROR EN EL DRIVER \n ERROR: "+ex.getMessage());}
        catch(Exception ex){System.out.println("ERROR EN EL DRIVER \n ERROR: "+ex.getMessage());}
        finally{
            try{
                if(connection!=null) connection.close();
                if(pstatement!=null) pstatement.close();
                if(resultSet!=null) resultSet.close();
            }catch(SQLException ex){Logger.getLogger(ConexionOracle.class.getName()).log(Level.SEVERE,null,ex);}
        }
    }

}
