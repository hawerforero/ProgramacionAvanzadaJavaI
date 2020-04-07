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
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class ConexionOracle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
        Connection connection = null;
        PreparedStatement pstatement=null;
        ResultSet resultSet = null;
        
        String instancia = "XE";
        String usuario = "repositorio1";
        String pass = "unillanos";
        String puerto = "1521";
        String ip = "172.16.201.212";
        String url = "jdbc:oracle:thin:@"+ip+":"+puerto+":"+instancia;
        String sql = "";
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(url,usuario,pass);
            sql ="select IDENTIFICACION, TIPO, NOMBRE_1, NOMBRE_2, APELLIDO_1, APELLIDO_2 from personal";
            pstatement = connection.prepareStatement(sql);
            resultSet = pstatement.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4));
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
