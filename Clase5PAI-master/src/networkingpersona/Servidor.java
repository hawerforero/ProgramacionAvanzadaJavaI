/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkingpersona;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import persona.Persona;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class Servidor {
    public static void main(String[] d) throws IOException{
        ObjectInputStream ois = null; 
        ObjectOutputStream oos = null;
        Socket s = null;
        ServerSocket ss = new ServerSocket(5432);
        System.out.println("Servidor ha iniciado - Puerto "+ss.getLocalPort());
        while(true){
            try{
                s = ss.accept();
                ois = new ObjectInputStream(s.getInputStream());
                oos = new ObjectOutputStream(s.getOutputStream());
                Persona persona = (Persona)ois.readObject();
                String saludo = "hola "+persona+" "+System.currentTimeMillis();
                Date f = new Date();
                System.out.println("Se conectaron desde la IP: "+s.getInetAddress()+" El cliente: "+persona+" Fecha: "+f.toLocaleString()+""+f.getTime());
                oos.writeObject(saludo);
                System.out.println("Bienvenido "+persona);
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
}
