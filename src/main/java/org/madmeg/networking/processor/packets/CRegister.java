package org.madmeg.networking.processor.packets;

import org.madmeg.networking.Packet;

/**
 * @author Madmegsox1
 * @since 24/02/2022
 */

public final class CRegister extends Packet {
    public CRegister(String username, String password) {
        super("CRegister");
        appendData(username);
        appendData(password);
    }
}
