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
public class Estudiante extends Persona{
    private double codigo;
    private String programa;

    public Estudiante(double codigo, String programa) {
        this.codigo = codigo;
        this.programa = programa;
    }
    public Estudiante(double identificacion, String nombres, String apellidos) {
        super(identificacion,nombres,apellidos);
    }
     public Estudiante(double codigo, String programa, double identificacion, String nombres, String apellidos) {
        super(identificacion,nombres,apellidos);
        this.codigo = codigo;
        this.programa = programa;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "codigo=" + codigo + ", programa=" + programa + ",identificacion ="+this.getIdentificacion()+ '}';
    }

    public double getCodigo() {
        return codigo;
    }

    public void setCodigo(double codigo) {
        this.codigo = codigo;
    }

    public String getPrograma() {
        return programa;
    }
    
    public void setPrograma(String programa) {
        this.programa = programa;
    }
}
