/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class EmpleadoDTO {
    
    private double identificacion;
    private String nombre;
    private String apellidos;

    public EmpleadoDTO(double identificacion, String nombre, String apellidos) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellidos= apellidos;
    }

   

    public double getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(double identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "EmpleadoDTO{" + "identificacion=" + identificacion + ", nombre=" + nombre + ", apellidos=" + apellidos + '}';
    }
    
    
    
}
