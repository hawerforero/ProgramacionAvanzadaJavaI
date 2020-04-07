/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuenta;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class CuentaAhorros extends Cuenta{
    private double CuotaMantenimiento;

    public double getCuotaMantenimiento() {
        return CuotaMantenimiento;
    }

    public CuentaAhorros(double CuotaMantenimiento, String cliente, String numeroCuenta, double saldo, double interes) {
        super(cliente, numeroCuenta, saldo, interes);
        this.CuotaMantenimiento = CuotaMantenimiento;
    }

    public void setCuotaMantenimiento(double CuotaMantenimiento) {
        this.CuotaMantenimiento = CuotaMantenimiento;
    }
    
}
