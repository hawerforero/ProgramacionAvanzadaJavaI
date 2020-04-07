/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo5;

import persona.Persona;

/**
 *
 * @author EST_2F_MCB_PC20_
 */
public class Inicio {
    
    public static void main(String[] args) {
    Persona p1 = new Persona(10, "HAwer", "Forero");
    Persona p2 = new Persona(20, "HAwer", "Forero");
    Persona p3 = new Persona(10, "HAwer", "Forero");
    Persona p4 = new Persona(30, "HAwer", "Forero");
    Persona p5 = new Persona(40, "HAwer", "Forero");
    Persona p6 = new Persona(50, "HAwer", "Forero");
    ColeccionPersonas<Persona> c = new ColeccionPersonas<Persona>();
    c.insetarDatos(p1);
    c.insetarDatos(p2);
    c.insetarDatos(p3);
    c.insetarDatos(p4);
    c.insetarDatos(p5);
    
    
    c.insetarDatos(p6);
        for (int i = 0; i < c.getListado().length ; i++) {
            System.out.println(c.getListado()[i].toString());
        }
    }
   
    
}
