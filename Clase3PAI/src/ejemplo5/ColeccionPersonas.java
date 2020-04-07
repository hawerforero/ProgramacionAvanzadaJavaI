/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo5;

import persona.Persona;

/**
 *
 * @author EST_2F_MCB_PC20_
 */
public class ColeccionPersonas<T extends Persona> {
    private T obj;
    private T listado[];
    private int pos = 0;
    private final int TAMA = 3;
    
    public ColeccionPersonas(){
        this.listado = (T[]) new Persona[this.TAMA];
        
    }
    
    public void insetarDatos(T dato){
      
        if(listado.length!=this.pos){
            listado[pos] = dato;
            pos ++;
        }
        else{
            Persona[] aux = new Persona[listado.length];
            for (int i = 0; i < aux.length; i++) {
                 aux[i]= listado[i];
            }
            this.listado = (T[]) new Persona[listado.length+1];
            for (int i = 0; i < aux.length; i++) {
                listado[i] = (T) aux[i];
            }
            
            listado[pos] = dato; 
            pos ++;
        }
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public T[] getListado() {
        return listado;
    }

    public void setListado(T[] listado) {
        this.listado = listado;
    }

   

    @Override
    public String toString() {
        return "ColeccionPersonas{" + "obj=" + obj + ", listado=" + listado + ", pos=" + pos + ", TAMA=" + TAMA + '}';
    } 
    //OrdenarT();
    //Empleado por identificacion
    //Estudiante por codigo
    //Persona por identificacion
}
