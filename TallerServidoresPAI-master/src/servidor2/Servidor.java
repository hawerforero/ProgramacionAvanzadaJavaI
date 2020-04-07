/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor2;

import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 *
 * @author hawer
 */
public class Servidor extends Thread {
   
    private Socket s;
    private int id;
    
    public Servidor(Socket s, int id) {
        this.s = s;
        this.id = id;
    }
    
    @Override
    public void run() {
                
        try {
            DataInputStream dis = new DataInputStream( s.getInputStream() );
            BufferedInputStream in = new BufferedInputStream(s.getInputStream());

            String nombreArchivo = dis.readUTF().toString();
            int tam = dis.readInt();
            System.out.println( "Recibiendo de cliente"+id+": "+nombreArchivo+".............");

            FileOutputStream fos = new FileOutputStream(nombreArchivo);
            BufferedOutputStream out = new BufferedOutputStream(fos);

            byte[] buffer = new byte[tam];
            for(int i = 0; i < buffer.length; i++)
               buffer[i] = (byte)in.read(); 
            out.write(buffer);
            out.flush();       
            out.close();
            System.out.println("Archivo recibido de Cliente "+id+": "+nombreArchivo);
            in.close();
            try {
                File objetofile = new File (nombreArchivo);
                Desktop.getDesktop().open(objetofile);
                
            }catch (IOException ex) {
                System.out.println(ex);
            }       
            s.close();
        }catch(Exception e){}
    }
  
    public static void main(String d[]) throws IOException{
        
        Socket s = null;
        ServerSocket ss = new ServerSocket(5433);
        System.out.println("Servidor ha iniciado - Puerto " + ss.getLocalPort());
        int id=0;
        while(true){    
                s = ss.accept();
                Date f = new Date();
                System.out.println("Se conecto cliente "+id+" desde la IP: " +  s.getInetAddress() + " Fecha: " 
                        + f.toLocaleString() + " " + f.getTime());
                Servidor servidor = new Servidor(s, id);
                servidor.start();
                id++;
        }        
    }

}
