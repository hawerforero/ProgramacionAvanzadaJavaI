/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo8;

import ejemplo6.*;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class Inicio {
    
    public static void main(String[] args) {
        
        //Cuadrado c1 = new Cuadrado(4);
        //System.out.println(c1.calcularArea());
        
        Cuadrado cuadrados[] = new Cuadrado[4];
        Circulo circulos[] = new Circulo[4];
        Rectangulo rectangulos[] = new Rectangulo[4];
        Figura2D[] figuras = new Figura2D[4];
        
        Cuadrado c1 = new Cuadrado(1, "Cuadrado1", "Azul");
        Cuadrado c2 = new Cuadrado(2, "Cuadrado2", "Azul");
        Cuadrado c3 = new Cuadrado(3, "Cuadrado3", "Azul");
        Cuadrado c4 = new Cuadrado(4, "Cuadrado4", "Azul");
        cuadrados[0] = c1;
        cuadrados[1] = c2;
        cuadrados[2] = c3;
        cuadrados[3] = c4;
        
        Rectangulo r1 = new Rectangulo(1,2,"Rectangulo1", "Rojo");
        Rectangulo r2 = new Rectangulo(2,3,"Rectangulo2", "Rojo");
        Rectangulo r3 = new Rectangulo(3,4,"Rectangulo3", "Rojo");
        Rectangulo r4 = new Rectangulo(4,5,"Rectangulo4", "Rojo");
        rectangulos[0] = r1;
        rectangulos[1] = r2;
        rectangulos[2] = r3;
        rectangulos[3] = r4;
        
        Circulo ci1 = new  Circulo(1,"Circulo1", "Verde");
        Circulo ci2 = new Circulo(2,"Circulo1", "Verde");
        Circulo ci3 = new Circulo(3,"Circulo1", "Verde");
        Circulo ci4 = new Circulo(4,"Circulo1", "Verde");
        circulos[0] = ci1;
        circulos[1] = ci2;
        circulos[2] = ci3;
        circulos[3] = ci4;
        
        figuras[0] = c1;
        figuras[1] = ci1;
        figuras[2] = r1;
        figuras[3] = c2;
        
        System.out.println("CUADRADOS");
        for (int i = 0; i < 4; i++) {
            cuadrados[i].calcularArea();
            System.out.println(cuadrados[i]);
        }
        
        System.out.println("CIRCULOS");
        for (int i = 0; i < 4; i++) {
            circulos[i].calcularArea();
            System.out.println(circulos[i]);
        }
        
        System.out.println("RECTANGULOS");
        for (int i = 0; i < 4; i++) {
            rectangulos[i].calcularArea();
            System.out.println(rectangulos[i]);
        }
        
        System.out.println("FIGURAS");
        for (int i = 0; i < 4; i++) {
           // figuras[i]
            System.out.println(figuras[i]);
           /* if(figuras[i] instanceof Cuadrado){
                System.out.println("SOY UN CUADRADO");
                Cuadrado c = new Cuadrado();
                c = (Cuadrado) figuras[i];
                System.out.println(c); 
               
            }
            if(figuras[i] instanceof Circulo){
                System.out.println("SOY UN CIRCULO");
                Circulo c = new Circulo();
                c = (Circulo) figuras[i];
                 System.out.println(c); 
            }
            if(figuras[i] instanceof Rectangulo){
                System.out.println("SOY UN RECTANGULO");
                Rectangulo r = new Rectangulo();
                r = (Rectangulo) figuras[i];
                System.out.println(r); 
            }*/
            
           
        }
        
    }
}
