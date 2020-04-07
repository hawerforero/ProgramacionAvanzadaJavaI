/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicio;

import hilos.DemoThread;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class Inicio extends Thread{
    public static void main(String cadena[]) throws InterruptedException{
        Thread hilo_principal = Inicio.currentThread();
        System.out.println("Hilo principal "+hilo_principal.getName());
        DemoThread h1 = new DemoThread("juan");
        DemoThread h2 = new DemoThread("Pedro");
        DemoThread h3 = new DemoThread("Luis");
        DemoThread h4 = new DemoThread("xxx");
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        
        h1.join();
        h2.join();
        h3.join();
        h4.join();
      
        System.out.println("Fin hilo principal" +hilo_principal.getName());
        
    }
    
}
