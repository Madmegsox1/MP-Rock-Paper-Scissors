package org.madmeg.networking.processor;


import java.lang.reflect.Method;

public final class Listener {
    public final Method method;
    public final Object object;
    public final Class<?> packet;
    public final int priority;
    public final PacketTypes packetTypes;

    public Listener(final Method method, final Object object, final Class<?> packet, final int priority,final PacketTypes packetTypes){
        this.method = method;
        this.object = object;
        this.packet = packet;
        this.packetTypes = packetTypes;
        this.priority = priority;
    }
}

