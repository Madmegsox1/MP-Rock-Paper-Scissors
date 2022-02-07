package org.madmeg.ui.elements;

import org.lwjgl.glfw.GLFW;
import org.madmeg.engine.render.RenderEngine;
import org.madmeg.engine.render.elements.Color;
import org.madmeg.engine.render.elements.Vector2;
import org.madmeg.engine.render.font.Font;
import org.madmeg.event.events.KeyEvent;
import org.madmeg.event.events.MouseClickEvent;
import org.madmeg.event.events.RenderEvent;
import org.madmeg.ui.Element;
import org.madmeg.ui.Gui;

public final class Input extends Element {
    public Color color;
    public Color textColor;
    public String text;
    public Font font;

    public boolean editing;

    public Input(int x, int y, int w, int h, Gui parent, Color c, Color c2,String text, Font font) {
        super(x, y, w, h, parent);
        this.color = c;
        this.textColor = c2;
        this.text = text;
        this.font = font;
        this.editing = false;
    }


    @Override
    public void render(RenderEvent event) {
        RenderEngine.drawQuad(new Vector2(x, y), w, h, color);
        font.drawText(text, x + 10, y - 10, textColor);
    }

    @Override
    public void mouseClick(MouseClickEvent event) {
        if (inBounds((int)event.mX, (int)event.mY) && event.action == 1){
            editing = !editing;
        }
    }

    @Override
    public void keyClick(KeyEvent event) {
        if(editing && event.action == GLFW.GLFW_PRESS){
            this.text += KeyEvent.convertKey(event.key);
        }
    }
}
