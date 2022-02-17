package org.madmeg.ui.elements;

import org.madmeg.engine.render.RenderEngine;
import org.madmeg.engine.render.elements.Color;
import org.madmeg.engine.render.elements.Texture;
import org.madmeg.engine.render.elements.Vector2;
import org.madmeg.engine.event.events.RenderEvent;
import org.madmeg.ui.Element;
import org.madmeg.ui.Gui;

public final class Quad extends Element {
    public Color color;
    public Texture texture;

    public Quad(int x, int y, int w, int h, Gui parent, Color color) {
        super(x, y, w, h, parent);
        this.color = color;
        texture = null;
    }

    public Quad(int x, int y, int w, int h, Gui parent, Texture texture) {
        super(x, y, w, h, parent);
        this.texture = texture;
        color = null;
    }

    @Override
    public void render(RenderEvent event) {
        if(color != null) {
            RenderEngine.drawQuad(new Vector2(x, y), w, h, color);
        }else {
            RenderEngine.drawQuadTexture(new Vector2(x, y),w , h, texture);
        }
    }
}
