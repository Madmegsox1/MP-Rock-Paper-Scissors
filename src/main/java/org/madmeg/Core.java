package org.madmeg;

import org.madmeg.engine.Engine;
import org.madmeg.engine.render.Display;
import org.madmeg.engine.render.RenderEngine;
import org.madmeg.engine.render.Renderer;
import org.madmeg.engine.render.elements.Texture;
import org.madmeg.engine.render.elements.Vector2;
import org.madmeg.engine.render.font.Font;
import org.madmeg.engine.render.font.FontRenderer;
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

    public Texture texture;


    @Override
    public void run(){
        eventProcessor.addEventListener(this);
        display = new Display("Rock - Paper - Scissors 101");
        display.init();
        renderer = new Renderer(display);
        renderer.init();
        texture = new Texture("transparent");
        fontRenderer = new FontRenderer(
                new Font(new java.awt.Font("times new roman", java.awt.Font.PLAIN, 30), true),
                new Font(new java.awt.Font("comic sans ms", java.awt.Font.PLAIN, 30), true),
                new Font()
                );
        renderEngine = new RenderEngine();
        renderEngine.render(renderer, display);
    }


    @CommitEvent
    public void render(RenderEvent event){

        RenderEngine.drawQuadTexture(new Vector2(100, 100), 100, 400, texture);

        fontRenderer.renderFont("asd", new Vector2(300, 300));



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
