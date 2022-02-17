package org.madmeg.engine;

import org.madmeg.engine.config.FileManager;
import org.madmeg.engine.render.Display;
import org.madmeg.engine.render.RenderEngine;
import org.madmeg.engine.render.Renderer;
import org.madmeg.engine.render.font.FontRenderer;
import org.madmeg.engine.event.processor.EventProcessor;
import org.madmeg.ui.UiManager;

public abstract class Engine extends Thread {

    protected static EventProcessor eventProcessor;
    protected static Display display;
    protected static Renderer renderer;
    protected static RenderEngine renderEngine;
    protected static FontRenderer fontRenderer;
    protected static UiManager uiManager;
    protected static FileManager fileManager;


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

    public static FontRenderer getFontRenderer() {
        return fontRenderer;
    }

    public static UiManager getUiManager() {
        return uiManager;
    }

    public static FileManager getFileManager() {
        return fileManager;
    }
}
