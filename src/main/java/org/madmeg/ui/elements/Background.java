package org.madmeg.ui.elements;

import org.madmeg.engine.Profile;
import org.madmeg.engine.render.RenderEngine;
import org.madmeg.engine.render.elements.Color;
import org.madmeg.engine.render.elements.Vector2;
import org.madmeg.event.events.RenderEvent;
import org.madmeg.ui.Element;
import org.madmeg.ui.Gui;

/**
 * @author Madmegsox1
 * @since 06/02/2022
 */

public class Background extends Element {
    public Color c;
    public Background(Color c, Gui parent) {
        super(0, 0, parent);
        this.c = c;
    }

    @Override
    public void render(RenderEvent event) {
        RenderEngine.drawQuad(new Vector2(0,0), Profile.Display.WIDTH, Profile.Display.HEIGHT, c);
    }
}
