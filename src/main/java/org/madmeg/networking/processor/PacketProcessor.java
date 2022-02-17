package org.madmeg.networking.processor;

import org.jasypt.util.text.StrongTextEncryptor;
import org.madmeg.Core;
import org.madmeg.engine.event.processor.Event;
import org.madmeg.networking.Packet;
import org.madmeg.networking.processor.packets.CConnect;
import org.madmeg.server.packets.SConnect;
import org.madmeg.server.packets.SPing;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.ConnectException;
import java.net.Socket;
import java.util.*;

public final class PacketProcessor extends Thread {

    public static final int port = 4200;
    public static Socket currentSocket;
    public static long lastPacketTime;
    public static long ping;

    public static Queue<Packet> packetQueue;

    private String uuid;
    private String username = "test";

    private final List<Listener> events;

    public PacketProcessor() {
        events = new ArrayList<>();
        packetQueue = new LinkedList<>();
        this.start();
    }


    public void addPacketListener(final Object object) {
        getEvents(object);
    }

    public void removePacketListener(final Object object) {
        events.removeIf(listener -> listener.object == object);
    }


    private void getEvents(final Object object) {
        final Class<?> clazz = object.getClass();
        Arrays.stream(clazz.getDeclaredMethods()).spliterator().forEachRemaining(method -> {
            if (method.isAnnotationPresent(Receive.class)) {
                final Class<?>[] prams = method.getParameterTypes();
                if (prams.length != 1) {
                    throw new IllegalArgumentException("Method " + method + " doesnt have any event parameters");
                }
                if (!Event.class.isAssignableFrom(prams[0])) {
                    throw new IllegalArgumentException("Method " + method + " doesnt have any event parameters only non event parameters");
                }
                this.events.add(new Listener(method, object, prams[0], method.getAnnotation(Receive.class).priority(), method.getAnnotation(Receive.class).packet()));
                this.events.sort(Comparator.comparing(o -> o.priority));
            }
        });
    }

    @Override
    public void run() {
        while (Core.running) {
            while (!packetQueue.isEmpty()) {
                sendPacket(packetQueue.remove());
            }
            try {Thread.sleep(200);} catch (final InterruptedException e) {e.printStackTrace();}
        }
    }

    public void postPacket(final Packet event){
        if(events.isEmpty())return;
        events.spliterator().forEachRemaining(listener -> {
            if(listener.packet == event.getClass()){
                listener.method.setAccessible(true);
                try {
                    listener.method.invoke(listener.object, event);
                } catch (final IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void queuePacket(Packet packet){
        packetQueue.add(packet);
    }


    private Socket connect() throws IOException {
        return new Socket("0.0.0.0", port);
    }


    private BufferedReader receiveData(final Socket socket) throws IOException {
        final InputStream stream = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(stream));
    }

    private void sendData(final Socket socket, final String data) throws IOException {
        System.out.println(data);
        final OutputStream stream = socket.getOutputStream();
        final PrintWriter writer = new PrintWriter(stream, true);
        writer.println(data);
    }

    public void sendPacket(Packet packet) {
        System.out.println(packet.compilePacket());
        try {
            System.out.println("Connection to server");
            currentSocket = connect();
            System.out.println("Connected to server");
            lastPacketTime = System.currentTimeMillis();
            if(packet instanceof CConnect){
                sendData(currentSocket, packet.encryptPacket());
            }else {
                sendData(currentSocket, packet.encryptPacket(uuid, username));
            }

            String data = receiveData(currentSocket).readLine();

            final StrongTextEncryptor textEncryptor = new StrongTextEncryptor();
            final String[] dataSplit = data.split("\\|");
            textEncryptor.setPassword(dataSplit[1]);
            data = textEncryptor.decrypt(dataSplit[0]);


            System.out.println("Receiving data from server");
            processPacket(data);
            System.out.println("Processing packet from server");

            currentSocket.close();
            System.out.println("Closed connection with server");
            currentSocket = null;
        }catch (ConnectException e){
            System.out.println("Connection refused from server!");
            Core.running = false;
        }
        catch (final IOException e){
            e.printStackTrace();
        }
    }


    private void processPacket(String packet){
        final String[] data = packet.split("\\|");
        if(data.length < 1)return;
        final String head = data[0];

        switch (head){
            case "SConnect" -> {
                SConnect p = new SConnect();
                p.key = data[1];
                uuid = data[1];
                System.out.println("New uuid received from server -> " + uuid);
                postPacket(p);
            }case "SPing" -> {
                SPing p = new SPing();
                p.timeSent =Long.parseLong(data[1]);
                ping = System.currentTimeMillis() - Long.parseLong(data[1]);
                postPacket(p);
            }
        }
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
