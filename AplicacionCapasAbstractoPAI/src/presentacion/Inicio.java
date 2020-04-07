/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import aplicacion.CargosDTO;
import aplicacion.EmpleadoDTO;
import aplicacion.Fachada;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Fachada fachada = new Fachada();
        
        System.out.println("Listado de cargos");
        Vector<CargosDTO> cargos = (Vector<CargosDTO>) fachada.obtenerCargos();
        for (CargosDTO c: cargos) 
            System.out.println(c.toString());
        
        /*System.out.println("Listado de Empleados con el cargo 4");
        Vector<EmpleadoDTO> emple = (Vector<EmpleadoDTO>) fachada.obtenerEmpleadosCargos(2);
        for (EmpleadoDTO e: emple) 
            System.out.println(e.toString());  */ 
        
        System.out.println("Listado primeros 3 empleados");
        Vector<EmpleadoDTO> emple = (Vector<EmpleadoDTO>) fachada.obtenerPrimerosNEmpleados(3);
        for (EmpleadoDTO e: emple) 
            System.out.println(e.toString());   
    }
    
}
