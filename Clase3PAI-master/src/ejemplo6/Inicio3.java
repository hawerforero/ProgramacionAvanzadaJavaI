/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo6;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author EST_2F_MCB_PC20_
 */
public class Inicio3 {
    public static void main(String[] args) {
        Queue <Integer> v5 = new LinkedList<Integer>();
        v5.add(1);
        v5.offer(-1);
        v5.offer(5);
        v5.add(3);
        System.out.println("Recorriendo con for-each");  
        for(Integer valor: v5){
            System.out.println("Elemento "+ valor.toString());
        }
        System.out.println("Primer elemento "+v5.element());
        System.out.println("Cantidad de elementos "+v5.size());
        v5.poll();
        
        System.out.println("Recorriendo con iterador");  
        Iterator i = v5.iterator();
        while(i.hasNext())
            System.out.println("Elemento "+i.next());
        
        System.out.println("Primer elemento "+v5.peek());
        System.out.println("Cantidad de elementos "+v5.size());
        
        v5.remove(5);
        System.out.println("Recorriendo con iterador");  
        i=v5.iterator();
        while(i.hasNext())
            System.out.println("Elemento "+i.next());
        
        System.out.println("Primer elemento "+v5.peek());
        System.out.println("Cantidad de elementos "+v5.size());
    }
    
       
    
}
