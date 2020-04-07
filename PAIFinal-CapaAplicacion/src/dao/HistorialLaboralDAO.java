/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.DBFactory;
import dto.HistorialLaboralDTO;
import datos.BaseDatos;
import dto.EmpleadoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Vector;

/**
 *
 * @author hawer
 */
public class HistorialLaboralDAO {

    public Collection<HistorialLaboralDTO> listadoHistorial() throws ClassNotFoundException, SQLException {
        PreparedStatement pstatement=null;
        ResultSet resultSet=null;
        String sql ="select * from historiallaboral order by 1 desc";
        Vector<HistorialLaboralDTO> listado = new Vector<HistorialLaboralDTO>();
        
        BaseDatos con = (BaseDatos)DBFactory.getInstancia("CON");
        Connection conne = con.getConection();
        
        pstatement = conne.prepareStatement(sql);
        resultSet = pstatement.executeQuery();
        while(resultSet.next()){
            HistorialLaboralDTO historial = new HistorialLaboralDTO(resultSet.getDouble(1),resultSet.getInt(2),resultSet.getDate(3),resultSet.getDate(4));
            listado.add(historial);
        }
        return listado;
    }
     public String insertarHistorial(HistorialLaboralDTO historial) throws ClassNotFoundException, SQLException{
         String respuesta ="";
         BaseDatos con = (BaseDatos)DBFactory.getInstancia("CON");
         Connection connection = con.getConection();
         String sql = "insert into historiallaboral(identificacion,cargo,inicio,finalizo) values(?,?,?,null)";
        
         PreparedStatement pstatement = connection.prepareStatement(sql);
         pstatement.setDouble(1, historial.getIdentificacion());
         pstatement.setInt(2, historial.getCargo());
         pstatement.setDate(3, historial.getInicio());
         //pstatement.setDate(4, historial.getFinalizo());
         try{
             int res = pstatement.executeUpdate();
       
             respuesta = "Historial insertado -> "+historial.toString();
         
         }catch(SQLException ex){respuesta = "Error -> "+ex.getMessage();}
         
      return respuesta;
    }
     public String modificarHistorial(int id, double identificacion, int cargo) throws ClassNotFoundException, SQLException{
         String respuesta ="";
         BaseDatos con = (BaseDatos)DBFactory.getInstancia("CON");
         Connection connection = con.getConection();
         String sql = "update historiallaboral set identificacion = ?, cargo = ? where id = ?";
        
         PreparedStatement pstatement = connection.prepareStatement(sql);
         pstatement.setDouble(1, identificacion);
         pstatement.setInt(2, cargo);
         pstatement.setInt(3, id);
         //pstatement.setDate(4, historial.getFinalizo());
         try{
             int res = pstatement.executeUpdate();
       
             respuesta = "Historial modificado -> id: "+id+" identificacion: "+identificacion+" cargo: "+cargo;
         
         }catch(SQLException ex){respuesta = "Error -> "+ex.getMessage();}
         
      return respuesta;
    }
    public String eliminarHistorial(int id) throws ClassNotFoundException, SQLException{
         String respuesta ="";
         BaseDatos con = (BaseDatos)DBFactory.getInstancia("CON");
         Connection connection = con.getConection();
         String sql = "delete from historiallaboral where id = ?";
        
         PreparedStatement pstatement = connection.prepareStatement(sql);
         pstatement.setInt(1, id);
         //pstatement.setDate(4, historial.getFinalizo());
         try{
             int res = pstatement.executeUpdate();
       
             respuesta = "Historial eliminado -> id: "+id;
         
         }catch(SQLException ex){respuesta = "Error -> "+ex.getMessage();}
         
      return respuesta;
    }
}
