/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class Inicio {
    public static void main(String[] args) throws CloneNotSupportedException {
        A ob1 = new A(2,3);
        A ob2 = new A(5,5);
        A ob3 = (A)ob1.clone();
        A ob4 = ob2;
        A ob5 = new A(2,3);
        
        System.out.println("Valores de ob1*******");
        System.out.println("X: "+ob1.getX()+" Y: "+ob1.getY());
        System.out.println("toString: "+ob1.toString());
        
        System.out.println("Valores de ob2*******");
        System.out.println("X: "+ob2.getX()+" Y: "+ob2.getY());
        System.out.println("toString: "+ob2.toString());
        
        System.out.println("Valores de ob3*******");
        System.out.println("X: "+ob3.getX()+" Y: "+ob3.getY());
        System.out.println("toString: "+ob3.toString());
        
        System.out.println("Valores de ob4*******");
        System.out.println("X: "+ob4.getX()+" Y: "+ob4.getY());
        System.out.println("toString: "+ob4.toString());
        
        System.out.println("Valores de ob5*******");
        System.out.println("X: "+ob5.getX()+" Y: "+ob5.getY());
        System.out.println("toString: "+ob5.toString());
        
        System.out.println("Comparar contenido equals****");
        System.out.println("ob1 igual a ob2? "+ob1.equals(ob2));
        System.out.println("ob2 igual a ob4? "+ob2.equals(ob4));
        System.out.println("ob5 igual a ob1? "+ob5.equals(ob1));
        System.out.println("ob3 igual a ob1? "+ob3.equals(ob1));
        
        System.out.println("Comparar contenido compareTO****");
        System.out.println("ob1 igual a ob2? "+ob1.compareTo(ob2));
        System.out.println("ob2 igual a ob4? "+ob2.compareTo(ob4));
        System.out.println("ob5 igual a ob1? "+ob5.compareTo(ob1));
        System.out.println("ob3 igual a ob1? "+ob3.compareTo(ob1));
    }
}
