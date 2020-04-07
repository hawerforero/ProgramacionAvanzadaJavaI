/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicio;

import hilos.DemoRunnable;
import hilos.DemoThread;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class Inicio2{
     public static void main(String cadena[]) throws InterruptedException{
        Thread hilo_principal = Inicio.currentThread();
        System.out.println("Hilo principal "+hilo_principal.getName());
        DemoThread h1 = new DemoThread("juan");
        DemoRunnable p = new DemoRunnable();
        DemoRunnable q = new DemoRunnable();
        Thread h11 = new Thread(p,"juan");
        Thread h22 = new Thread(q,"Pedro");
       
        h1.start();
        h11.start();
        h22.start();
        
        do{
            System.out.println(".");
        }while(h1.isAlive()==true||h11.isAlive()==true||h22.isAlive()==true);
        System.out.println("Fin hilo principal" +hilo_principal);
     }
}
