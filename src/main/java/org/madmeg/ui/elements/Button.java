package org.madmeg.ui.elements;

import org.madmeg.engine.Engine;
import org.madmeg.engine.render.RenderEngine;
import org.madmeg.engine.render.elements.Color;
import org.madmeg.engine.render.elements.Texture;
import org.madmeg.engine.render.elements.Vector2;
import org.madmeg.engine.render.font.FontRenderer;
import org.madmeg.engine.event.events.MouseClickEvent;
import org.madmeg.engine.event.events.RenderEvent;
import org.madmeg.engine.lambda.Update;
import org.madmeg.ui.Element;
import org.madmeg.ui.Gui;

/**
 * @author Madmegsox1
 * @since 02/02/2022
 */

public final class Button extends Element {

    public Update<MouseClickEvent> update;
    public Color c;
    public String text;
    public Texture buttonTexture;

    public Button(int x, int y, int w, int h, Gui parent, String text, Color c, Update<MouseClickEvent> onClick) {
        super(x, y, w, h, parent);
        this.c = c;
        this.buttonTexture = null;
        this.text = text;
        this.update = onClick;
    }

    public Button(int x, int y, int w, int h, Gui parent, String text, Texture buttonTexture, Update<MouseClickEvent> onClick) {
        super(x, y, w, h, parent);
        this.c = null;
        this.buttonTexture = buttonTexture;
        this.text = text;
        this.update = onClick;
    }




    public void render(RenderEvent event){
        if(buttonTexture != null){
            RenderEngine.drawQuadTexture(new Vector2(x, y), w, h, buttonTexture);
        }else {
            RenderEngine.drawQuadA(new Vector2(x, y), w, h, c);
        }
        FontRenderer.buttonFont.drawText(text, x + (w / 2f) - (FontRenderer.buttonFont.getWidth(text) / 2f), y + (h / 2f) - (FontRenderer.buttonFont.getHeight(text) / 2f));
    }

    public void mouseClick(MouseClickEvent event){

        if(inBounds((int)event.mX, (int)event.mY)){
            update.run(event);
        }

    }

}
