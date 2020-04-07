/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicio;

import generic.ColeccionPersonas;
import java.util.Date;
import persona.Empleado;
import persona.Estudiante;
import persona.Persona;

/**
 *
 * @author hawer
 */
public class Inicio {
     public static void main(String[] args) {
     
    Empleado emp1 = new Empleado("Ingeniero de Sistemas", new Date(), 220000,44, "Hawer", "Forero");
    Empleado emp2 = new Empleado("Auxiliar", new Date(), 1200000,11, "Alfonso", "Suarez");
    Empleado emp3 = new Empleado("Contador", new Date(), 3000000,33, "Rocio", "Sanchez");
    Empleado emp4 = new Empleado("Asistente", new Date(), 9000000,00, "Nelly", "Castro");
    Empleado emp5 = new Empleado("Vendedor", new Date(), 7000000,22, "Carlos", "Rey");
   
    Estudiante est1 = new Estudiante("4", "Especializacion Ingenieria de Software",new Date(), 11, "Hawer", "Forero");
    Estudiante est2 = new Estudiante("1", "Especializacion Ingenieria de Software",new Date(), 22, "Rafael", "Cuartas");
    Estudiante est3 = new Estudiante("3", "Especializacion Ingenieria de Software",new Date(), 33, "Santiago", "Cotrino");
    Estudiante est4 = new Estudiante("2", "Sistemas",new Date(), 44, "Pedro", "Perez");
    Estudiante est5 = new Estudiante("5", "Electrinica",new Date(), 55, "Haysson", "Suarez");
    
    Persona p1 = new Persona(22,"Carlos","Perez");
    Persona p2 = new Persona(11,"Pedro","Ramirez");
    Persona p3 = new Persona(00,"rocio","Pilar");
    
    ColeccionPersonas<Persona> empleados = new ColeccionPersonas<>();
   
    empleados.insetarDatos(emp1);
    empleados.insetarDatos(emp2);
    empleados.insetarDatos(emp3);
    empleados.insetarDatos(emp4);
    empleados.insetarDatos(emp5);
   
    System.out.println("*****Arreglo de Empleados sin ordenar******");
    for (int i = 0; i < empleados.getListado().length ; i++) {
        System.out.println(""+i+" -> "+empleados.getListado()[i]);
    }
    
    empleados.ordenarT();
    
    System.out.println("*****Arreglo de Empleados ordenados******");
    for (int i = 0; i < empleados.getListado().length ; i++) {
       System.out.println(""+i+" -> "+empleados.getListado()[i]);
    }
    
     ColeccionPersonas<Persona> estudiantes = new ColeccionPersonas<>();
     estudiantes.insetarDatos(est1);
     estudiantes.insetarDatos(est2);
     estudiantes.insetarDatos(est3);
     estudiantes.insetarDatos(est4);
     estudiantes.insetarDatos(est5);
     
     System.out.println("*****Arreglo de Estudiantes sin ordenar******");
     for (int i = 0; i < estudiantes.getListado().length ; i++) {
        System.out.println(""+i+" -> "+estudiantes.getListado()[i]);
     }
    
     estudiantes.ordenarT();
      
     System.out.println("*****Arreglo de Estudiantes ordenados******");
     for (int i = 0; i < estudiantes.getListado().length ; i++) {
        System.out.println(""+i+" -> "+estudiantes.getListado()[i]);
     }
     
     ColeccionPersonas<Persona> mixto = new ColeccionPersonas<>();
     mixto.insetarDatos(est1);
     mixto.insetarDatos(est2);
     mixto.insetarDatos(emp1);
     mixto.insetarDatos(p1);
     mixto.insetarDatos(p2);
     mixto.insetarDatos(p3);
     mixto.insetarDatos(emp2);
     mixto.insetarDatos(est3);
     
     System.out.println("*****Arreglo Mixto Personas sin ordenar******");
     for (int i = 0; i < mixto.getListado().length ; i++) {
        System.out.println(""+i+" -> "+mixto.getListado()[i]);
     }
    
     mixto.ordenarT();
      
     System.out.println("*****Arreglo Mixto de Personas ordenadas******");
     for (int i = 0; i < mixto.getListado().length ; i++) {
        System.out.println(""+i+" -> "+mixto.getListado()[i]);
     }
    }
}
