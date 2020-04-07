/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicio;

import cuenta.Cuenta;
import cuenta.CuentaAhorros;
import cuenta.CuentaCorriente;
import java.util.Date;
import persona.Empleado;
import persona.Estudiante;
import persona.Persona;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class Index {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Date fechaIngreso = new Date();
       
        CuentaAhorros cuentaAhorros = new CuentaAhorros(3000, "Hawer", "00000111",  1222222, 111);
        CuentaCorriente cuentaCorriente = new CuentaCorriente(3000,"chequera",1,4,"Hawer", "00000111",  1222222, 111);
        Cuenta[] cuentas = new Cuenta[2];
        cuentas[0] = cuentaAhorros;
        cuentas[1] = cuentaCorriente;
        
        Empleado em1 = new Empleado("Ingeniero",fechaIngreso, 20000, 1072394576, "Hawer", "Forero", cuentas);
        Estudiante es1 = new Estudiante("160002443", "Sistemas", fechaIngreso, 1072394576, "Hawer", "Forero", cuentas);
        
        CuentaAhorros cuentaAhorros2 = new CuentaAhorros(3000, "Rafael", "00000111",  1222222, 111);
        CuentaCorriente cuentaCorriente2 = new CuentaCorriente(3000,"chequera",1,4,"Rfael", "00000111",  1222222, 111);
        Cuenta[] cuentas2 = new Cuenta[2];
        cuentas2[0] = cuentaAhorros2;
        cuentas2[1] = cuentaCorriente2;
        
        Empleado em2 = new Empleado("Auxiliar",fechaIngreso, 20000, 1072394576, "Rafael", "Cuartas", cuentas);
        Estudiante es2 = new Estudiante("160002443", "Electronica", fechaIngreso, 1072394576, "Rfael", "Cuartas", cuentas);
        
        
        Persona[] personas = new Persona[5];
        
        personas[0] = em1;
        personas[1] = es1;
        personas[2] = em2;
        personas[3] = es2;
        personas[4] = em1;
        
        for (int i = 0; i < personas.length; i++) {
            System.out.println(personas[i]);
        }
       
        
    }         
    
}
