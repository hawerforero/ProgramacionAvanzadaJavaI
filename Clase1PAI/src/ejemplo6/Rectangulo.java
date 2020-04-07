/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo6;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class Rectangulo extends Figura2D{
    
        private double lado1;
        private double lado2;
        
    public Rectangulo(){
        
    }    

    public Rectangulo(double lado1, double lado2, String nombre, String color) {
        super(nombre,color);
        this.lado1 = lado1;
        this.lado2 = lado2;
    }
        

    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }
    
    public double  calcularArea(){
       
        this.setArea(this.lado1*this.lado2);
        return this.getArea();
   }
    
    @Override
    public String toString() {
        return "Rectangulo{" + "lado1= " + lado1 + ", lado2= " + lado2 + ", nombre= "+this.getNombre()+", color= "+this.getColor()+ ", area= "+this.getArea() +'}';
    }
}
