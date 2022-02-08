package org.madmeg.ui.elements;

import org.madmeg.engine.Profile;
import org.madmeg.engine.render.RenderEngine;
import org.madmeg.engine.render.elements.Color;
import org.madmeg.engine.render.elements.Texture;
import org.madmeg.engine.render.elements.Vector2;
import org.madmeg.event.events.RenderEvent;
import org.madmeg.ui.Element;
import org.madmeg.ui.Gui;

import java.awt.image.BufferedImage;

/**
 * @author Madmegsox1
 * @since 06/02/2022
 */

public final class Background extends Element {
    public Color c;
    public Texture backgroundTexture;

    public Background(Color c, Gui parent) {
        super(0, 0, parent);
        this.c = c;
        backgroundTexture = null;
    }

    public Background(Texture backgroundTexture, Gui parent){
        super(0,0, parent);
        this.backgroundTexture = backgroundTexture;
        this.c = null;
    }

    @Override
    public void render(RenderEvent event) {
        if(backgroundTexture != null){
            RenderEngine.drawQuadTexture(new Vector2(0,0), Profile.Display.WIDTH, Profile.Display.HEIGHT, this.backgroundTexture);
        }else {
            RenderEngine.drawQuadA(new Vector2(0, 0), Profile.Display.WIDTH, Profile.Display.HEIGHT, c);
        }
    }
}
