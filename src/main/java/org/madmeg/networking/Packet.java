package org.madmeg.networking;

import org.jasypt.util.text.StrongTextEncryptor;

public abstract class Packet {
    private final String packetHead;
    private String packetData = "";
    public final char splitter = '|';

    public Packet(String packetHead){
        this.packetHead = packetHead;
    }

    public void appendData(String data){
            packetData += splitter + data;
    }

    public void setData(String data){
        packetData = data;
    }

    public String compilePacket(){
        return packetHead + ((packetData.startsWith("|")) ? packetData : splitter + packetData);
    }

    public String compilePacket(String uuid, String username, String token){
        return packetHead +"|" +uuid + "|" + username + "|" + token + ((packetData.startsWith("|")) ? packetData : splitter + packetData);
    }

    public String encryptPacket(){
        StrongTextEncryptor textEncryptor = new StrongTextEncryptor();
        textEncryptor.setPassword("1");
        return textEncryptor.encrypt(compilePacket())+ "|1";
    }

    public String encryptPacket(String uuid){
        StrongTextEncryptor textEncryptor = new StrongTextEncryptor();
        textEncryptor.setPassword(uuid);
        return textEncryptor.encrypt(compilePacket())+ "|" + uuid;
    }

    public String encryptPacket(String uuid, String username, String token){
        StrongTextEncryptor textEncryptor = new StrongTextEncryptor();
        textEncryptor.setPassword(uuid);
        return textEncryptor.encrypt(compilePacket(uuid, username, token)) + "|" + uuid;
    }


}
