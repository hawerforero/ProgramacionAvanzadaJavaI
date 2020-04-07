/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo4;

import ejemplo2.Persona;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class Inicio {
    
     public static void main(String[] args) {
         
         System.out.println("Edad minima es "+ Persona.EDAD_MINIMA);
         System.out.println("Cantidad de objetos de tipo Persona es "+ Persona.getCONTADOR_OBJETOS());
         Persona p1 = new Persona();
         Persona p2 = new Persona();
         Persona p3 = new Persona();
         System.out.println("Cantidad de objetos de tipo Persona es "+ Persona.getCONTADOR_OBJETOS());
     }
    
}
