/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor2;

import cuenta.CuentaAhorros;
import cuenta.CuentaCorriente;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import persona.Empleado;
import persona.Estudiante;
import persona.Persona;

/**
 *
 * @author hawer
 */
public class Cliente extends Thread {
    private int id;
    private String nombreArchivo;

    public Cliente(int id, String nombre) {
        this.id = id;
        this.nombreArchivo = nombre;
    }
   
    public void CrearArchivo(String nombre) throws FileNotFoundException, IOException{
        File f = new File(nombre);
        FileOutputStream fis = new FileOutputStream(f);
        ObjectOutputStream fob = new ObjectOutputStream(fis);
        try{
            for (int i = 0; i < 10; i++) {
                 Date ahora = new Date();
                 Persona persona = new Persona(12345,"Hawer","Forero");
                 fob.writeObject(persona);
            }    
        } 
         catch(FileNotFoundException e){e.printStackTrace();}
         catch(IOException e){e.printStackTrace();}
         finally{
            fob.close();
         }
    }
    
    @Override
    public void run() {
        FileInputStream fis = null;
        Socket s = null;
        try{   
            s = new Socket("127.0.0.1",5433);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream() ); 
            BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());
   
            //this.CrearArchivo(nombreArchivo);

            fis = new FileInputStream(nombreArchivo);
            BufferedInputStream bis = new BufferedInputStream( fis );   
            File archivo = new File(nombreArchivo);
            int tamañoArchivo = ( int )archivo.length();
            System.out.println( "Cliente "+id+": Enviando "+archivo.getName()+" ........................" );  
            dos.writeUTF(archivo.getName());            
            dos.writeInt(tamañoArchivo);
            byte[] buffer = new byte[tamañoArchivo];       
            bis.read(buffer);                    
            for( int i = 0; i < buffer.length; i++ ){
                bos.write(buffer[i]); 
            }         
            System.out.println("Termino envio cliente "+id);
             bis.close(); 
                   
            bos.close(); 
            s.close();
        }
        catch(Exception e){e.printStackTrace();}     
    }  
    
    
    public static void main(String []d) throws IOException, Exception{
        
        for (int i = 0; i < 40; i++) {
            int max = 3;
            int min = 0;
            int tipo = (int) (Math.random()*(max-min+1)+min);
            String archivoEnviado = "";
            if(tipo == 0){
                 Empleado archivo = new Empleado("Ingeniero de Sistemas", new Date(), 22222,1072394576, "Hawer", "Forero");
                  tipo = (int) (Math.random()*(max-min+1)+min);
                  if(tipo == 0){archivo.toExcel(); archivoEnviado="Empleado.xls";}
                  if(tipo == 1){archivo.toHTML(); archivoEnviado="Empleado.html";}
                  if(tipo == 2){archivo.toPDF(); archivoEnviado="Empleado.pdf";}
                  if(tipo == 3){archivo.toXML(); archivoEnviado="Empleado.xml";}

            }
            if(tipo == 1){
                  Estudiante archivo = new Estudiante("160002443", "Sistemas",new Date(), 1072394576, "Hawer", "Forero");
                  tipo = (int) (Math.random()*(max-min+1)+min);
                  if(tipo == 0){archivo.toExcel(); archivoEnviado="Estudiante.xls";}
                  if(tipo == 1){archivo.toHTML(); archivoEnviado="Estudiante.html";}
                  if(tipo == 2){archivo.toPDF(); archivoEnviado="Estudiante.pdf";}
                  if(tipo == 3){archivo.toXML(); archivoEnviado="Estudiante.xml";}
            }
            if(tipo == 2){
                 CuentaAhorros archivo = new CuentaAhorros(5000, "Hawer", "00000003322", 1500000, 12);
                 tipo = (int) (Math.random()*(max-min+1)+min);
                  if(tipo == 0){archivo.toExcel(); archivoEnviado="CuentaAhorros.xls";}
                  if(tipo == 1){archivo.toHTML(); archivoEnviado="CuentaAhorros.html";}
                  if(tipo == 2){archivo.toPDF(); archivoEnviado="CuentaAhorros.pdf";}
                  if(tipo == 3){archivo.toXML(); archivoEnviado="CuentaAhorros.xml";}
            }
            if(tipo == 3){
                 CuentaCorriente archivo = new CuentaCorriente(12000, "2",1,9,"Hawer","00000003322", 1500000, 12);
                 tipo = (int) (Math.random()*(max-min+1)+min);
                  if(tipo == 0){archivo.toExcel(); archivoEnviado="CuentaCorriente.xls";}
                  if(tipo == 1){archivo.toHTML(); archivoEnviado="CuentaCorriente.html";}
                  if(tipo == 2){archivo.toPDF(); archivoEnviado="CuentaCorriente.pdf";}
                  if(tipo == 3){archivo.toXML(); archivoEnviado="CuentaCorriente.xml";}
            }
            Cliente cliente = new Cliente(i,archivoEnviado);
            cliente.start();
        }        
    }
}
