package org.madmeg.networking.processor.packets;
import org.madmeg.networking.Packet;

/**
 * @author Madmegsox1
 * @since 27/02/2022
 */

public final class CNewLobby extends Packet {
    public CNewLobby(String lobbyName) {
        super("CNewLobby");
        appendData(lobbyName);
    }
}
