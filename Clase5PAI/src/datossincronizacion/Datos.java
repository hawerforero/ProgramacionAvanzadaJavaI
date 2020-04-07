/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datossincronizacion;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class Datos {
    private int sumatoria;
    private int arreglo[];
    private final int n;

    public Datos(int n) {
        this.sumatoria=0;
        this.n = n;
        arreglo = new int[n];
        for (int x = 0; x < n; x++) {
            arreglo[x]=x;
        }
    }
    public synchronized int sumar()
    {
        System.out.println("Ingreso "+Thread.currentThread().getName());
        this.sumatoria=0;
        for (int x = 0; x < n; x++) {
            this.sumatoria = this.sumatoria+arreglo[x];
            try{
                System.out.println("Bloqueado por "+Thread.currentThread().getName()+" Valor de la suma = "+this.sumatoria);
                Thread.sleep(10);
            }catch(InterruptedException ex){
                Logger.getLogger(Datos.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
        System.out.println("Termino "+Thread.currentThread().getName());
        return sumatoria;
    }
    
}
