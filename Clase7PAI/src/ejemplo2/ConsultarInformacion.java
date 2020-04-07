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
public class ConsultarInformacion {
    
    public void consulta1() throws SQLException{
        PreparedStatement pstatement=null;
        ResultSet resultSet=null;
        String sql ="select id, usuario, clave from usuarios order by 1 desc";
        Connection conne = BaseDatos.getConection();
        pstatement = conne.prepareStatement(sql);
        resultSet = pstatement.executeQuery();
        while(resultSet.next()){
            System.out.println(resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3));
        }
    }
    
}
