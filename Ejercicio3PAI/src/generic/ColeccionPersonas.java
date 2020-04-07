/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generic;

import persona.Empleado;
import persona.Estudiante;
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
    
    public  void ordenarT(){
        Persona aux = new Persona();
        int peso1 = 0;
        int peso2 = 0;
        
        for (int i = 1; i < listado.length; i++) {
            for (int j = 0; j < listado.length-i; j++) {
                    if(listado[j] instanceof Empleado)
                     peso1 = 1;
                    if(listado[j] instanceof Estudiante)
                     peso1 = 2;
                    if(listado[j+1] instanceof Empleado)
                     peso2 = 1;
                    if(listado[j+1] instanceof Estudiante)
                     peso2 = 2;
                    if(peso1 < peso2){
                        aux = listado[j];
                        listado[j] = listado[j+1];
                        listado[j+1] = (T) aux;
                 } 
                    peso1 = 0;
                    peso2 = 0;
            }   
        }
        for (int i = 1; i < listado.length; i++) {
            for (int j = 0; j < listado.length-i; j++) {
               if(listado[j] instanceof Estudiante && listado[j+1] instanceof Estudiante){
                    if(listado[j].compareTo(listado[j+1])==1){
                        aux = listado[j];
                        listado[j] = listado[j+1];
                        listado[j+1] = (T) aux;
                 }
               }  
                if(listado[j] instanceof Empleado && listado[j+1] instanceof Empleado){
                    if(listado[j].compareTo(listado[j+1])==1){
                        aux = listado[j];
                        listado[j] = listado[j+1];
                        listado[j+1] = (T) aux;
                 }
               } 
               if(listado[j] instanceof Empleado||listado[j] instanceof Estudiante||listado[j+1] instanceof Empleado||listado[j+1] instanceof Estudiante){
                   
               }
               else{
                   if(listado[j].compareTo(listado[j+1])==1){
                        aux = listado[j];
                        listado[j] = listado[j+1];
                        listado[j+1] = (T) aux;
                 }
               }
            }   
        } 
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
