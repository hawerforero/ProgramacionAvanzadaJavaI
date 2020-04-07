/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import persona.Empleado;
import persona.Estudiante;
import persona.Persona;

/**
 *
 * @author hawer
 */
public class Cliente extends Thread{
    
    protected Socket s;
    protected ObjectOutputStream oos;
    protected ObjectInputStream ois;
    private int id;

    public Cliente(int id) {
        this.id = id;
    }
    @Override
    public void run() {    
        try{
             int n_aleatorios = this.numeroAleatorio(1, 10000000);
            
               s = new Socket("127.0.0.1",1000);
               oos = new ObjectOutputStream(s.getOutputStream());
               ois = new ObjectInputStream(s.getInputStream());
                for (int i = 0; i < n_aleatorios; i++) {
                    int tipo_obj = this.numeroAleatorio(0,2);
                    Persona obj;
                    if(tipo_obj == 0){
                         obj = new Empleado("Cargo"+i, new Date(), 22222,1072394576, "Nombre"+i, "Apellido"+i);
                    }else if(tipo_obj == 1){
                         obj = new Estudiante(""+i+40, "Carrera"+i,new Date(), 1072394576, "Nombre"+i, "Apellido"+i);
                    }else{
                         obj = new Persona (i+10,"Nombre"+i,"Apellido"+i);
                    }
                    //System.out.println("El cliente: "+id + " envía el objeto ("+ obj+")");
                    oos.writeObject(obj);  
                    String respuesta = (String)ois.readObject();
                    System.out.println("El servidor responde: "+respuesta);
                    Thread.sleep(1000);
                }
               ois.close();
               oos.close();
               s.close();   
             System.out.println("Termino el Cliente "+id);
           }
           catch(Exception e){e.printStackTrace();}       
    }
    
    public int numeroAleatorio(int min, int max){
            int a = (int) (Math.random()*(max-min+1)+min);
            return a;
	}
    
    public static void main(String[] d) throws IOException{
         
         ArrayList<Cliente> clientes = new ArrayList<Cliente>();
         for (int i = 0; i < 10; i++) {
            Cliente cliente = new Cliente(i);
             cliente.start(); 
        }   
     }
}

