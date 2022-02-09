package org.madmeg.server.packets;

import org.madmeg.networking.Packet;

/**
 * @author Madmegsox1
 * @since 09/02/2022
 */

public final class SPing extends Packet {
    public long timeSent;
    public SPing() {
        super("SPing");
        timeSent = System.currentTimeMillis();
        appendData(timeSent + "");
    }


}
