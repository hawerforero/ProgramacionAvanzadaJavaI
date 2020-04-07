/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class Primos implements Runnable{
    int n;
    int primos = 0;
    public Primos(int n){this.n=n;}
    @Override
    public void run() {
        
         try{
            for (int i = 2; i <= this.n; i++) {
                if(Primos.esPrimo(i)==1)
                {
                    //System.out.println(i);
                    //System.out.println("Soy"+Thread.currentThread().getName()+" "+i);
                    this.primos++;
                }
            }   
            System.out.println("Termina thread "+Thread.currentThread().getName()+" con total primos: "+primos+1);
        }
        catch(Exception e){
            e.printStackTrace();
        }   
    }
    
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
    
}
