/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicio;

import cuenta.CuentaAhorros;
import cuenta.CuentaCorriente;
import java.io.IOException;
import java.util.Date;
import persona.Empleado;
import persona.Estudiante;

/**
 *
 * @author hawer
 */
public class Inicio {
    public static void main(String[] args) throws IOException, Exception {
        Empleado empleado = new Empleado("Ingeniero de Sistemas", new Date(), 22222,1072394576, "Hawer", "Forero");
        Estudiante estudiante = new Estudiante("160002443", "Sistemas",new Date(), 1072394576, "Hawer", "Forero");
        CuentaAhorros cuentaAhorros = new CuentaAhorros(5000, "Hawer", "00000003322", 1500000, 12);
        CuentaCorriente cuentaCorriente = new CuentaCorriente(12000, "2",1,9,"Hawer","00000003322", 1500000, 12);
        
        empleado.toPDF();
        estudiante.toPDF();
        cuentaAhorros.toPDF();
        cuentaCorriente.toPDF();
        
        empleado.toExcel();
        estudiante.toExcel();
        cuentaAhorros.toExcel();
        cuentaCorriente.toExcel();
        
        empleado.toXML();
        estudiante.toXML();
        cuentaAhorros.toXML();
        cuentaCorriente.toXML();
        
        empleado.toHTML();
        estudiante.toHTML();
        cuentaAhorros.toHTML();
        cuentaCorriente.toHTML();
    }
}
