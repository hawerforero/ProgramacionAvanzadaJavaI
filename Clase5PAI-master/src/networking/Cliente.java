/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class Cliente {
     public static void main(String[] d) throws IOException{
         ObjectOutputStream oos = null;
         ObjectInputStream ois = null;
         Socket s = null;
         try{
               
               
              for (int i = 0; i < 10; i++) {
                s = new Socket("127.0.0.1",5432);
                oos = new ObjectOutputStream(s.getOutputStream());
                ois = new ObjectInputStream(s.getInputStream());
                oos.writeObject("C1");
                oos.writeObject("C2");
               String respuesta = (String)ois.readObject();
               System.out.println("Respuesta del servidor "+respuesta);
               Thread.sleep(1000);
             }
              
              
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
