/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo2;

import persona.Persona;

/**
 *
 * @author EST_2F_MCB_PC20_
 */
public class Inicio {
    public static void main(String[] args) {
        ClaseGenerica<String> p1 = new ClaseGenerica <String>("ABC");
        ClaseGenerica<Integer> p2 = new ClaseGenerica <Integer>(123);
        
        ClaseGenerica<Double> p3 = new ClaseGenerica <Double>(new Double(12.20));
        Persona x = new Persona();
        ClaseGenerica<Persona> p4 = new ClaseGenerica <Persona>(x);
        ClaseGenerica<String> p5 = new ClaseGenerica <String>();
        p5.setObj("datos");
        
        System.out.println("p1 "+p1.toString());
        System.out.println("p2 "+p2.toString());
        System.out.println("p3 "+p3.toString());
        System.out.println("p4 "+p4.toString());
        System.out.println("p5 "+p5.toString());
    }
}
