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
import java.util.Random;

/**
 *
 * @author EST_2F_MCB_PC20_
 */
public class Ejemplo2 {

    public Ejemplo2() throws FileNotFoundException, IOException {
        File f = new File("datos_varios.out");
        FileOutputStream fis = new FileOutputStream(f);
        DataOutputStream dos = new DataOutputStream(fis);
        try{
            for (int i = 0; i < 32; i++) {
                 dos.writeUTF("Potencia de 2 de ");
                 dos.writeInt(i);
                 dos.writeUTF(" Igual a");
                 dos.writeDouble(Math.pow(2, i));
            }
               
        } 
         catch(FileNotFoundException e){e.printStackTrace();}
         catch(IOException e){e.printStackTrace();}
        finally{
            dos.close();
        }
    }
    
    public void leerArchivo() throws FileNotFoundException, IOException{
        File f = new File("datos_varios.out"); Random r = new Random();
        FileInputStream fis = new FileInputStream(f);
        DataInputStream dis = new DataInputStream(fis);
        Integer i;
        String cadena1, cadena2;
        Double d;
        boolean fin=true;
        
        try{
            while(fin==true) {
                cadena1 = dis.readUTF();
                i=dis.readInt();
                cadena2 = dis.readUTF();
                d = dis.readDouble();
                System.out.println(cadena1 + i + cadena2+d);
            }
                
        } 
         catch(EOFException e){fin=true;}
         catch(FileNotFoundException e){e.printStackTrace();}
         catch(IOException e){e.printStackTrace();}
         finally{
            dis.close();
        }
    }
    
}
