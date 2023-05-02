/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chandy
 */
public class servidor1 extends Observable implements Runnable {

    private int puerto;
    public servidor1(int puerto){
        this.puerto=puerto;
    }
    @Override
    public void run() {
         ServerSocket sv=null;
            Socket sc;
            DataInputStream in;
            DataOutputStream out;
            
            try{
            sv= new ServerSocket(puerto);
                System.out.println("servidor iniciado");
                while(true){
                    sc=sv.accept();
                    in=new DataInputStream(sc.getInputStream());
                    
                    
                    String men=in.readUTF();
                    System.out.println(men);
                    
                    this.setChanged();
                    this.notifyObservers(men);
                    this.clearChanged();
                    sc.close();
                    System.out.println("cliente desconectado");
                }
        } catch (IOException ex) {
            Logger.getLogger(servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
