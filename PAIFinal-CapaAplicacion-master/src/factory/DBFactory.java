/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.util.ResourceBundle;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class DBFactory {
     public static Object getInstancia(String clase) throws ClassNotFoundException{
        Object obj = null;
        try{
            ResourceBundle rb = ResourceBundle.getBundle("\\factory\\configuracion_db");
            String c = rb.getString(clase);
            obj = Class.forName(c).newInstance();
            return obj;
        }
        catch(Exception ex){
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }
}
