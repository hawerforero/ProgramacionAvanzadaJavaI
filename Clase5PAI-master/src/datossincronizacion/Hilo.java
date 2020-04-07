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
public class Hilo implements Runnable{
    Datos p;
    String nombre;

    public Hilo(Datos a) {
        super();
        this.p=a;
    }
    
    @Override
    public void run() {
        try{
            System.out.println("Soy "+Thread.currentThread().getName()+" Resultado es"+p.sumar());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
