package org.madmeg.server.packets;

import org.madmeg.networking.Packet;
import org.madmeg.server.Server;
import org.madmeg.server.models.User;

import javax.crypto.KeyGenerator;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * @author Madmegsox1
 * @since 24/02/2022
 */

public final class SRegister extends Packet { //TODO check if name exists
    public SRegister(String[] sData) {
        super("SRegister");

        final String username = sData[4];
        final String password = sData[5];


        User tmpUser = new User();
        try {
            Server.userDatabase.searchDatabase(username,tmpUser);
        } catch (FileNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }

        if(tmpUser.username != null && tmpUser.hashedPassword != null){
            appendData("failed");
            return;
        }


        final KeyGenerator gen;
        try {
            gen = KeyGenerator.getInstance("AES");
            gen.init(256, new SecureRandom());
            String key = Base64.getEncoder().encodeToString(gen.generateKey().getEncoded());


            User user = new User(username, password, key);


            Server.userDatabase.saveModelToObject(username, user);
            Server.userDatabase.saveModelsToDb();

            appendData("success");
            appendData(key);

        } catch (NoSuchAlgorithmException | IllegalAccessException | IOException e) {
            e.printStackTrace();
        }

    }
}
