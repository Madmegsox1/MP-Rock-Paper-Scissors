package org.madmeg.networking;

import org.madmeg.Core;
import org.madmeg.TitleScreen;
import org.madmeg.engine.render.elements.Color;
import org.madmeg.networking.processor.packets.CAuth;
import org.madmeg.networking.processor.packets.CRegister;
import org.madmeg.ui.elements.Label;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Madmegsox1
 * @since 20/02/2022
 */

public final class Auth {
    public static boolean validate(String username, String password){
        if(username.length() < 6)return false;
        return password.length() >= 6;
    }

    public static String hash(String toHash) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(
                toHash.getBytes(StandardCharsets.UTF_8));

        StringBuilder hexString = new StringBuilder(2 * encodedhash.length);
        for (byte b : encodedhash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static void auth(String username, String password, Label feedback, boolean reg)  {
        if(!validate(username, password)){
            TitleScreen.feedback.color = new Color(255, 0, 0);
            feedback.updateText("Username or Password must be longer than 5 letters!");
            return;
        }

        final String hashedPassword;
        try {
            hashedPassword = hash(password);
            Core.packetProcessor.queuePacket((reg) ? new CRegister(username, hashedPassword) : new CAuth(username, hashedPassword));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

}
