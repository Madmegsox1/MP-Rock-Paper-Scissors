package org.madmeg.networking;

public abstract class Packet {
    private final String packetHead;
    private String packetData;
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


}
