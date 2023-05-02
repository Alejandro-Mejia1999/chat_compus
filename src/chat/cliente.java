
package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class cliente implements Runnable {
    private int puerto;
    private String mensaje;
         public cliente(int puerto, String mensaje){
            this.puerto=puerto;
            this.mensaje=mensaje;
         }

    @Override
    public void run() {
         final String Host="192.168.1.6";
           
            DataInputStream in;
            DataOutputStream out;
            try{
                Socket sc=new Socket(Host,puerto);
                in=new DataInputStream(sc.getInputStream());
                out=new DataOutputStream(sc.getOutputStream());
                out.writeUTF(mensaje);
                
                sc.close();
        } catch (IOException ex) {
            Logger.getLogger(servidor1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
