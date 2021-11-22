/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stefano Potenza
 */
public class Chat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException {
        DatagramSocket server = new DatagramSocket(12345);
        Condivisa c = new Condivisa();
        chatFrame ch= new chatFrame(c);
        int i = 0;
        ThreadAscolta tA = new ThreadAscolta(server, i, c);
        
        tA.start();
        
        try {
            tA.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
