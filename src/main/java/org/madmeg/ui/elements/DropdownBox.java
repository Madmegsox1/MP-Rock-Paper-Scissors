package org.madmeg.ui.elements;

import org.madmeg.Core;
import org.madmeg.engine.event.events.MouseClickEvent;
import org.madmeg.engine.event.events.RenderEvent;
import org.madmeg.engine.render.RenderEngine;
import org.madmeg.engine.render.elements.Color;
import org.madmeg.engine.render.elements.Vector2;
import org.madmeg.engine.render.font.FontRenderer;
import org.madmeg.ui.Element;
import org.madmeg.ui.Gui;

public final class DropdownBox extends Element {

    public boolean up;
    public boolean open;
    public String[] options;
    public String selected;
    public Color c;
    int mx;

    public DropdownBox(int x, int y, Gui parent, Color c, String... options) {
        super(x, y, parent);
        up = false;
        open = false;
        this.options = options;
        selected = options[0];
        int cm = 0;
        this.c = c;
        for (String v : options) {
            if(cm < FontRenderer.buttonFont.getWidth(v)){
                cm = FontRenderer.buttonFont.getWidth(v);
            }
            mx += FontRenderer.buttonFont.getHeight(v);
        }
        w = cm;
        h = FontRenderer.buttonFont.getHeight(selected) + 5;
    }

    @Override
    public void render(RenderEvent event) {
        RenderEngine.drawQuadA(new Vector2(x, y), w, h, c);

        if(open){
            RenderEngine.drawQuadA(new Vector2(x, y), w, mx, c);

            float y = this.y + 2;
            for (String v : options){
                FontRenderer.buttonFont.drawText(v, x + 2, y, Color.WHITE);
                y+= FontRenderer.buttonFont.getHeight(v);
            }
        }else{
            FontRenderer.buttonFont.drawText(selected, x + 2, y + 2, Color.WHITE);
        }
    }


    @Override
    public void mouseClick(MouseClickEvent event) {

    }
}
