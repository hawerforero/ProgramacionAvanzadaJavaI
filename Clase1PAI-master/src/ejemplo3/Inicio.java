/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo3;

/**
 *
 * @author EST_2F_MCB_PC21_
 */

public class Inicio {
    
    public void cambiarDatsos(Punto p){
        System.out.println("Valores al llegar p4 al metodo");
        System.out.println("Referencia del objeto p4 "+ p.toString());
        System.out.println("Valores de p "+ p.getX()+" , "+p.getY());
        p.setX(1);
        p.setY(1);
}
    
    public static void main(String[] args) {
        Punto p1 = new Punto();
        Punto p2 = new Punto(5,12);
        
        
        Punto p4 = new Punto();
        
        Inicio q = new Inicio();
       
        System.out.println("Valores iniciales p4");
        System.out.println("Referencia del objeto p4 "+ p4.toString());
        System.out.println("Valores de p4 "+ p4.getX()+" , "+p4.getY());
        q.cambiarDatsos(p4);
        System.out.println("Valores despues de modificar p4");
        System.out.println("Referencia del objeto p4 "+ p4.toString());
        System.out.println("Valores de p4 "+ p4.getX()+" , "+p4.getY());
        
        
        Rectangulo r1 = new Rectangulo();
        Rectangulo r2 = new Rectangulo(p2, 3, 3);
        
        //System.out.println(p1);
        //System.out.println(p2);
        //System.out.println(r1);
        //System.out.println(r2);
    }
}
