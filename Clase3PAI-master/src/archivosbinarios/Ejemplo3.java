/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivosbinarios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Random;
import persona.Empleado;

/**
 *
 * @author EST_2F_MCB_PC20_
 */
public class Ejemplo3 {

    public Ejemplo3() throws FileNotFoundException, IOException {
        File f = new File("objetos.out");
        FileOutputStream fis = new FileOutputStream(f);
        ObjectOutputStream fob = new ObjectOutputStream(fis);
        try{
            for (int i = 0; i < 10; i++) {
                 Date ahora = new Date();
                 Empleado ob = new Empleado("Administrador", ahora ,2000, 86098722, "JUAN ANDRES", "MORALES DIAZ");
                 System.out.println(ob.toString());
                 fob.writeObject(ob);
            }
               
        } 
         catch(FileNotFoundException e){e.printStackTrace();}
         catch(IOException e){e.printStackTrace();}
         finally{
            fob.close();
         }
    }
    public void leerArchivo() throws FileNotFoundException, IOException, ClassNotFoundException{
        File f = new File("objetos.out"); Random r = new Random();
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream fob = new ObjectInputStream(fis);
       
  
        try{
            Object aux;
            while((aux = fob.readObject())!=null) {
                if(aux instanceof Empleado)
                {
                    
                    Empleado tempo = (Empleado)aux;System.out.println(tempo);
                    System.out.println("Empleado: "+tempo.getIdentificacion());
                }
            }
                
        } 
         catch(EOFException e){;}
         catch(FileNotFoundException e){e.printStackTrace();}
         catch(IOException e){e.printStackTrace();}
         finally{
            fob.close();
        }
    }
    
}
