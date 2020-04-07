/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo5;

import ejemplo2.Estudiante;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class Inicio {
     public static void main(String[] args) {
         Estudiante e1 = new Estudiante(16002443, "sistemas");
         Estudiante e2 = new Estudiante(1072394576, "Hawer", "Apellidos");
         Estudiante e3 = new Estudiante(160002443, "Sistemas", 1072394576 , "Hawer", "Apellidos");
        
         System.out.println(e1);
         System.out.println(e2);
         System.out.println(e3);
     }
     
}
