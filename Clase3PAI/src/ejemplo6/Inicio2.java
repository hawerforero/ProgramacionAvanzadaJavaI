/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo6;

import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author EST_2F_MCB_PC20_
 */
public class Inicio2 {
    public static void main(String[] args) {
        Stack<Integer> v6 = new Stack<Integer>();
        System.out.println("Cantidad de elemntos de pila: "+v6.size());
        v6.push(10);
        v6.push(5);
        v6.push(2);
        v6.push(15);
        v6.push(-8);
        Iterator i = v6.iterator();
        while(i.hasNext())
            System.out.println("Dato "+i.next());
        System.out.println("Cantidad de elemntos de la Pila: "+v6.size());
        System.out.println("Primer elemnto de la Pila: "+v6.firstElement());
        System.out.println("Ultimo elemnto de la pila: "+v6.peek());
        v6.pop();//Quitar elemnto
        v6.pop();
        i = v6.iterator();
        while(i.hasNext())
            System.out.println("Dato "+i.next());
        System.out.println("Cantidad de elemntos de la Pila: "+v6.size());
        System.out.println("Primer elemnto de la Pila: "+v6.firstElement());
        System.out.println("Ultimo elemnto de la pila: "+v6.peek());
        v6.removeAllElements();//quitar todos los elementos
        System.out.println("Cantidad de elemntos de la Pila: "+v6.size());
    }
}
