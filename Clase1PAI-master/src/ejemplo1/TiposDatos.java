/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo1;

import java.util.Date;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class TiposDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String cadena = "abc";
        int x1 = 0;
        double y = 5;
        int X = 10;
        Integer h = 123;
        Date valor = new Date();
        /*System.out.println("Texto");
        System.out.println("Texto " + cadena);
        System.out.println("Valor de X = " + X);
        System.out.println("Valor de x = " + x1);
        System.out.println("Valor de x = " + x1);
        System.out.println("Suma de x+y = " + x1+y);
        System.out.println("Suma de x+y = " + (x1+y));
        System.out.println("Integer h = " + h);
        System.out.println("Date valor = " + valor);*/
        
        char x = 0;
        int contador = 0;
        char m[];
        m = new char[16000];
        double n[][] = new double [3][3];
        String t[][] = new String [4][];
        t[0] = new String[3];
        t[1] = new String[2];
        t[2] = new String[3];
        t[3] = new String[2];
        
        
        for (int i = 0; i < m.length; i++) {
            m[i] = x;
            x++;
        }
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                t[i][j] = "Cadena ("+i+" - "+j+")";
            }
        }
        System.out.println("Arreglo m");
        for (int i = 0; i < m.length; i++) {
            System.out.println(m[i]);
        }
        System.out.println("Arreglo n");
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n[i].length; j++) {
                System.out.println(n[i][j]+" ");
                System.out.println("\n");
            }
        }
         System.out.println("Arreglo t");
         for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                System.out.println(t[i][j]+" ");
                System.out.println("\n");
            }
        }
    }
}
