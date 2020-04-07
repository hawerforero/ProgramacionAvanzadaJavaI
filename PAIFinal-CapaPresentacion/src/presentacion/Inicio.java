/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
      public static void main(String[] d) throws IOException{
         ObjectOutputStream oos = null;
         ObjectInputStream ois = null;
         Socket s = null;
         try{
               s = new Socket("192.168.0.5",1000);
               oos = new ObjectOutputStream(s.getOutputStream());
               ois = new ObjectInputStream(s.getInputStream());
                
               /*oos.writeObject("obtenerCargos()");
               System.out.println("LISTADO DE CARGOS");
               System.out.println(ois.readObject());
               
               System.out.println("INSERTANDO CARGO");
               oos.writeObject("insertarCargo()");
               oos.writeObject(11);
               oos.writeObject("Ingeniero F");
               oos.writeObject("C");
               oos.writeObject("12345679");
               System.out.println(ois.readObject());
               
               oos.writeObject("obtenerCargo()");
               System.out.println("OBTENER CARGO CON ID: 2");
               oos.writeObject(2);
               System.out.println(ois.readObject());
               
               oos.writeObject("modificarCargo()");
               System.out.println("MODIFICAR CARGO CON ID: 11");
               oos.writeObject(11);
               oos.writeObject("Web Host Manager");
               System.out.println(ois.readObject());
               
               oos.writeObject("eliminarCargo()");
               System.out.println("ELIMINAR CARGO CON ID: 10");
               oos.writeObject(11);
               System.out.println(ois.readObject());
               
               oos.writeObject("obtenerEmpleados()");
               System.out.println("LISTADO DE EMPLEADOS");
               System.out.println(ois.readObject());
               
               oos.writeObject("insertarEmpleado()");
               System.out.println("INSERTANDO EMPLEADO");
               oos.writeObject("1119887606");
               oos.writeObject("Rafael");
               oos.writeObject("Cuartas");
               System.out.println(ois.readObject());
               
               oos.writeObject("obtenerEmpleado()");
               System.out.println("OBTENER EMPLEADO: 1119887606");
               oos.writeObject("1119887606");
               System.out.println(ois.readObject());
               
               oos.writeObject("modificarEmpleado()");
               System.out.println("MODIFICAR EMPLEADO: 1119887606");
               oos.writeObject("1119887606");
               oos.writeObject("PONY");
               oos.writeObject("COTRINO");
               System.out.println(ois.readObject());
               
               oos.writeObject("eliminarEmpleado()");
               System.out.println("ELIMINAR EMPLEADO CON ID 1119887605");
               oos.writeObject("1119887605");
               System.out.println(ois.readObject());
               
               System.out.println("LISTADO HISTORIAL LABORAL");
               oos.writeObject("obtenerHistorialLaboral()");
               System.out.println(ois.readObject());
               
               oos.writeObject("insertarHistorialLaboral()");
               System.out.println("INSERTAR HISTORIA LABORAL");
               oos.writeObject("1119887606");
               oos.writeObject(4);               
               System.out.println(ois.readObject());
               
               oos.writeObject("modificarHistorialLaboral()");
               System.out.println("MODIFICANDO HISTORIAL LABORAL");
               oos.writeObject(6);
               oos.writeObject("1119887606");
               oos.writeObject(5);
               System.out.println(ois.readObject());*/               
               
               oos.writeObject("eliminarHistorialLaboral()");
               System.out.println("ELIMINANDO HISTORIAL LABORAL");
               oos.writeObject(9);
               System.out.println(ois.readObject());
               
               System.out.println("LISTA DE LOS PRIMEROS (2) EMPLEADOS");
               oos.writeObject("obtenerPrimerosNEmpleados()");
               oos.writeObject(2);
               System.out.println(ois.readObject());
               
               System.out.println("LISTA DE EMPLEADOS CON CARGO (4)");
               oos.writeObject("obtenerEmpleadosCargo()");
               oos.writeObject(4);
               System.out.println(ois.readObject());
         }  
          catch(Exception e){e.printStackTrace();}
            finally{
                if(oos!=null)
                    oos.close();
                if(ois!=null)
                    ois.close();
                if(s!=null)
                    s.close();
            }
     }
    
}
