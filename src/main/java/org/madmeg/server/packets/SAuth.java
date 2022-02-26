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
        final String token = sData[3];
        final String username = sData[4];
        final String password = sData[5];
        try {
            User user = new User();
            Server.userDatabase.searchDatabase(username, user);
            if(user.username == null || user.hashedPassword == null || !user.username.equals(username) || !user.hashedPassword.equals(password)){
                appendData("failed");
            }else {

                for(Client c : PacketProcessor.clients){
                    if(c.equals(token)){

                        if(c.isLoggedIn()){
                            appendData("loggedIn");
                            return;
                        }

                        c.setLoggedIn(true);
                        break;
                    }
                }
                appendData("success");
                appendData(user.token);

            }

        } catch (FileNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
