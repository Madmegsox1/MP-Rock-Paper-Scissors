package org.madmeg.server;

import org.madmeg.networking.Packet;
import org.madmeg.server.packets.SConnect;
import org.madmeg.server.packets.SPing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author Madmegsox1
 * @since 09/02/2022
 */

public final class PacketProcessor {

    public static int port = 679;
    public static ServerSocket serverSocket;
    public static boolean running;

    public static ArrayList<Client> clients;

    public PacketProcessor(){
        running = true;
        clients = new ArrayList<>();
    }

    public void openPort(int port){
        try {
            serverSocket = new ServerSocket(port);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    private Socket receiveSocket(){
        try {
            return this.serverSocket.accept();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private BufferedReader receiveData(final Socket socket){
        try {
            return new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void sendData(final Socket socket, final String msg){
        final PrintWriter writer;
        try {
            writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println(msg);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        if(serverSocket == null){
            System.out.println("Server has not been initialised!");
            return;
        }
        while (running){
            final Socket socket = receiveSocket();
            if(socket == null){
                System.out.println("A error occurred trying to create a socket session with the client");
                return;
            }
            try {
                final String rData = receiveData(socket).readLine();
                processPacket(rData, socket);
                socket.close();
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }
        try {
            serverSocket.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public void processPacket(String data, Socket socket){
        final String[] sData = data.split("\\|");
        final String packetHead = sData[0];
        if(sData.length > 2) {
            final String uuid = sData[1];
            final String username = sData[2];
        }

        switch (packetHead){
            case "CPing" -> {
                sendPacket(new SPing(), socket);
            }
            case "CConnect" -> {
                sendPacket(new SConnect(), socket);
            }
        }
    }

    public void sendPacket(final Packet packet, final Socket socket){
        if(serverSocket == null){
            System.out.println("Server has not been initialised!");
            return;
        }
        if(socket == null){
            System.out.println("A error occurred trying to create a socket session with the client");
            return;
        }
        sendData(socket, packet.compilePacket());
    }
}
