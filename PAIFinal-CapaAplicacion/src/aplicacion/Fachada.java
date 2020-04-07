/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;


import factory.DBFactory;
import dto.HistorialLaboralDTO;
import dto.EmpleadoDTO;
import dto.CargoDTO;
import dao.EmpleadoDAO;
import dao.CargoDAO;
import dao.HistorialLaboralDAO;
import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class Fachada {
    
    public Collection<CargoDTO> obtenerCargos() throws SQLException, ClassNotFoundException{
        CargoDAO cargos = new CargoDAO();
        return cargos.listadoCargos();
    }
    public CargoDTO obtenerCargo(int id) throws SQLException, ClassNotFoundException{
        CargoDAO cargos = new CargoDAO();
        return cargos.obtenerCargo(id);
    }
    public String insertarCargo(CargoDTO cargo) throws SQLException, ClassNotFoundException{
        CargoDAO cargoDAO = new CargoDAO();
        return cargoDAO.insertarCargo(cargo);
    }
    
    public String modificarCargo(CargoDTO cargo) throws SQLException, ClassNotFoundException{
        CargoDAO cargoDAO = new CargoDAO();
        return cargoDAO.modificarCargo(cargo);
    }
    
    public String eliminarCargo(int id) throws SQLException, ClassNotFoundException{
        CargoDAO cargoDAO = new CargoDAO();
        return cargoDAO.eliminarCargo(id);
    }
    
    public Collection<EmpleadoDTO> obtenerEmpleados() throws SQLException, ClassNotFoundException{
        EmpleadoDAO empleados = (EmpleadoDAO)DBFactory.getInstancia("EMP");
        return empleados.listadoEmpleados();
    }
     public String insertarEmpleado(EmpleadoDTO empleado) throws SQLException, ClassNotFoundException{
        EmpleadoDAO empleadoDAO = (EmpleadoDAO)DBFactory.getInstancia("EMP");
        return empleadoDAO.insertarEmpleado(empleado);
    }
    public EmpleadoDTO obtenerEmpleado(double id) throws SQLException, ClassNotFoundException{
        EmpleadoDAO empleado =  (EmpleadoDAO)DBFactory.getInstancia("EMP");
        return empleado.obtenerEmpleado(id);
    }
    
    public String modificarEmpleado(EmpleadoDTO empleado) throws SQLException, ClassNotFoundException{
        EmpleadoDAO empleadoDAO = (EmpleadoDAO)DBFactory.getInstancia("EMP");
        return empleadoDAO.modificarEmpleado(empleado);
    }
    
    public String eliminarEmpleado(double id) throws SQLException, ClassNotFoundException{
        EmpleadoDAO empleadoDAO = (EmpleadoDAO)DBFactory.getInstancia("EMP");
        return empleadoDAO.eliminarEmpleado(id);
    }
    
    public Collection<HistorialLaboralDTO> obtenerHistorialLaboral() throws SQLException, ClassNotFoundException{
        HistorialLaboralDAO historial = new HistorialLaboralDAO();
        return historial.listadoHistorial();
    }
    public String insertarHistorial(HistorialLaboralDTO historial) throws SQLException, ClassNotFoundException{
        HistorialLaboralDAO historialDAO = new HistorialLaboralDAO();
        return historialDAO.insertarHistorial(historial);
    }
    
    public String modificarHistorial(int id, double identificacion, int cargo) throws SQLException, ClassNotFoundException{
        HistorialLaboralDAO historialDAO = new HistorialLaboralDAO();
        return historialDAO.modificarHistorial(id, identificacion, cargo);
    }
    
    public String eliminarHistorial(int id) throws SQLException, ClassNotFoundException{
        HistorialLaboralDAO historialDAO = new HistorialLaboralDAO();
        return historialDAO.eliminarHistorial(id);
    }
    public Collection<EmpleadoDTO> obtenerEmpleadosCargos(int id) throws SQLException, ClassNotFoundException{
        //EmpleadoDAO empe = new EmpleadoDAOImplementacionMySQL();
        //EmpleadoDAO empe = new EmpleadoDAOImplementacionORACLE();
         EmpleadoDAO emple = (EmpleadoDAO)DBFactory.getInstancia("EMP");
      
        return emple.obtenerEmpleadosCargos(id);
    }
    public Collection<EmpleadoDTO> obtenerPrimerosNEmpleados(int id) throws SQLException, ClassNotFoundException{
        //EmpleadoDAO empe = new EmpleadoDAOImplementacionMySQL();
        //EmpleadoDAO empe = new EmpleadoDAOImplementacionORACLE();
         EmpleadoDAO emple = (EmpleadoDAO)DBFactory.getInstancia("EMP");
        return emple.obtenerPrimerosEmpleados(id);
    }
    
}
