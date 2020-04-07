/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            
             /*sql = "insert into usuarios(id,usuario,clave) values(1072394576,'Hawer','Forero')";
             pstatement = connection.prepareStatement(sql);
             int res = pstatement.executeUpdate();
             if(res == 1)
                System.out.println("Fila insertada");
             else
               System.out.println("Error :Fila insertada");*/
             
             /*sql = "insert into usuarios(id,usuario,clave) values(?,?,?)";
             pstatement = connection.prepareStatement(sql);
             pstatement.setInt(1, 1072394575);
             pstatement.setString(2, "Hawer");
             pstatement.setString(3, "Forero");
             int res = pstatement.executeUpdate();
             if(res == 1)
                System.out.println("Fila insertada");
             else
               System.out.println("Error :Fila insertada");*/
             
            /* sql = "delete from usuarios where id=1072394576";
             pstatement = connection.prepareStatement(sql);
             int res = pstatement.executeUpdate();*/
            
            /* sql = "delete from usuarios where id=?";
             pstatement = connection.prepareStatement(sql);
             pstatement.setInt(1, 100);
             res = pstatement.executeUpdate();*/
             
             sql = "update usuarios set clave='Rey' where id=1072394575";
             pstatement = connection.prepareStatement(sql);
             int res = pstatement.executeUpdate();
            
             /*sql = "update usuarios set clave=? where id=?";
             pstatement = connection.prepareStatement(sql);
             pstatement.setString(1, "456");
             pstatement.setInt(2, 100);
             res = pstatement.executeUpdate();*/
             
             
             
            sql ="select usuario,clave from usuarios";
            pstatement = connection.prepareStatement(sql);
            resultSet = pstatement.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));
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
