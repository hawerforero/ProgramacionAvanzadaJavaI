/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo2;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class Persona {
    
    private double identificacion;
    private String nombres;
    private String apellidos;
    private double edad;
    private String direccion;
    private String telefono;
    private String email;
    
    private static int CONTADOR_OBJETOS;
    public static final int EDAD_MINIMA;
    
    static{
        CONTADOR_OBJETOS = 0;
        EDAD_MINIMA = 18;
    }

    public Persona(double identificacion, String nombres, String apellidos, double edad, String direccion, String telefono) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
        Persona.CONTADOR_OBJETOS++;
    }

    public Persona(double identificacion, String nombres, String apellidos) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = -1;
        this.direccion = "---";
        this.telefono = "---";
        Persona.CONTADOR_OBJETOS++;
    }
     public Persona() {
        this.identificacion = 0;
        this.nombres = "---";
        this.apellidos = "---";
        this.edad = -1;
        this.direccion = "---";
        this.telefono = "---";
        Persona.CONTADOR_OBJETOS ++;
    }
    
     public static int getCONTADOR_OBJETOS(){
         return CONTADOR_OBJETOS;
     }

    public void setIdentificacion(double identificacion) {
        this.identificacion = identificacion;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEdad(double edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" + "identificacion=" + identificacion + ", nombres=" + nombres + ", apellidos=" + apellidos + ", edad=" + edad + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + '}';
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getIdentificacion() {
        return identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public double getEdad() {
        return edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }
   
    
    
}
