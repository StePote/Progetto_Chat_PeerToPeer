/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author potenza_stefano
 */
public class ThreadInvia extends Thread {

    
    InetAddress indirizzo;
    String contenuto = "";

    public ThreadInvia(Condivisa c) {
        
        this.contenuto = c.getMessaggioDaInviare();
        this.indirizzo = c.getIndirizzo();
    }

    @Override
    public void run() {
        byte[] responseBuffer = contenuto.getBytes();

//        DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);
//
//        responsePacket.setAddress(packet.getAddress());
//
//        responsePacket.setPort(packet.getPort());
//
//        server.send(responsePacket);
    }

}
