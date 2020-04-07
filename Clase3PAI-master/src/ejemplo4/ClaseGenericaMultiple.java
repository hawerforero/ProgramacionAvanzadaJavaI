/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo4;

/**
 *
 * @author EST_2F_MCB_PC20_
 */
public class ClaseGenericaMultiple <T,V> {
    T obj1;
    V obj2;

    public ClaseGenericaMultiple(T obj1, V obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    
    public T getObj1() {
        return obj1;
    }

    public void setObj1(T obj1) {
        this.obj1 = obj1;
    }

    public V getObj2() {
        return obj2;
    }

    public void setObj2(V obj2) {
        this.obj2 = obj2;
    }

    
    
    @Override
    public String toString() {
        return "Tipo de dato T es "+this.obj1.getClass().getCanonicalName()+"\t Valor inicial es "+this.obj1+" \t Tipo de dato de V es "+this.obj2.getClass().getName()+"\t Valor inicial es "+this.obj2;
    }
    
    
}
