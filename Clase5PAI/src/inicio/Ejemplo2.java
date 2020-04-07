/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicio;

import hilos.DemoRunnable;
import hilos.Potencias2;
import hilos.Primos;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class Ejemplo2 extends Thread{
    public static void main(String cadena[]) throws InterruptedException{
        Thread hilo_principal = Ejemplo2.currentThread();
        System.out.println("Hilo principal "+hilo_principal.getName());
        DemoRunnable p = new DemoRunnable();
        DemoRunnable q = new DemoRunnable();
        Thread h1 = new Thread(p,"juan");
        Thread h2 = new Thread(q,"Pedro");
        Thread h3 = new Thread(new DemoRunnable(), "Luis");
        Thread h4 = new Thread(new Potencias2(128),"Potencia");
        Thread h5 = new Thread(new Primos(10),"Primo");
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
       
       
    }
}
