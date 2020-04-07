/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo6;

import java.util.Enumeration;
import java.util.Hashtable;
import persona.Persona;

/**
 *
 * @author EST_2F_MCB_PC20_
 */
public class Inicio4 {
    public static void main(String[] args) {
        Hashtable <String, Persona> v8 = new Hashtable <String, Persona>();
        Persona x1 = new Persona(1, "JUAN", "RODRIGUEZ");
        Persona x2 = new Persona(1, "LUIS", "SILVA");
        Persona x3 = new Persona(1, "CESAR", "RUIZ");
        v8.put(x1.getNombres(), x1);
        v8.put(x2.getNombres(), x2);
        v8.put(x3.getNombres(), x3);
        System.out.println(v8.get(x1.getNombres()));
        System.out.println(v8.get(x2.getNombres()));
        System.out.println(v8.get(x3.getNombres()));
        System.out.println("TAMAÑO DE LA TABLA");
        System.out.println(v8.size()); 
        System.out.println("BUSCAR UNA CLAVE DENTRO DE LA TABLA");
        System.out.println(v8.get("JAVIER")); 
        System.out.println("OBTENER LAS KEYS DE LA TABLA");
        Enumeration<String> keys = v8.keys();
        while(keys.hasMoreElements())
             System.out.println(keys.nextElement());
        System.out.println("OBTENER EL VALOR DE UNA TABLA");
        System.out.println(v8.get("LUIS").toString());
        Enumeration<Persona> valor = v8.elements();
         while(valor.hasMoreElements())
             System.out.println(valor.nextElement());
        
        System.out.println("NUEVA PERSONA");
        Persona x4 = new Persona(4, "JUAN", "RODRIGUEZ");
        v8.put(x4.getNombres(), x4);
        System.out.println(v8.get(x1.getNombres()));
        System.out.println(v8.get(x2.getNombres()));
        System.out.println(v8.get(x3.getNombres()));
        System.out.println(v8.get(x4.getNombres()));
    }
    
}
