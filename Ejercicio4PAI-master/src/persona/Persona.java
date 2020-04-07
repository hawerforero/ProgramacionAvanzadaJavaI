/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

import cuenta.Cuenta;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class Persona implements Comparable {
    private double identificacion;
    private String nombres;
    private String apellidos;
    private Cuenta[] cuenta;
    
    public Persona(){
        
    }

    public Persona(double identificacion, String nombres, String apellidos) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public Persona(double identificacion, String nombres, String apellidos, Cuenta[] cuenta) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cuenta = cuenta;
    }
    public double getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(double identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Cuenta[] getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta[] cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public int compareTo(Object o) {
       
        Persona p = (Persona)o;
        if ( this.identificacion > p.identificacion  ) 
            return 1;
        if(this.identificacion == p.identificacion)
            return 0;
        else
            return -1;
    }
}
