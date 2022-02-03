package org.madmeg.ui.elements;

import org.madmeg.engine.render.font.Font;
import org.madmeg.event.events.RenderEvent;
import org.madmeg.ui.Element;
import org.madmeg.ui.Gui;

/**
 * @author Madmegsox1
 * @since 03/02/2022
 */

public final class Label extends Element {
    public Font font;
    public String text;


    public Label(int x, int y, Gui parent, Font font, String text) {
        super(x, y, parent);
        this.font = font;
        this.text = text;
    }

    @Override
    public void render(RenderEvent event) {
        this.font.drawText(text, x, y);
    }

    public void updateText(String text){
        this.text = text;
    }
}
