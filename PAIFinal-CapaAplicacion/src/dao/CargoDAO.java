/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.CargoDTO;
import factory.DBFactory;
import datos.BaseDatos;
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
public class CargoDAO {
    public Collection<CargoDTO> listadoCargos() throws SQLException, ClassNotFoundException{
        PreparedStatement pstatement=null;
        ResultSet resultSet=null;
        String sql ="select id, cargo, sede, salario from cargos order by 1 desc";
        Vector<CargoDTO> listado = new Vector<CargoDTO>();
        
        BaseDatos con = (BaseDatos)DBFactory.getInstancia("CON");
        Connection conne = con.getConection();
        
        pstatement = conne.prepareStatement(sql);
        resultSet = pstatement.executeQuery();
        while(resultSet.next()){
            CargoDTO cargo = new CargoDTO(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDouble(4));
            listado.add(cargo);
        }
        return listado;
    }
    
    public CargoDTO obtenerCargo(int id) throws SQLException, ClassNotFoundException{
        PreparedStatement pstatement=null;
        ResultSet resultSet=null;
        String sql ="select * from cargos where id = ?";
 
        BaseDatos con = (BaseDatos)DBFactory.getInstancia("CON");
        Connection conne = con.getConection();
        
        pstatement = conne.prepareStatement(sql);
        pstatement.setInt(1, id);
        resultSet = pstatement.executeQuery();
        CargoDTO cargo = null;
        while(resultSet.next()){
            cargo = new CargoDTO(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDouble(4));
            
        }
        return cargo;
    }
    
    public String insertarCargo(CargoDTO cargo) throws ClassNotFoundException, SQLException{
         String respuesta ="";
         BaseDatos con = (BaseDatos)DBFactory.getInstancia("CON");
         Connection connection = con.getConection();
         String sql = "insert into cargos(id,cargo,sede, salario) values(?,?,?,?)";
        
         PreparedStatement pstatement = connection.prepareStatement(sql);
         pstatement.setInt(1, cargo.getId());
         pstatement.setString(2, cargo.getCargo());
         pstatement.setString(3, cargo.getSede());
         pstatement.setDouble(4, cargo.getSalario());
         try{
             int res = pstatement.executeUpdate();
       
             respuesta = "Cargo insertado -> "+cargo.toString();
         
         }catch(SQLException ex){respuesta = "Error -> "+ex.getMessage();}
         
      return respuesta;
    }
    public String modificarCargo(CargoDTO cargo) throws ClassNotFoundException, SQLException{
         String respuesta ="";
         BaseDatos con = (BaseDatos)DBFactory.getInstancia("CON");
         Connection connection = con.getConection();
         String sql = "update cargos set cargo=? where id=?";
              
         PreparedStatement pstatement = connection.prepareStatement(sql);
         pstatement.setString(1, cargo.getCargo());
         pstatement.setInt(2, cargo.getId());

         try{
             int res = pstatement.executeUpdate();
             respuesta = "Cargo modificado -> "+cargo.toString();
         }catch(SQLException ex){respuesta = "Error -> "+ex.getMessage();}
         
      return respuesta;
    }
    public String eliminarCargo(int id) throws ClassNotFoundException, SQLException{
         String respuesta ="";
         BaseDatos con = (BaseDatos)DBFactory.getInstancia("CON");
         Connection connection = con.getConection();
         String sql = "delete from cargos where id=?";
              
         PreparedStatement pstatement = connection.prepareStatement(sql);
         pstatement.setInt(1, id);

         try{
             int res = pstatement.executeUpdate();
             respuesta = "Cargo eliminado -> id: "+id;
         }catch(SQLException ex){respuesta = "Error -> "+ex.getMessage();}
         
      return respuesta;
    }
}
