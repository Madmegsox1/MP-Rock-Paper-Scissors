package org.madmeg.server.models;

import org.madmeg.server.Client;
import org.madmeg.ui.elements.Button;

/**
 * @author Madmegsox1
 * @since 27/02/2022
 */

public final class Lobby {
    public int id;
    public String name;
    public String hostName;
    public Client host;
    public Client player;
    public boolean full;

    public Button button = null;

    public Lobby(){}

    public Lobby(int id, String name, String hostName){
        this.id = id;
        this.name = name;
        this.hostName = hostName;
        button = null;
    }

    public Client getHost() {
        return host;
    }

    public void setHost(Client host) {
        this.host = host;
    }

    public Client getPlayer() {
        return player;
    }

    public void setPlayer(Client player) {
        this.player = player;
    }
}
