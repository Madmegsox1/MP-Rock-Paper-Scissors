package org.madmeg.ui.elements;

import org.madmeg.engine.Engine;
import org.madmeg.engine.render.RenderEngine;
import org.madmeg.engine.render.elements.Color;
import org.madmeg.engine.render.elements.Texture;
import org.madmeg.engine.render.elements.Vector2;
import org.madmeg.event.events.MouseClickEvent;
import org.madmeg.event.events.RenderEvent;
import org.madmeg.lambda.Update;
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
        Engine.getFontRenderer().renderFont(text, new Vector2(x + 5, y + (h / 2f) - (Engine.getFontRenderer().fonts.get(0).getHeight( text) / 2f)));
    }

    public void mouseClick(MouseClickEvent event){

        if(inBounds((int)event.mX, (int)event.mY)){
            update.run(event);
        }

    }

}
