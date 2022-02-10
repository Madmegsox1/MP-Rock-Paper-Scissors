package org.madmeg.networking.processor.packets;

import org.madmeg.networking.Packet;

public final class CPing extends Packet {
    public CPing() {
        super("CPing");
        appendData(System.currentTimeMillis() + "");
    }
}
