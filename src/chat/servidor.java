
package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class servidor  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
            ServerSocket sv=null;
            Socket sc;
            DataInputStream in;
            DataOutputStream out;
            final int puerto=1111;
            try{
            sv= new ServerSocket(puerto);
                System.out.println("servidor iniciado");
                while(true){
                    sc=sv.accept();
                    in=new DataInputStream(sc.getInputStream());
                    out=new DataOutputStream(sc.getOutputStream());
                    String men=in.readUTF();
                    System.out.println(men);
                    out.writeUTF("hola bienvenido");
                    sc.close();
                    System.out.println("cliente desconectado");
                }
        } catch (IOException ex) {
            Logger.getLogger(servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   
    
}
