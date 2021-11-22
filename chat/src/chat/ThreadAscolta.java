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
 * @author potenza_stefano
 */
public class ThreadAscolta extends Thread {

    Condivisa c;
    chatFrame ch;
    DatagramSocket server;
    byte[] buffer = new byte[1500];
    int i;
    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

    public ThreadAscolta(DatagramSocket server,int i,Condivisa c) throws SocketException {
        this.server = server;
        this.i=i;
        this.c=c;
    }

    @Override
    public void run() {
        try {
            server.receive(packet);
            if (i == 0) {
                String risposta = ch.messageBox();
                String messaggioDiRisposta = "";
                if ("si".equals(risposta)) {
                    messaggioDiRisposta = "y;PotenzaStefano";
                } else if ("no".equals(risposta)) {
                    messaggioDiRisposta = "n;";
                }

                byte[] responseBuffer = messaggioDiRisposta.getBytes();

                DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);

                responsePacket.setAddress(packet.getAddress());

                responsePacket.setPort(packet.getPort());

                server.send(responsePacket);
                i++;
            } else {
                byte[] dataReceived = packet.getData();
                String messaggioRicevuto = new String(dataReceived, 0, packet.getLength());
                String[] split=messaggioRicevuto.split(";");
                String nomeUtente=split[1];
                System.out.println(nomeUtente);
                c.setMessaggioInviato(messaggioRicevuto);
                c.setIndirizzoMittente(packet.getAddress());
                c.setPort(packet.getPort());
            }
        } catch (IOException ex) {
            Logger.getLogger(ThreadAscolta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
