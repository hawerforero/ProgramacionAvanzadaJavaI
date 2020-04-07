/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo8;

import ejemplo6.*;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class Cuadrado extends Figura2D{
    private double lado;

   
    
    public Cuadrado(){
        
    }
    public Cuadrado(double lado, String nombre, String color) {
        super(nombre,color);
        this.lado = lado;
        
    }
    
    
            
    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
    
   public double  calcularArea(){
       
        this.setArea(this.lado*this.lado);
        return this.getArea();
   }
   
    @Override
    public String toString() {
        return "Cuadrado{" + "lado= " + lado + ", nombre= "+this.getNombre()+ ", color= "+this.getColor()+", area= "+this.getArea()+ '}';
    }
    
}
