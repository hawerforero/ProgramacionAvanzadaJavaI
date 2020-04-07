/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

import cuenta.Cuenta;
import interfaces.ExportarInformacion;
import java.util.Date;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class Estudiante extends Persona implements ExportarInformacion{
    private String codigo;
    private String programa;
    private Date fechaIngreso;
    public Estudiante(String codigo, String programa, Date fechaIngreso, double identificacion, String nombres, String apellidos, Cuenta[] cuentas) {
        super(identificacion, nombres, apellidos, cuentas);
        this.codigo = codigo;
        this.programa = programa;
        this.fechaIngreso = fechaIngreso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "codigo=" + codigo + ", programa=" + programa + ", fechaIngreso=" + fechaIngreso + '}'+super.toString()+"";
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
