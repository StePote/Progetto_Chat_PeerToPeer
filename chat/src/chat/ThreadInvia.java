/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author potenza_stefano
 */
public class ThreadInvia extends Thread {

    InetAddress indirizzo;
    String contenuto = "";
    int info=0;
    public ThreadInvia(Condivisa c, String contenuto, String indirizzo,int info) throws UnknownHostException {

        this.contenuto = contenuto;
        this.indirizzo = InetAddress.getByName(indirizzo);
        this.info=info;
    }

    @Override
    public void run() {
        if(info==1){
            DatagramSocket server;
        try {
            String messaggioDaInviare="a;Potenza";
            server = new DatagramSocket(12345);
            byte[] responseBuffer = messaggioDaInviare.getBytes();

            DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);

            responsePacket.setAddress(indirizzo);

            responsePacket.setPort(666);

            try {
                server.send(responsePacket);
            } catch (IOException ex) {
                Logger.getLogger(ThreadInvia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SocketException ex) {
            Logger.getLogger(ThreadInvia.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        

    }

}
