package org.madmeg.server.packets;

import org.madmeg.networking.Packet;
import org.madmeg.server.Server;
import org.madmeg.server.models.Lobby;

/**
 * @author Madmegsox1
 * @since 27/02/2022
 */

public final class SLobby extends Packet {
    public SLobby() {
        super("SLobby");
        if(Server.lobbies.isEmpty()){
            appendData("empty");
        }else {
            for (Lobby lobby : Server.lobbies) {
                appendData(lobby.id + "," + lobby.name + "," + lobby.hostName + "," + ((lobby.player == null) ? "open" : "closed"));
            }
        }
    }
}
