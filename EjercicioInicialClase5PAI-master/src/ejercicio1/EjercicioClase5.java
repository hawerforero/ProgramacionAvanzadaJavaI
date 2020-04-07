/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class EjercicioClase5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        long n = 1000000000;
        long suma = 0;
        for (int i = 0; i < n; i++) {
            suma = suma+i;
        }
        System.out.println(suma);
    }
    
}
