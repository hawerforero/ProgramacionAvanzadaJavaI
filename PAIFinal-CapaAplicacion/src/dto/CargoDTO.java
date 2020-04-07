/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class CargoDTO implements Serializable{
    private int id;
    private String cargo;
    private String sede;
    private double salario;

    public CargoDTO(int id, String cargo, String sede, double salario) {
        this.id = id;
        this.cargo = cargo;
        this.sede = sede;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "CargosDTO{" + "id=" + id + ", cargo=" + cargo + ", sede=" + sede + ", salario=" + salario + '}';
    }
    
    
    
}
