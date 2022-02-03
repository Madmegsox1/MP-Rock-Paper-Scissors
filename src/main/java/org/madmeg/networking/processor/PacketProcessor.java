package org.madmeg.networking.processor;

import org.madmeg.event.processor.Event;
import org.madmeg.networking.Packet;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public final class PacketProcessor {

    public static final int port = 679;
    public static Socket currentSocket;
    public static long lastPacketTime;

    private final List<Listener> events;

    public PacketProcessor() {
        events = new ArrayList<>();
    }


    public void addPacketListener(final Object object) throws IllegalArgumentException {
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


    private Socket connect() throws IOException {
        return new Socket("0.0.0.0", port);
    }


    private BufferedReader receiveData(final Socket socket) throws IOException {
        final InputStream stream = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(stream));
    }

    private void sendData(final Socket socket, final String data) throws IOException {
        final OutputStream stream = socket.getOutputStream();
        final PrintWriter writer = new PrintWriter(stream, true);
        writer.println(data);
    }

    public void sendPacket(Packet packet) {
        try {
            currentSocket = connect();
            lastPacketTime = System.currentTimeMillis();

            sendData(currentSocket, packet.compilePacket());

            final String data = receiveData(currentSocket).readLine();

            processPacket(data);

            currentSocket.close();
            currentSocket = null;
        }catch (final IOException e){
            e.printStackTrace();
        }
    }



    private void processPacket(String packet){

    }

}
