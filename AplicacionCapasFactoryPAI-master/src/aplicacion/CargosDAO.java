/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import datos.BaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Vector;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class CargosDAO {
    public Collection<CargosDTO> listadoCargos() throws SQLException, ClassNotFoundException{
        PreparedStatement pstatement=null;
        ResultSet resultSet=null;
        String sql ="select id, cargo, sede, salario from cargos order by 1 desc";
        Vector<CargosDTO> listado = new Vector<CargosDTO>();
        
        BaseDatos con = (BaseDatos)ConFactory.getInstancia("CON");
        Connection conne = con.getConection();
        
        
        pstatement = conne.prepareStatement(sql);
        resultSet = pstatement.executeQuery();
        while(resultSet.next()){
            //CargosDTO cargo = new CargosDTO(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), ResultSet.getString(4));
            CargosDTO cargo = new CargosDTO(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDouble(4));
            listado.add(cargo);
        }
        return listado;
    }

   

    
}
