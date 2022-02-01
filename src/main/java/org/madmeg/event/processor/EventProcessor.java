package org.madmeg.event.processor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Madmegsox1
 * @since 04/06/2021
 */

public final class EventProcessor {

    private final List<Listener> events;

    public EventProcessor() {
        events = new ArrayList<>();
    }

    /**
     * @param object the class that the events are in
     * @throws IllegalArgumentException
     */
    public void addEventListener(final Object object) throws IllegalArgumentException {
        getEvents(object);
    }

    public void removeEventListener(final Object object) {
        events.removeIf(listener -> listener.object == object);
    }

    /**
     * @param object takes the class where the events are committed
     */
    private void getEvents(final Object object) {
        final Class<?> clazz = object.getClass();
        Arrays.stream(clazz.getDeclaredMethods()).spliterator().forEachRemaining(method -> {
            if (method.isAnnotationPresent(CommitEvent.class) || method.isAnnotationPresent(AllEvents.class)) {
                final Class<?>[] prams = method.getParameterTypes();
                if (prams.length != 1) {
                    throw new IllegalArgumentException("Method " + method + " doesnt have any event parameters");
                }
                if (!Event.class.isAssignableFrom(prams[0])) {
                    throw new IllegalArgumentException("Method " + method + " doesnt have any event parameters only non event parameters");
                }
                this.events.add(new Listener(method, object, prams[0], getPriority(method), method.isAnnotationPresent(AllEvents.class)));
                this.events.sort(Comparator.comparing(o -> o.priority));
            }
        });
    }

    /**
     * @param event the event that you are listening for
     */
    public void postEvent(final Event event) {
        if(events.isEmpty())return;
        events.spliterator().forEachRemaining(listener -> {
            if(listener.allEvents){
                listener.method.setAccessible(true);
                try {
                    listener.method.invoke(listener.object, event);
                } catch (final IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            else if(listener.event == event.getClass()){
                listener.method.setAccessible(true);
                try {
                    listener.method.invoke(listener.object, event);
                } catch (final IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private EventPriority getPriority(final Method method) {
        if(method.getAnnotation(CommitEvent.class) == null){
            return method.getAnnotation(AllEvents.class).priority();
        }
        return method.getAnnotation(CommitEvent.class).priority();
    }
}
