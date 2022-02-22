package org.madmeg.ui.elements;

import org.madmeg.engine.event.events.MouseClickEvent;
import org.madmeg.engine.event.events.RenderEvent;
import org.madmeg.engine.render.RenderEngine;
import org.madmeg.engine.render.elements.Color;
import org.madmeg.engine.render.elements.Vector2;
import org.madmeg.engine.render.font.Font;
import org.madmeg.ui.Element;
import org.madmeg.ui.Gui;

import java.util.List;

public final class ComboBox extends Element {
    public final List<String> options;
    public Color c1;
    public Color c2;
    public Font f;

    public String currentOption;
    public int index;

    public ComboBox(int x, int y, Gui parent, Color c1, Color c2, Font font, List<String> options) {
        super(x, y, parent);
        this.c1 = c1;
        this.c2= c2;
        this.f = font;
        this.options = options;
        this.index = 0;
        this.currentOption = options.get(index);
    }


    @Override
    public void render(RenderEvent event) {
        RenderEngine.drawQuadA(new Vector2(x -2, y-2), f.getWidth(currentOption) + 12, f.getHeight(currentOption) + 9, Color.BLACK);
        RenderEngine.drawQuadA(new Vector2(x, y), f.getWidth(currentOption) + 8, f.getHeight(currentOption) + 5, c1);
        f.drawText(currentOption, x + 5, y + 3, c2);
    }

    @Override
    public void mouseClick(MouseClickEvent event) {
        if(inBounds((int)event.mX,(int) event.mY, f.getWidth(currentOption) + 5, f.getHeight(currentOption) + 5) && event.action == 1){
            index++;
            if(index >= options.size()){
                index = 0;
            }
            currentOption = options.get(index);
        }
    }
}
