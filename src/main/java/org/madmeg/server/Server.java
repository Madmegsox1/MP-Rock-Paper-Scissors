package org.madmeg.server;

import org.madmeg.server.json.Database;
import org.madmeg.server.models.Lobby;
import org.madmeg.server.models.User;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Madmegsox1
 * @since 09/02/2022
 */

public final class Server {

    public static Database userDatabase;

    public static ArrayList<Lobby> lobbies;


    public static void main(String[] args) throws IOException {

        userDatabase = new Database();


        userDatabase.createDatabase(User.class);
        userDatabase.initJsonObject();
        userDatabase.readDbToJsonObject();

        lobbies = new ArrayList<>();
        lobbies.add(new Lobby(1, "Test", "Test123"));
        lobbies.add(new Lobby(2, "Test2", "Test123"));
        PacketProcessor packetProcessor = new PacketProcessor();
        packetProcessor.openPort(PacketProcessor.port);
        packetProcessor.run();
    }
}
