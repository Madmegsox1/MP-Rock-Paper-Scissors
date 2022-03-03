package org.madmeg.server.packets;

import org.madmeg.networking.Packet;
import org.madmeg.server.Client;
import org.madmeg.server.models.Lobby;

public final class SJoinLobby extends Packet {
    public SJoinLobby(Lobby lobby, Client client) {
        super("SJoinLobby");
        if(lobby.player != null || lobby.full || client.lobby != null){
            appendData("failed");
            return;
        }
        lobby.player = client;
        client.lobby = lobby;
        lobby.full = true;
        appendData("success");
        appendData(lobby.id + "");
    }
}
