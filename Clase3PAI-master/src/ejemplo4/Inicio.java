/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo4;

/**
 *
 * @author EST_2F_MCB_PC20_
 */
public class Inicio {
     public static void main(String[] args) {
         ClaseGenericaMultiple <Integer,String> q1 = new ClaseGenericaMultiple <Integer,String>(1000, "ABC" );
         ClaseGenericaMultiple <Integer, Double> q2 = new ClaseGenericaMultiple <Integer, Double>( 100, new Double(0.25) );
         System.out.println("q1 "+q1);
         System.out.println("q2 "+q2);
     }
}
