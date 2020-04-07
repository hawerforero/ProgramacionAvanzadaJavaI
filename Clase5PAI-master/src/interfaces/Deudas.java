/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.Date;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public interface Deudas {
    
    public void registrar(String descripcion, double valor, Date fecha, double identificacion);
    public void quitar (int id_deuda);
    
}
