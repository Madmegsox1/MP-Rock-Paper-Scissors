package org.madmeg.server;

/**
 * @author Madmegsox1
 * @since 09/02/2022
 */

public final class Server {

    public static void main(String[] args) {
        PacketProcessor packetProcessor = new PacketProcessor();
        packetProcessor.openPort(PacketProcessor.port);
        packetProcessor.run();
    }
}
