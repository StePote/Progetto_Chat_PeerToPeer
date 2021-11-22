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
    InetAddress indirizzo;
    int port;
    public Condivisa() {
        messaggioInviato="";
        port=0;
    }

    public void setMessaggioInviato(String messaggioInviato) {
        this.messaggioInviato = messaggioInviato;
        
    }

    public String getMessaggioInviato() {
        return messaggioInviato;
    }

    public void setIndirizzo(InetAddress indirizzo) {
        this.indirizzo = indirizzo;
    }
    
    public InetAddress getIndirizzo() {
        return indirizzo;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }
}
