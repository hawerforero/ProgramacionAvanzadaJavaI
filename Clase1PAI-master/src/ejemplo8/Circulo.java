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
public class Circulo extends Figura2D{
    private double radio;

    public Circulo(){
        
    }
    public Circulo(double radio, String nombre, String color) {
        super(nombre,color);
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
    public double  calcularArea(){
       
        this.setArea(Math.PI*(Math.pow(radio, 2)));
        return this.getArea();
   }
    
     @Override
    public String toString() {
        return "Circulo{" + "radio= " + radio + ", nombre= "+this.getNombre()+", color= "+this.getColor()+ ", area= "+this.getArea()+ '}';
    }
}
