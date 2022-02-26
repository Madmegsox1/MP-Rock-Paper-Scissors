package org.madmeg.networking.processor.packets;

import org.madmeg.networking.Packet;

/**
 * @author Madmegsox1
 * @since 23/02/2022
 */

public final class CAuth extends Packet {
    public String username;
    public CAuth(String username, String password) {
        super("CAuth");
        this.username = username;
        appendData(username);
        appendData(password);
    }
}
