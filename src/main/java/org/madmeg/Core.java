package org.madmeg;

import org.madmeg.engine.Engine;
import org.madmeg.engine.render.Display;
import org.madmeg.engine.render.RenderEngine;
import org.madmeg.engine.render.Renderer;
import org.madmeg.event.events.MouseClickEvent;
import org.madmeg.event.events.RenderEvent;
import org.madmeg.event.processor.CommitEvent;


/**
 * @author Madmegsox1
 *
 * Rock, Paper, Scissors Game
 *
 * * * * Please add your own author tags
 */

public final class Core extends Engine {


    @Override
    public void run(){
        eventProcessor.addEventListener(this);
        display = new Display("Rock - Paper - Scissors 101");
        display.init();
        renderer = new Renderer(display);
        renderer.init();
        renderEngine = new RenderEngine();
        renderEngine.render(renderer, display);
    }


    @CommitEvent
    public void render(RenderEvent event){



    }

    @CommitEvent
    public void click(MouseClickEvent event){
        System.out.println(event.mX + " " + event.mY);
    }

    public static void main(String[] args){
        Core c = new Core();
        c.start();
    }
}
