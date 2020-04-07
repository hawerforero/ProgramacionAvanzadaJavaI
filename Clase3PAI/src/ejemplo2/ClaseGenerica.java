/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo2;

/**
 *
 * @author EST_2F_MCB_PC20_
 */
public class ClaseGenerica <T>{
    private T obj;
    public ClaseGenerica() {
        super();
    }
    public ClaseGenerica(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "Tipo de dato T es "+this.obj.getClass().getName()+"\t Valor inicial es "+this.obj;
    }
    
}
