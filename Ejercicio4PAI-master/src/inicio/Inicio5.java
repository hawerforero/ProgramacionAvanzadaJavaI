/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicio;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import persona.Persona;

/**
 *
 * @author EST_2F_MCB_PC20_
 */
public class Inicio5 {
    public static void main(String[] args) {
        Hashtable <String, ArrayList<Persona>> v8 = new Hashtable <String, ArrayList<Persona>>();
        Persona x1 = new Persona(1, "JUAN", "RODRIGUEZ");
        Persona x2 = new Persona(2, "LUIS", "SILVA");
        Persona x3 = new Persona(3, "CESAR", "RUIZ");
       
        ArrayList<Persona> per1 = new ArrayList<Persona>();
        per1.add(x1);
         ArrayList<Persona> per2 = new ArrayList<Persona>();
        per2.add(x2);
         ArrayList<Persona> per3 = new ArrayList<Persona>();
        per3.add(x3);
        v8.put(x1.getNombres(), per1);
        v8.put(x2.getNombres(), per2);
        v8.put(x3.getNombres(), per3);
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
       
        
        System.out.println("***NUEVA PERSONA*******");
        Persona x4 = new Persona(4, "JUAN", "RODRIGUEZ");
        
       
        if(v8.get(x4.getNombres())!=null)
        {
            v8.get(x4.getNombres()).add(x4);
        }
        System.out.println(v8.get(x1.getNombres()));
        System.out.println(v8.get(x2.getNombres()));
        System.out.println(v8.get(x3.getNombres()));
        
        System.out.println("******DATOS DE LA TABLA*******");
        Enumeration<ArrayList<Persona>> valor = v8.elements();
         while(valor.hasMoreElements())
             System.out.println(valor.nextElement());
        System.out.println("*****LAS KEY*******");
        keys = v8.keys();
        while(keys.hasMoreElements())
             System.out.println(keys.nextElement());
        System.out.println("****TAMAÑO DE LA TABLA***");
        System.out.println(v8.size()); 
        
        System.out.println("*VALORES QUE TIENE JUAN*");
        System.out.println(v8.get("JUAN").toString());
    }
    
    
}
