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
public class DemoRunnable implements Runnable{

    public DemoRunnable() {
    }
    
    @Override
    public void run() {
        try{
            for (int x = 0; x < 100; x++) {
                System.out.println("Soy"+Thread.currentThread().getName()+": "+x);
            }
            System.out.println("Termina thread "+Thread.currentThread().getName());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
