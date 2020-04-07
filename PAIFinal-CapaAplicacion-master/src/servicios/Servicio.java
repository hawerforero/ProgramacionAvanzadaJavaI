/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dto.CargoDTO;
import dto.EmpleadoDTO;
import aplicacion.Fachada;
import dto.HistorialLaboralDTO;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;
import java.util.Vector;

/**
 *
 * @author hawer
 */
public class Servicio extends Thread{
    private Socket s;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private int idSession;
    
    public Servicio(Socket s, int id) {
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
            try{
                 Fachada fachada = new Fachada();
                 String servicio = (String)ois.readObject();
                 String respuesta = "";
                 
                 if(servicio.equals("obtenerCargos()")){
                     Vector<CargoDTO> cargos = (Vector<CargoDTO>)fachada.obtenerCargos();
                     for(CargoDTO c: cargos)
                         respuesta = respuesta + "-> "+c.toString()+"\n";
                     System.out.println("Cliente "+idSession+" -> "+servicio);
                     oos.writeObject(respuesta);
                 }
                 if(servicio.equals("insertarCargo()")){
                    int id = (Integer)ois.readObject();
                    String n_cargo = (String)ois.readObject();
                    String sede = (String)ois.readObject();
                    String sal = (String)ois.readObject();
                    double salario = Double.parseDouble(sal);
                    CargoDTO cargo = new CargoDTO(id,n_cargo,sede,salario);
                    respuesta = ""+fachada.insertarCargo(cargo);
                    System.out.println("Cliente "+idSession+" -> "+servicio);
                    oos.writeObject(respuesta+"\n");
                 }
                 
                 if(servicio.equals("obtenerCargo()")){
                    int id = (Integer)ois.readObject();
                     CargoDTO cargo = fachada.obtenerCargo(id);
 
                         respuesta = "-> "+cargo.toString()+"\n";
                     System.out.println("Cliente "+idSession+" -> "+servicio);
                     oos.writeObject(respuesta);
                 }
                 
                 if(servicio.equals("modificarCargo()")){
                    int id = (Integer)ois.readObject();
                    String nombre_cargo = (String)ois.readObject();
                   
                    CargoDTO cargo = fachada.obtenerCargo(id);
                    cargo.setCargo(nombre_cargo);
                    respuesta = ""+fachada.modificarCargo(cargo);
                    System.out.println("Cliente "+idSession+" -> "+servicio);
                    oos.writeObject(respuesta+"\n");
                 }
                 
                
                 if(servicio.equals("eliminarCargo()")){
                    int id = (Integer)ois.readObject();
                    respuesta = ""+fachada.eliminarCargo(id);
                    System.out.println("Cliente "+idSession+" -> "+servicio);
                    oos.writeObject(respuesta+"\n");
                 }
                 
                 if(servicio.equals("obtenerEmpleados()")){
                     Vector<EmpleadoDTO> empleados = (Vector<EmpleadoDTO>)fachada.obtenerEmpleados();
                     for(EmpleadoDTO e: empleados)
                         respuesta = respuesta + "-> "+e.toString()+"\n";
                     System.out.println("Cliente "+idSession+" -> "+servicio);
                     oos.writeObject(respuesta);
                 }
                 
                 if(servicio.equals("insertarEmpleado()")){
                    String id = (String)ois.readObject();
                    String nombres = (String)ois.readObject();
                    String apellidos = (String)ois.readObject();
                  
                    EmpleadoDTO empleado = new EmpleadoDTO(Double.parseDouble(id),nombres,apellidos);
                    respuesta = ""+fachada.insertarEmpleado(empleado);
                    System.out.println("Cliente "+idSession+" -> "+servicio);
                    oos.writeObject(respuesta+"\n");
                 }
                 
                 if(servicio.equals("obtenerEmpleado()")){
                     String id = (String)ois.readObject();
                     EmpleadoDTO empleado = fachada.obtenerEmpleado(Double.parseDouble(id));
                         respuesta = "-> "+empleado.toString()+"\n";
                     System.out.println("Cliente "+idSession+" -> "+servicio);
                     oos.writeObject(respuesta);
                 }
                 
                 if(servicio.equals("modificarEmpleado()")){
                    String id = (String)ois.readObject();
                    String nombres = (String)ois.readObject();
                    String apellidos = (String)ois.readObject();
                   
                    EmpleadoDTO empleado = fachada.obtenerEmpleado(Double.parseDouble(id));
                    empleado.setNombre(nombres);
                    empleado.setApellidos(apellidos);
                    respuesta = ""+fachada.modificarEmpleado(empleado);
                    System.out.println("Cliente "+idSession+" -> "+servicio);
                    oos.writeObject(respuesta+"\n");
                 }
                 if(servicio.equals("eliminarEmpleado()")){
                    String id = (String)ois.readObject();
                    respuesta = ""+fachada.eliminarEmpleado(Double.parseDouble(id));
                    System.out.println("Cliente "+idSession+" -> "+servicio);
                    oos.writeObject(respuesta+"\n");
                 }
                 
                 if(servicio.equals("obtenerHistorialLaboral()")){
                     Vector<HistorialLaboralDTO> historial = (Vector<HistorialLaboralDTO>)fachada.obtenerHistorialLaboral();
                     for(HistorialLaboralDTO h: historial)
                         respuesta = respuesta + "-> "+h.toString()+"\n";
                     System.out.println("Cliente "+idSession+" -> "+servicio);
                     oos.writeObject(respuesta);
                 }
                 
                 if(servicio.equals("insertarHistorialLaboral()")){
                    String id = (String)ois.readObject();
                    int cargo = (Integer)ois.readObject();
                   
                    HistorialLaboralDTO historial = new HistorialLaboralDTO();
                    historial.setIdentificacion(Double.parseDouble(id));
                    historial.setCargo(cargo);
                    historial.setInicio(new Date(11,22,22));
                    respuesta = ""+fachada.insertarHistorial(historial);
                    System.out.println("Cliente "+idSession+" -> "+servicio);
                    oos.writeObject(respuesta+"\n");
                 }
                 
                 if(servicio.equals("modificarHistorialLaboral()")){
                    int idHistorial = (Integer)ois.readObject();
                    String identificacion = (String)ois.readObject();
                    int cargo = (Integer)ois.readObject();
                   
                    
                    respuesta = ""+fachada.modificarHistorial(idHistorial, Double.parseDouble(identificacion), cargo);
                    System.out.println("Cliente "+idSession+" -> "+servicio);
                    oos.writeObject(respuesta+"\n");
                 }
                 
                 if(servicio.equals("eliminarHistorialLaboral()")){
                    int idHistorial = (Integer)ois.readObject();
                   
                    respuesta = ""+fachada.eliminarHistorial(idHistorial);
                    System.out.println("Cliente "+idSession+" -> "+servicio);
                    oos.writeObject(respuesta+"\n");
                 }
                 
                 if(servicio.equals("obtenerPrimerosNEmpleados()")){
                    int id = (Integer)ois.readObject();
                     Vector<EmpleadoDTO> empleados = (Vector<EmpleadoDTO>)fachada.obtenerPrimerosNEmpleados(id);
                     for(EmpleadoDTO e: empleados)
                         respuesta = respuesta + "-> "+e.toString()+"\n";
                     System.out.println("Cliente "+idSession+" -> "+servicio);
                     oos.writeObject(respuesta);
                 }
                 if(servicio.equals("obtenerEmpleadosCargo()")){
                    int id = (Integer)ois.readObject();
                     Vector<EmpleadoDTO> empleados = (Vector<EmpleadoDTO>)fachada.obtenerEmpleadosCargos(id);
                     for(EmpleadoDTO e: empleados)
                         respuesta = respuesta + "-> "+e.toString()+"\n";
                     System.out.println("Cliente "+idSession+" -> "+servicio);
                     oos.writeObject(respuesta);
                 }
                 
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
                ((Servicio) new Servicio(s, idSession)).start();
                idSession++;
            }
            catch(Exception e){e.printStackTrace();}
        }
       
    }
}
