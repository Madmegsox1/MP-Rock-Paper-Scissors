package org.madmeg.networking.processor.packets;

import org.madmeg.networking.Packet;

/**
 * @author Madmegsox1
 * @since 07/03/2022
 */

public final class CAction extends Packet {
    public CAction(String actionName) {
        super("CAction");
        appendData(actionName);
    }
}
    