/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkinbytes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import persona.Persona;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class ServidorBytes {
    private static final int BUFFER_LENGTH = 3;
    public static void main(String[] d) throws IOException{
       BufferedReader br = null;
       BufferedWriter bw = null;
       Socket s = null;
       ServerSocket ss = new ServerSocket(5432);
       System.out.println("Servidor ha iniciado - Puerto "+ss.getLocalPort());
        while(true){
            try{
               s = ss.accept();
               Date f = new Date();
                System.out.println("Se conectaron desde la IP: "+s.getInetAddress()+" Fecha: "+f.toLocaleString()+""+f.getTime() );
                 br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                 bw = new BufferedWriter(new PrintWriter(s.getOutputStream()));
                 char bEnviar[];
                 char bRecibidos[] = new char[ServidorBytes.BUFFER_LENGTH];
                 StringBuffer sb = new StringBuffer();
                 int n = 0;
                 while((n=br.read(bRecibidos))==ServidorBytes.BUFFER_LENGTH){
                     sb.append(bRecibidos);
                 }
                 if(n!=-1)
                     sb.append(bRecibidos,0,n);
                 String info = sb.toString();
                 String saludo = "Hola "+info+""+System.currentTimeMillis();
                 bEnviar = saludo.toCharArray();
                 bw.write(bEnviar);
                 bw.flush();
                 System.out.println("Informacion del cliente "+info);
            }
            catch(Exception e){e.printStackTrace();}
            finally{
                if(bw!=null)
                    bw.close();
                if(br!=null)
                    br.close();
                if(s!=null)
                    s.close();
            }
        }
    }
}
