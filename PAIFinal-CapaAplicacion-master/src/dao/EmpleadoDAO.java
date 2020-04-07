/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.DBFactory;
import dto.EmpleadoDTO;
import datos.BaseDatos;
import dto.CargoDTO;
import java.io.Serializable;
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
public abstract class EmpleadoDAO{
    
    public abstract Collection<EmpleadoDTO> obtenerPrimerosEmpleados(int id);
    
    public Collection<EmpleadoDTO> obtenerEmpleadosCargos(int id) throws SQLException, ClassNotFoundException{
        PreparedStatement pstatement=null;
        ResultSet resultSet=null;
        String sql ="select e.identificacion, e.nombres, e.apellidos from empleados e, historiallaboral h where h.identificacion = e.identificacion and h.cargo=?";
        Vector<EmpleadoDTO> listado = new Vector<EmpleadoDTO>();
        
        BaseDatos con = (BaseDatos)DBFactory.getInstancia("CON");
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

    public Collection<EmpleadoDTO> listadoEmpleados() throws SQLException, ClassNotFoundException {
        PreparedStatement pstatement=null;
        ResultSet resultSet=null;
        String sql ="select e.identificacion, e.nombres, e.apellidos, curdate() from empleados e";
        Vector<EmpleadoDTO> listado = new Vector<EmpleadoDTO>();
        
        BaseDatos con = (BaseDatos)DBFactory.getInstancia("CON");
        Connection conne = con.getConection();
        
        pstatement = conne.prepareStatement(sql);
        resultSet = pstatement.executeQuery();
        while(resultSet.next()){
            //CargosDTO cargo = new CargosDTO(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), ResultSet.getString(4));
            EmpleadoDTO empleado = new EmpleadoDTO(resultSet.getDouble(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
            listado.add(empleado);
        }
        return listado;
    }
    public String insertarEmpleado(EmpleadoDTO empleado) throws ClassNotFoundException, SQLException{
         String respuesta ="";
         BaseDatos con = (BaseDatos)DBFactory.getInstancia("CON");
         Connection connection = con.getConection();
         String sql = "insert into empleados(identificacion,nombres,apellidos) values(?,?,?)";
        
         PreparedStatement pstatement = connection.prepareStatement(sql);
         pstatement.setDouble(1, empleado.getIdentificacion());
         pstatement.setString(2, empleado.getNombre());
         pstatement.setString(3, empleado.getApellidos());
         try{
             int res = pstatement.executeUpdate();
       
             respuesta = "Empleado insertado -> "+empleado.toString();
         
         }catch(SQLException ex){respuesta = "Error -> "+ex.getMessage();}
         
      return respuesta;
    }
    public EmpleadoDTO obtenerEmpleado(double id) throws SQLException, ClassNotFoundException{
       PreparedStatement pstatement=null;
        ResultSet resultSet=null;
        String sql ="select e.identificacion, e.nombres, e.apellidos, curdate() from empleados e where identificacion = ?";
        
        
        BaseDatos con = (BaseDatos)DBFactory.getInstancia("CON");
        Connection conne = con.getConection();
        
        pstatement = conne.prepareStatement(sql);
        pstatement.setDouble(1, id);
        resultSet = pstatement.executeQuery();
         EmpleadoDTO empleado = null;
        while(resultSet.next()){
            //CargosDTO cargo = new CargosDTO(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), ResultSet.getString(4));
            empleado = new EmpleadoDTO(resultSet.getDouble(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
            
        }
        return empleado;
    }
    public String modificarEmpleado(EmpleadoDTO empleado) throws ClassNotFoundException, SQLException{
         String respuesta ="";
         BaseDatos con = (BaseDatos)DBFactory.getInstancia("CON");
         Connection connection = con.getConection();
         String sql = "update empleados set nombres=?, apellidos = ? where identificacion=?";
              
         PreparedStatement pstatement = connection.prepareStatement(sql);
         pstatement.setString(1, empleado.getNombre());
         pstatement.setString(2, empleado.getApellidos());
         pstatement.setDouble(3, empleado.getIdentificacion());

         try{
             int res = pstatement.executeUpdate();
             respuesta = "Empleado modificado -> "+empleado.toString();
         }catch(SQLException ex){respuesta = "Error -> "+ex.getMessage();}
         
      return respuesta;
    }
    public String eliminarEmpleado(double id) throws ClassNotFoundException, SQLException{
         String respuesta ="";
         BaseDatos con = (BaseDatos)DBFactory.getInstancia("CON");
         Connection connection = con.getConection();
         String sql = "delete from empleados where identificacion=?";
              
         PreparedStatement pstatement = connection.prepareStatement(sql);
         pstatement.setDouble(1, id);

         try{
             int res = pstatement.executeUpdate();
             respuesta = "Empleado eliminado -> identificacion :"+id;
         }catch(SQLException ex){respuesta = "Error -> "+ex.getMessage();}
         
      return respuesta;
    }
}
