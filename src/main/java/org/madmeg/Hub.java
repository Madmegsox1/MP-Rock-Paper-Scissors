package org.madmeg;

import org.madmeg.engine.Profile;
import org.madmeg.engine.event.events.KeyEvent;
import org.madmeg.engine.event.events.MouseClickEvent;
import org.madmeg.engine.event.events.RenderEvent;
import org.madmeg.engine.render.RenderEngine;
import org.madmeg.engine.render.elements.Color;
import org.madmeg.engine.render.font.FontRenderer;
import org.madmeg.networking.processor.packets.CLobby;
import org.madmeg.server.models.Lobby;
import org.madmeg.ui.Gui;
import org.madmeg.ui.elements.Background;
import org.madmeg.ui.elements.Label;
import org.madmeg.ui.elements.Quad;

import java.util.ArrayList;

/**
 * @author Madmegsox1
 * @since 26/02/2022
 */

public final class Hub extends Gui {

    public static ArrayList<Lobby> lobbies = new ArrayList<>();

    public Hub(){

        Core.packetProcessor.queuePacket(new CLobby());
        Core.getDisplay().setTitle("RPS-101 | Hub");

        addElement(new Background(Core.BgTexture, this));


        addElement(new Quad(485, 20, 300,100, this, Core.title));
        addElement(new Label(Profile.Display.WIDTH / 2 - FontRenderer.titleFont.getWidth( "Hub") / 2, 40, this, FontRenderer.titleFont, "Hub", Profile.Colors.lighterTealSand));
        addElement(new Quad(300, 200, 650, 500, this, new Color(25,25,25, 100)));

    }


    @Override
    public String name() {
        return "Hub";
    }

    @Override
    public void render(RenderEvent event) {
        passEvents(event);
        if(lobbies.isEmpty()){
            FontRenderer.normalFont.drawText("No lobby's open!", Profile.Display.WIDTH / 2f - FontRenderer.normalFont.getWidth("No lobby's open!") / 2f, 220);
        }else {
            int y = 210;
            for(Lobby l : lobbies){
                FontRenderer.buttonFont.drawText(l.id + " | " + l.name + " | " + l.hostName + " | " + l.full, 310, y);
                y += FontRenderer.buttonFont.getHeight("|") + 4;
            }
        }
    }

    @Override
    public void mouseClick(MouseClickEvent event) {
        passEvents(event);
    }

    @Override
    public void keyTyped(KeyEvent event) {
        passEvents(event);
    }
}
