package org.madmeg.server;

import org.madmeg.server.json.Database;
import org.madmeg.server.models.User;

import java.io.IOException;

/**
 * @author Madmegsox1
 * @since 09/02/2022
 */

public final class Server {

    public static Database userDatabase;


    public static void main(String[] args) throws IOException {

        userDatabase = new Database();


        userDatabase.createDatabase(User.class);
        userDatabase.initJsonObject();

        PacketProcessor packetProcessor = new PacketProcessor();
        packetProcessor.openPort(PacketProcessor.port);
        packetProcessor.run();
    }
}
