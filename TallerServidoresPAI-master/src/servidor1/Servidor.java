/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import persona.Persona;

/**
 *
 * @author hawer
 */
public class Servidor extends Thread{
    private Socket s;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private int idSession;
    
    public Servidor(Socket s, int id) {
        this.s = s;
        this.idSession = id;
        try {
            oos = new ObjectOutputStream(s.getOutputStream());
            ois = new ObjectInputStream(s.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void run() {
       
       do{
           Persona persona = new Persona();
            try{
                 persona = (Persona)ois.readObject();
                 String saludo = "Recibido del cliente "+this.idSession+" el objeto("+persona+")";
                 Date f = new Date();
                 System.out.println("Recibido de Cliente: "+this.idSession+" Fecha: "+f.toLocaleString()+""+f.getTime()+" El objeto: "+persona);
                 oos.writeObject(saludo);
            }
            catch(Exception e){break;}
        }while(true);
        try {s.close();} catch (Exception e) {e.printStackTrace();}
    }
    
    public static void main(String[] d) throws IOException{
        
        ServerSocket ss = new ServerSocket(1000);
        System.out.println("Servidor ha iniciado - Puerto "+ss.getLocalPort());
         int idSession = 0;
        while(true){
            try{
                Socket s;
                s = ss.accept();
                System.out.println("Nueva conexión entrante del cliente "+idSession+" -> "+s);
                ((Servidor) new Servidor(s, idSession)).start();
                idSession++;
            }
            catch(Exception e){e.printStackTrace();}
        }
       
    }
}
