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
public class Figura2D {
    
    private String nombre;
    private String color;
    private double area;
    public Figura2D(){
        
    }
    public Figura2D(String nombre, String color){
        this.nombre = nombre;
        this.color = color;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
    public double calcularArea(Figura2D[] figuras){
        double suma = 0;
        for (int i = 0; i < figuras.length; i++) {
            suma = suma + figuras[i].getArea();
        }
        return suma;
    }
}
