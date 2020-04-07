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
import java.io.OutputStream;
import java.util.Random;

/**
 *
 * @author EST_2F_MCB_PC20_
 */
public class Ejemplo1 {

    public Ejemplo1() throws FileNotFoundException, IOException {
        File f = new File("datos.out");
        FileOutputStream fis = new FileOutputStream(f);
        DataOutputStream dos = new DataOutputStream(fis);
        try{
            for (int i = 0; i < 32; i++) 
                dos.writeDouble(Math.pow(2, i));
        } 
         catch(FileNotFoundException e){e.printStackTrace();}
         catch(IOException e){e.printStackTrace();}
        finally{
            dos.close();
        }
    }
    public void leerArchivo() throws FileNotFoundException, IOException{
        File f = new File("datos.out"); Random r = new Random();
        FileInputStream fis = new FileInputStream(f);
        DataInputStream dis = new DataInputStream(fis);
        Double d;
        boolean fin = true;
        try{
            while(fin==true) {
                d = dis.readDouble();
                System.out.println(d);
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
