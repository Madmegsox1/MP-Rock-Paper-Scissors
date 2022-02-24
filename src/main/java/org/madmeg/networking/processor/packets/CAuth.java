package org.madmeg.networking.processor.packets;

import org.madmeg.networking.Packet;

/**
 * @author Madmegsox1
 * @since 23/02/2022
 */

public final class CAuth extends Packet {
    public CAuth(String username, String password) {
        super("CAuth");
        appendData(username);
        appendData(password);
    }
}
