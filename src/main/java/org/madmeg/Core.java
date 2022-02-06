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
import org.madmeg.ui.UiManager;


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
        display.init(true);
        renderer = new Renderer(display);
        renderer.init();
        texture = new Texture("1");
        fontRenderer = new FontRenderer(new Font());
        uiManager = new UiManager();
        uiManager.setCurrentGui(new TitleScreen());
        renderEngine = new RenderEngine();
        renderEngine.render(renderer, display);
    }


    @CommitEvent
    public void render(RenderEvent event){
        RenderEngine.drawQuadTexture(new Vector2(500, 500), 100, 100, texture);
        uiManager.renderCurrentGui(event);

    }

    @CommitEvent
    public void click(MouseClickEvent event){
        System.out.println(event.mX + " " + event.mY);
        uiManager.passEvents(event);
    }

    public static void main(String[] args){
        Core c = new Core();
        c.start();
    }
}
