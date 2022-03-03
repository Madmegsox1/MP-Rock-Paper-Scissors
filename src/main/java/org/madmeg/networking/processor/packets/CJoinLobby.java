package org.madmeg.networking.processor.packets;

import org.madmeg.networking.Packet;

public final class CJoinLobby extends Packet {
    public CJoinLobby(int id) {
        super("CJoinLobby");
        appendData(id + "");
    }

}
