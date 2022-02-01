package org.madmeg.engine;

import org.madmeg.engine.render.Display;
import org.madmeg.engine.render.RenderEngine;
import org.madmeg.engine.render.Renderer;
import org.madmeg.event.processor.EventProcessor;

public abstract class Engine extends Thread {

    protected static EventProcessor eventProcessor;
    protected static Display display;
    protected static Renderer renderer;
    protected static RenderEngine renderEngine;


    public Engine(){
        eventProcessor = new EventProcessor();
    }


    public static EventProcessor getEventProcessor() {
        return eventProcessor;
    }

    public static Display getDisplay(){
        return display;
    }

    public static Renderer getRenderer() {
        return renderer;
    }

    public static RenderEngine getRenderEngine() {
        return renderEngine;
    }
}
