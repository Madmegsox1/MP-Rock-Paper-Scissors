package org.madmeg.event.processor;

import java.lang.reflect.Method;

/**
 * @author Madmegsox1
 * @since 05/06/2021
 */

public final class Listener {
    public final Method method;
    public final Object object;
    public final Class<?> event;
    public final EventPriority priority;
    public final boolean allEvents;

    public Listener(final Method method, final Object object, final Class<?> event, final EventPriority priority, final boolean allEvents){
        this.method = method;
        this.object = object;
        this.event = event;
        this.priority = priority;
        this.allEvents = allEvents;
    }
}
