/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo2;

import java.sql.SQLException;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // TODO code application logic here
        ConsultarInformacion c = new ConsultarInformacion();
        c.consulta1();
        InsertarInformacion i = new InsertarInformacion();
        i.insertar();
    }
    
}
