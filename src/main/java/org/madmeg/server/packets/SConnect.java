package org.madmeg.server.packets;

import org.madmeg.networking.Packet;

import javax.crypto.KeyGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * @author Madmegsox1
 * @since 09/02/2022
 */

public final class SConnect extends Packet {
    public String key;
    public SConnect() {
        super("SConnect");
        try {
            final KeyGenerator gen = KeyGenerator.getInstance("AES");
            gen.init(256, new SecureRandom());
            key = Base64.getEncoder().encodeToString(gen.generateKey().getEncoded());
            appendData(key);
        } catch (final NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
