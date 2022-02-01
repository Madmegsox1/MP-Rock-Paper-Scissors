package org.madmeg.event.processor;

/**
 * @author Madmegsox1
 * @since 04/06/2021
 */

public abstract class Event {
    private boolean isCancelled;

    public Event(){
        isCancelled = false;
    }

    /**
     * @return if the event is cancelled
     */
    protected final boolean isCancelled() {
        return isCancelled;
    }

    /**
     * @param cancelled boolean to set if the event is cancelled
     */
    protected final void setCancelled(final boolean cancelled) {
        isCancelled = cancelled;
    }
}
