/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import persona.Persona;
/**
 *
 * @author EST_2F_MCB_PC20_
 */
public class Inicio1 {
    public static void main(String[] args) {
        Vector<String> v1 = new Vector<>();
        v1.add("ABC");
        v1.add("DEF");
        Vector<Persona> v2 = new Vector <Persona>(3);
        v2.add(new Persona());
        v2.add(new Persona());
        v2.add(new Persona());
        ArrayList<Double> v3 = new ArrayList<Double>();
        v3.add(0.25);
        v3.add(0.2521);
        v3.add(0.252152);
        LinkedList<Double> v4 = new LinkedList<Double>();
        v4.add(3.14);
        v4.add(3.1415);
        v4.add(3.141516);
        
        for(String valor:v1)
            System.out.println(valor.toString());
        for(Persona valor:v2)
            System.out.println(valor.toString());
        for(Double valor:v3)
            System.out.println(valor.toString());
        for(Double valor:v4)
            System.out.println(valor.toString());
    }
}
