/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class Inicio {
    static public  int esPrimo(int numero)
    {
        int res = 1;
        int contador = 2;
        while(res==1 && contador!=numero){
            if(numero%contador == 0){
                res = 0;
            }
            contador++;
        }
        return res;
    }
    public static void main(String[] args) {
        int n = 1000000;
        int primos = 0;
        for (int i = 1; i <= n; i++) {
            if(Inicio.esPrimo(i)==1)
            {
                //System.out.println(i);
                primos++;
            }
        }
        System.out.println("Total de primos: "+primos+1);
    }
    
}
