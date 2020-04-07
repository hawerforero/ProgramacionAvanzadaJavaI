/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

import cuenta.Cuenta;
import java.util.Date;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class Empleado extends Persona{
    
    private String cargo;
    private Date fechaIngreso;
    private double salario;

    public Empleado(String cargo, Date fechaIngreso, double salario, double identificacion, String nombres, String apellidos, Cuenta[] cuentas) {
        super(identificacion, nombres, apellidos, cuentas);
        this.cargo = cargo;
        this.fechaIngreso = fechaIngreso;
        this.salario = salario;
        
    }

    

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
     @Override
    public String toString() {
        return "Empleado{" + "cargo=" + cargo + ", fechaIngreso=" + fechaIngreso + ", salario=" + salario + '}'+super.toString()+"";
    }
    
}
