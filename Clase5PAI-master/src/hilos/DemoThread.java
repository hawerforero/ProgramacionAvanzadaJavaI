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
public class DemoThread extends Thread {

    public DemoThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try{
                long tinicio = System.nanoTime();
                long tinicio2 = System.currentTimeMillis();
                for(int x=0; x<1000000;x++)
                 System.out.println("Soy"+this.getName()+": "+x);
                long tfinal = System.nanoTime();
                long tfinal2 = System.currentTimeMillis();
                System.out.println("***Termina thread"+getName());
                System.out.println("\n Tiempo de ejecucion: "+(tfinal-tinicio)+" ns.");
                System.out.println("\n Tiempo de ejecucion: "+(tfinal2-tinicio2)+" ns.");
                System.out.println("\n Tiempo de ejecucion: "+(tfinal-tinicio)/1000+" s."); 
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    
}
