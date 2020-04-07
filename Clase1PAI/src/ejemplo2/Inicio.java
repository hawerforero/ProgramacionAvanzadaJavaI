/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo2;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class Inicio {
    
     public static void main(String[] args) {
         
         Persona x = new Persona();
         Persona y;
         y = new Persona();
         Persona varios[] = new Persona[10];
         
         x.setNombres("JUAN");
         x.setApellidos("LOPEZ");
         x.setEdad(25);
         x.setTelefono("3102801139");
         x.setDireccion("Calle 51 61a-20");
         
         y.setNombres("MARIO");
         y.setApellidos("DIAZ");
         y.setEdad(31);
         y.setTelefono("3102801139");
         y.setDireccion("Calle 11 sur 11-30");
         
         System.out.println("Empleado: "+x.getNombres()+" "+x.getApellidos()+" edad: "+x.getEdad());
         System.out.println("Empleado: "+y.getNombres()+" "+y.getApellidos()+" edad: "+y.getEdad());
         
         for (int i = 0; i < varios.length; i++) {
             varios[i] = new Persona();
         }
         System.out.println("Varios");
         for (int i = 0; i < varios.length; i++) {
             System.out.println("Empleado: "+varios[i].getNombres()+" "+varios[i].getApellidos()+" edad: "+varios[i].getEdad());
         }
         
        Persona x1 = new Persona();
        Persona y1;
        y1 = new Persona(123, "MARIANA", "ROMERO");
        System.out.println("Empleado: "+x1.getNombres()+" "+x1.getApellidos()+" edad: "+x1.getEdad());
        System.out.println("Empleado: "+y1.getNombres()+" "+y1.getApellidos()+" edad: "+y1.getEdad());
     }
    
}
