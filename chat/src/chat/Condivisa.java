/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.net.InetAddress;

/**
 *
 * @author potenza_stefano
 */
public class Condivisa {
    String messaggioInviato;
    InetAddress indirizzoMittente;
    InetAddress indirizzoDestinatario;

    public InetAddress getIndirizzoDestinatario() {
        return indirizzoDestinatario;
    }

    public void setIndirizzoDestinatario(InetAddress indirizzoDestinatario) {
        this.indirizzoDestinatario = indirizzoDestinatario;
    }
    int port;
    String messaggioDaInviare;
    public Condivisa() {
        messaggioInviato="";
        port=0;
        messaggioDaInviare="";
    }

    public String getMessaggioDaInviare() {
        return messaggioDaInviare;
    }

    public void setMessaggioDaInviare(String messaggioDaInviare) {
        this.messaggioDaInviare = messaggioDaInviare;
    }

    public void setMessaggioInviato(String messaggioInviato) {
        this.messaggioInviato = messaggioInviato;
        
    }

    public String getMessaggioInviato() {
        return messaggioInviato;
    }

    public void setIndirizzoMittente(InetAddress indirizzo) {
        this.indirizzoMittente = indirizzo;
    }
    
    public InetAddress getIndirizzo() {
        return indirizzoMittente;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }
}
