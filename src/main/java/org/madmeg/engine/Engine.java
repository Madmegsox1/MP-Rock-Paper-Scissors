package org.madmeg.engine;

import org.madmeg.engine.render.Display;
import org.madmeg.event.processor.EventProcessor;

public abstract class Engine extends Thread {

    private EventProcessor eventProcessor;
    private Display display;


    public Engine(){
        this.eventProcessor = new EventProcessor();
    }


    public EventProcessor getEventProcessor() {
        return eventProcessor;
    }

    public Display getDisplay(){
        return display;
    }
}
