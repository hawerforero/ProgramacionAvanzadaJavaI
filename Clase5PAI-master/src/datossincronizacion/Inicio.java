/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datossincronizacion;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class Inicio {
     public static void main(String cadena[]) throws InterruptedException{
         System.out.println("Inicio de Hilo principal" + Thread.currentThread().getName());
         Datos v = new Datos(3);
         Datos v1 = new Datos(3);
         
         Hilo h1 = new Hilo(v);
         Hilo h2 = new Hilo(v);
         Hilo h3 = new Hilo(v1);
         Hilo h4 = new Hilo(v1);
         
         Thread h11 = new Thread(h1,"JUAN");
         Thread h22 = new Thread(h2,"LUIS");
         Thread h33 = new Thread(h3,"CESAR");
         Thread h44 = new Thread(h4,"PEDRO");
         
         h11.start();
         h22.start();
         h33.start();
         h44.start();
         h11.join();
         h22.join();
         h33.join();
         h44.join();
         
         System.out.println("Fin hilo principal "+Thread.currentThread().getName());
     }
}
