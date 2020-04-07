/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author hawer
 */
public class HistorialLaboralDTO implements Serializable{
    private double identificacion;
    private int cargo;
    private Date inicio;
    private Date finalizo;

    public HistorialLaboralDTO(double identificacion, int cargo, Date inicio, Date finalizo) {
        this.identificacion = identificacion;
        this.cargo = cargo;
        this.inicio = inicio;
        this.finalizo = finalizo;
    }

    public HistorialLaboralDTO() {
        
    }

    public double getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(double identificacion) {
        this.identificacion = identificacion;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFinalizo() {
        return finalizo;
    }

    public void setFinalizo(Date finalizo) {
        this.finalizo = finalizo;
    }

    @Override
    public String toString() {
        return "HistorialLaboralDTO{" + "identificacion=" + identificacion + ", cargo=" + cargo + ", inicio=" + inicio + ", finalizo=" + finalizo + '}';
    }
    
    
}
