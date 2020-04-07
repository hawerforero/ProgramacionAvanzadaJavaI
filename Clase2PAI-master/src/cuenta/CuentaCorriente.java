/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuenta;

import interfaces.ExportarInformacion;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class CuentaCorriente extends Cuenta implements ExportarInformacion

{
    
    private double cuotaManteniemiento;
    private String chequera;
    private int numeracionInicial;
    private int numeracionFinal;

    public CuentaCorriente(double cuotaManteniemiento, String chequera, int numeracionInicial, int numeracionFinal, String cliente, String numeroCuenta, double saldo, double interes) {
        super(cliente, numeroCuenta, saldo, interes);
        this.cuotaManteniemiento = cuotaManteniemiento;
        this.chequera = chequera;
        this.numeracionInicial = numeracionInicial;
        this.numeracionFinal = numeracionFinal;
    }

    
    public double getCuotaManteniemiento() {
        return cuotaManteniemiento;
    }

    public void setCuotaManteniemiento(double cuotaManteniemiento) {
        this.cuotaManteniemiento = cuotaManteniemiento;
    }

    public String getChequera() {
        return chequera;
    }

    public void setChequera(String chequera) {
        this.chequera = chequera;
    }

    public int getNumeracionInicial() {
        return numeracionInicial;
    }

    public void setNumeracionInicial(int numeracionInicial) {
        this.numeracionInicial = numeracionInicial;
    }

    public int getNumeracionFinal() {
        return numeracionFinal;
    }

    public void setNumeracionFinal(int numeracionFinal) {
        this.numeracionFinal = numeracionFinal;
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
