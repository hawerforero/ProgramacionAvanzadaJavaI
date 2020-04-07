/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

import cuenta.Cuenta;
import interfaces.Deudas;
import interfaces.ExportarInformacion;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class Empleado extends Persona implements Deudas, ExportarInformacion, Serializable{
    
    private String cargo;
    private Date fechaIngreso;
    private double salario;
    
    public Empleado(String cargo, Date fechaIngreso, double salario, double identificacion, String nombres, String apellidos) {
        super(identificacion, nombres, apellidos);
        this.cargo = cargo;
        this.fechaIngreso = fechaIngreso;
        this.salario = salario;
        
    }
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

    @Override
    public void registrar(String descripcion, double valor, Date fecha, double identificacion) {
        System.out.println("Empleado_registrar deuda a: ");
        System.out.println("Identificacion: "+identificacion+" Descripcion: "+valor);
    }

    @Override
    public void quitar(int id_deuda) {
      System.out.println("Empleado_Quitar deuda a: ");
    }

    @Override
    public void toPDF() {
         System.out.println("Imprimir a PDF");
    }

    @Override
    public void toExcel() {
        System.out.println("Imprimir a Excel");
    }

    @Override
    public void toXML() {
        System.out.println("Imprimir a XML");
    }

    @Override
    public void toHTML() {
        System.out.println("Imprimir a HTML");
    }
    
}
