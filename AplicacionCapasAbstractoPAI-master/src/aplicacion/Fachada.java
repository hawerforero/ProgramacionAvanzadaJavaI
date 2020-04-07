/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class Fachada {
    
    public Collection<CargosDTO> obtenerCargos() throws SQLException{
        CargosDAO cargos = new CargosDAO();
        return cargos.listadoCargos();
    }
    /*public Collection<EmpleadoDTO> obtenerEmpleadosCargos(int id) throws SQLException{
        EmpleadoDAO empe = new EmpleadoDAO() {
            @Override
            public Collection<EmpleadoDTO> obtenerPrimerosEmpleados(int id) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        return empe.obtenerEmpleadosCargos(id);
    }*/
    public Collection<EmpleadoDTO> obtenerPrimerosNEmpleados(int id) throws SQLException{
        EmpleadoDAO empe = new EmpleadoDAOImplementacionMySQL();
        //EmpleadoDAO empe = new EmpleadoDAOImplementacionORACLE();
        return empe.obtenerPrimerosEmpleados(id);
    }
    
}
