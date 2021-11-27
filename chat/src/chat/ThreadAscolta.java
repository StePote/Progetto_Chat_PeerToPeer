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
import javax.swing.JOptionPane;

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

    public void setCh(chatFrame ch) {
        this.ch = ch;
    }

    public ThreadAscolta(DatagramSocket server, int i, Condivisa c) throws SocketException {
        this.server = server;
        this.i = i;
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            try {
                server.receive(packet);
                if (i == 0) {
                    byte[] dataReceived = packet.getData();
                    String messaggioRicevuto = new String(dataReceived, 0, packet.getLength());
                    String[] split = messaggioRicevuto.split(";");
                    String nomeUtente = split[1];
                    String messaggioDiRisposta = ch.MessageBox(nomeUtente);

                    byte[] responseBuffer = messaggioDiRisposta.getBytes();

                    DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);

                    responsePacket.setAddress(packet.getAddress());

                    responsePacket.setPort(12345);

                    server.send(responsePacket);
                    i++;
                } else {
                    byte[] dataReceived = packet.getData();
                    String messaggioRicevuto = new String(dataReceived, 0, packet.getLength());
                    if ("y;".equals(messaggioRicevuto)) {
                        System.out.println(messaggioRicevuto);
                    } else {
                        String[] split = messaggioRicevuto.split(";");
                        System.out.println("Ti scrive: " + split[1]);
                    }
//                    c.setMessaggioInviato(messaggioRicevuto);
//                    c.setIndirizzoMittente(packet.getAddress());
//                    c.setPort(packet.getPort());
                }
            } catch (IOException ex) {
                Logger.getLogger(ThreadAscolta.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
