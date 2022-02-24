package org.madmeg.server.packets;

import org.madmeg.networking.Packet;
import org.madmeg.server.Client;
import org.madmeg.server.PacketProcessor;
import org.madmeg.server.Server;
import org.madmeg.server.models.User;

import java.io.FileNotFoundException;

public final class SAuth extends Packet {
    public SAuth(String[] sData) { // TODO database and rest of auth stuff
        super("SAuth");
        String token = sData[3];
        String username = sData[4];
        String password = sData[5];
        try {
            User user = new User();
            Server.userDatabase.searchDatabase(token, user);
            if(user.username == null || user.hashedPassword == null || !user.username.equals(username) || !user.hashedPassword.equals(password)){
                appendData("failed");
            }else {
                appendData("success");
                for(Client c : PacketProcessor.clients){
                    if(c.equals(token)){
                        c.setLoggedIn(true);
                        break;
                    }
                }

            }

        } catch (FileNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
