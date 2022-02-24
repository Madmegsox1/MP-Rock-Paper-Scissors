package org.madmeg.server;

import org.jasypt.util.text.StrongTextEncryptor;
import org.madmeg.networking.Packet;
import org.madmeg.server.packets.SAuth;
import org.madmeg.server.packets.SConnect;
import org.madmeg.server.packets.SPing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Madmegsox1
 * @since 09/02/2022
 */

public final class PacketProcessor {

    public static int port = 4200;
    public static ServerSocket serverSocket;
    public static boolean running;

    public static ArrayList<Client> clients;

    public PacketProcessor() {
        running = true;
        clients = new ArrayList<>();
    }

    public void openPort(int port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    private Socket receiveSocket() {
        try {
            return serverSocket.accept();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private BufferedReader receiveData(final Socket socket) {
        try {
            return new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void sendData(final Socket socket, final String msg) {
        System.out.println(msg);
        final PrintWriter writer;
        try {
            writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println(msg);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        if (serverSocket == null) {
            System.out.println("Server has not been initialised!");
            return;
        }
        while (running) {
            System.out.println("Listing for client");
            final Socket socket = receiveSocket();
            System.out.println("Client Connected");
            if (socket == null) {
                System.out.println("A error occurred trying to create a socket session with the client");
                return;
            }
            try {
                final String rData = receiveData(socket).readLine();
                System.out.println("Received packet from client");
                processPacket(rData, socket);
                System.out.println("Processed Packet");
                socket.close();
                System.out.println("Closed client connection");
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

    public void processPacket(String data, Socket socket) {
        String[] toDecrypt = data.split("\\|");
        final StrongTextEncryptor textEncryptor = new StrongTextEncryptor();
        textEncryptor.setPassword(toDecrypt[1]);
        data = textEncryptor.decrypt(toDecrypt[0]);


        final String[] sData = data.split("\\|");
        final String packetHead = sData[0];
        System.out.println(data);
        String uuid = "";
        String username = "";
        String token = "";
        if (sData.length > 3) {
            uuid = sData[1];
            username = sData[2];
            token = sData[3];

            boolean flag = false;

            for(final Client c : clients){
                if(Objects.equals(c.uuid, uuid)){
                    flag = true;
                    if(c.token.equals("null") && (!token.equals("null") && !token.isBlank())){
                        c.setToken(token);
                    }
                    break;
                }
            }
            if(!flag) {
                if (token.equals("null")) {
                    clients.add(new Client(uuid, username));
                    System.out.println("New client made with username of -> " + username + " and uuid of -> " + uuid);
                }
            }
        }

        switch (packetHead) {
            case "CPing" -> {
                sendPacket(new SPing(), socket, uuid);
            }
            case "CConnect" -> {
                sendPacket(new SConnect(), socket, "1");
            }
            case "CAuth" -> {
                sendPacket(new SAuth(sData), socket, uuid);
            }
        }
    }

    public void sendPacket(final Packet packet, final Socket socket, final String uuid) {
        if (serverSocket == null) {
            System.out.println("Server has not been initialised!");
            return;
        }
        if (socket == null) {
            System.out.println("A error occurred trying to create a socket session with the client");
            return;
        }
        sendData(socket, packet.encryptPacket(uuid));
    }
}
