package org.madmeg;

import org.madmeg.engine.Engine;
import org.madmeg.engine.render.Display;
import org.madmeg.engine.render.RenderEngine;
import org.madmeg.engine.render.Renderer;
import org.madmeg.engine.render.elements.Animation;
import org.madmeg.engine.render.elements.Texture;
import org.madmeg.engine.render.elements.Vector2;
import org.madmeg.engine.render.font.Font;
import org.madmeg.engine.render.font.FontRenderer;
import org.madmeg.event.events.KeyEvent;
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
    public Animation animation;


    @Override
    public void run(){
        eventProcessor.addEventListener(this);
        display = new Display("Rock - Paper - Scissors 101");
        display.init(true);
        renderer = new Renderer(display);
        renderer.init();


        animation = new Animation(new Vector2(400, 400), 100, 100, 30);
        animation.addTexture(new Texture("1"));
        animation.addTexture(new Texture("test"));
        animation.addTexture(new Texture("transparent"));


        fontRenderer = new FontRenderer(new Font());
        uiManager = new UiManager();
        uiManager.setCurrentGui(new TitleScreen());
        renderEngine = new RenderEngine();
        renderEngine.render(renderer, display);
    }


    @CommitEvent
    public void render(RenderEvent event){
        //RenderEngine.drawQuadTexture(new Vector2(500, 500), 100, 100, texture);
        uiManager.renderCurrentGui(event);
        //animation.render();

    }

    @CommitEvent
    public void click(MouseClickEvent event){

        uiManager.passEvents(event);
    }

    @CommitEvent
    public void key(KeyEvent event){
        uiManager.passEvents(event);
    }

    public static void main(String[] args){
        Core c = new Core();
        c.start();
    }
}
