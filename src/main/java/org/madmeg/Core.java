package org.madmeg;

import org.lwjgl.glfw.GLFW;
import org.madmeg.engine.Engine;
import org.madmeg.engine.config.Config;
import org.madmeg.engine.config.FileManager;
import org.madmeg.engine.render.Display;
import org.madmeg.engine.render.RenderEngine;
import org.madmeg.engine.render.Renderer;
import org.madmeg.engine.render.elements.Animation;
import org.madmeg.engine.render.elements.Texture;
import org.madmeg.engine.render.elements.Timer;
import org.madmeg.engine.render.elements.Vector2;
import org.madmeg.engine.render.font.Font;
import org.madmeg.engine.render.font.FontRenderer;
import org.madmeg.engine.event.events.KeyEvent;
import org.madmeg.engine.event.events.MouseClickEvent;
import org.madmeg.engine.event.events.RenderEvent;
import org.madmeg.engine.event.processor.CommitEvent;
import org.madmeg.networking.processor.PacketProcessor;
import org.madmeg.networking.processor.packets.CConnect;
import org.madmeg.networking.processor.packets.CPing;
import org.madmeg.ui.Gui;
import org.madmeg.ui.UiManager;

import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * @author Madmegsox1
 * @author JLey21
 *
 * Rock, Paper, Scissors Game
 *
 * * * * Please add your own author tags
 *
 */

public final class Core extends Engine {

    public Gui overlay = null;
    public static PacketProcessor packetProcessor;

    public static Texture btnTexture;
    public static Texture title;

    public Timer timer;
    public static boolean running;

    @Override
    public void run(){
        running = true;
        eventProcessor.addEventListener(this);


        display = new Display("Rock - Paper - Scissors 101");
        display.init(true);

        renderer = new Renderer(display);
        renderer.init();

        btnTexture = new Texture("button");
        title  = new Texture("button"); //replace with title.png when made


        fontRenderer = new FontRenderer(new Font());
        FontRenderer.titleFont = (new Font(new java.awt.Font("impact", java.awt.Font.BOLD,50), true));
        FontRenderer.normalFont = (new Font(new java.awt.Font("impact", java.awt.Font.PLAIN,30), true));
        FontRenderer.buttonFont = new Font();

        Core.getFontRenderer().addFont(new Font(new java.awt.Font("Comic Sans MS", java.awt.Font.BOLD,50), true));
        Core.getFontRenderer().addFont(new Font(new java.awt.Font("impact", java.awt.Font.BOLD,20), true));



        packetProcessor = new PacketProcessor();
        packetProcessor.queuePacket(new CConnect());

        timer = new Timer();

        fileManager = new FileManager();

        try {
            fileManager.loadSettings();
        } catch (NoSuchFieldException | IllegalAccessException | IOException e) {
            e.printStackTrace();
        }

        fileManager.getConfig().update();

        uiManager = new UiManager();
        uiManager.setCurrentGui(new TitleScreen());


        renderEngine = new RenderEngine();
        renderEngine.render(renderer, display);

    }


    @CommitEvent
    public void render(RenderEvent event){
        //RenderEngine.drawQuadTexture(new Vector2(500, 500), 100, 100, texture);
        uiManager.renderCurrentGui(event);
        if(overlay != null)  overlay.render(event);


        if(timer.passedMs(10000L) && running){
            packetProcessor.queuePacket(new CPing());
            timer.reset();
        }


        //animation.render();

    }

    @CommitEvent
    public void click(MouseClickEvent event){

        if(overlay != null) overlay.mouseClick(event);
        else uiManager.passEvents(event);
    }

    @CommitEvent
    public void key(KeyEvent event){
        if(event.key == GLFW.GLFW_KEY_F12 && event.action == 1){
            if(overlay == null){
                overlay = new Debug();
            }else {
                overlay = null;
            }
        }

        uiManager.passEvents(event);
        if(overlay != null)  overlay.keyTyped(event);
    }

    public static void main(String[] args){
        Core c = new Core();
        c.start();
    }
}
