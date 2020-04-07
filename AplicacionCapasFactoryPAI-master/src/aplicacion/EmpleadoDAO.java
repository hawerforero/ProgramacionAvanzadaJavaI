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
public abstract class EmpleadoDAO {
    
    public abstract Collection<EmpleadoDTO> obtenerPrimerosEmpleados(int id);
    
    public Collection<EmpleadoDTO> obtenerEmpleadosCargos(int id) throws SQLException, ClassNotFoundException{
        PreparedStatement pstatement=null;
        ResultSet resultSet=null;
        String sql ="select e.identificacion, e.nombres, e.apellidos, from empleados e, historiallaboral h where h.identificacion = e.identificacion and h.cargo=?";
        Vector<EmpleadoDTO> listado = new Vector<EmpleadoDTO>();
        
        BaseDatos con = (BaseDatos)ConFactory.getInstancia("CON");
        Connection conne = con.getConection();
        
        pstatement = conne.prepareStatement(sql);
         pstatement.setInt(1, id);
        resultSet = pstatement.executeQuery();
        while(resultSet.next()){
            //CargosDTO cargo = new CargosDTO(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), ResultSet.getString(4));
            EmpleadoDTO empleado = new EmpleadoDTO(resultSet.getDouble(1),resultSet.getString(2),resultSet.getString(3),"");
            listado.add(empleado);
        }
        return listado;
    }
}
