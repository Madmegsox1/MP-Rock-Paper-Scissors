package org.madmeg.networking;

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

    public static void auth(String username, String password, Label feedback) throws NoSuchAlgorithmException {
        if(!validate(username, password)){
            feedback.updateText("Username or Password must be longer than 5 letters!");
            return;
        }

        final String hashedPassword = hash(password);

    }

}
