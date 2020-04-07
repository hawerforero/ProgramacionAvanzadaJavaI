/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.DBFactory;
import dto.EmpleadoDTO;
import datos.BaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class EmpleadoDAOImplementacionORACLE extends EmpleadoDAO{
    @Override
    public Collection<EmpleadoDTO> obtenerPrimerosEmpleados(int id) {
        
        PreparedStatement pstatement=null;
        ResultSet resultSet=null;
        String sql ="select e.identificacion, e.nombres, e.apellidos , sysdate";
        sql = sql +"from empleados e";
        sql = sql +"  where rownum <= "+id+" order by 2 asc";
        
        Vector<EmpleadoDTO> listado = new Vector<EmpleadoDTO>();
        try{
            
           BaseDatos con = (BaseDatos)DBFactory.getInstancia("CON");
           Connection conne = con.getConection();
            
            pstatement = conne.prepareStatement(sql);
            resultSet = pstatement.executeQuery();
            while(resultSet.next()){
            
                EmpleadoDTO empleado = new EmpleadoDTO(resultSet.getDouble(1),resultSet.getString(2),resultSet.getString(3), resultSet.getString(4));
                listado.add(empleado);
            }
        }catch(SQLException ex){System.out.println(ex);} catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpleadoDAOImplementacionORACLE.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listado;
    }
    
}
