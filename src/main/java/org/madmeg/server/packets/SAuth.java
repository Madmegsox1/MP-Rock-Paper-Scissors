package org.madmeg.server.packets;

import org.madmeg.networking.Packet;

public final class SAuth extends Packet {
    public SAuth(String[] sData) { // TODO database and rest of auth stuff
        super("SAuth");
        String username = sData[4];
        String password = sData[5];

    }
}
