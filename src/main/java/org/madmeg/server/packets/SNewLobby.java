package org.madmeg.server.packets;

import org.madmeg.networking.Packet;
import org.madmeg.server.Client;
import org.madmeg.server.Server;
import org.madmeg.server.models.Lobby;

/**
 * @author Madmegsox1
 * @since 27/02/2022
 */

public final class SNewLobby extends Packet {
    public SNewLobby(Client c, String name){
        super("SNewLobby");

        if(Server.lobbies.size() > 6){
            appendData("full");
            return;
        }

        for(final Lobby l : Server.lobbies){
            if(l.host == null)continue;
            if(l.host.uuid.equals(c.uuid)){
                appendData("failed");
                return;
            }
        }

        Lobby lobby = new Lobby(Server.lobbies.size() + 1, name, c.username);
        lobby.host = c;
        lobby.full = false;
        Server.lobbies.add(lobby);
        appendData("success");
    }
}
