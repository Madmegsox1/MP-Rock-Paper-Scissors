package org.madmeg.ui.elements;

import org.lwjgl.glfw.GLFW;
import org.madmeg.engine.render.RenderEngine;
import org.madmeg.engine.render.elements.Color;
import org.madmeg.engine.render.elements.Timer;
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
    public Color borderColor;
    public Timer timer = new Timer();

    public boolean editing;

    public Input(int x, int y, int w, int h, Gui parent, Color c, Color c2, String text, Font font) {
        super(x, y, w, h, parent);
        this.color = c;
        this.textColor = c2;
        this.text = text;
        this.font = font;
        this.borderColor = new Color(0,0,0);
        this.editing = false;
    }

    public Input(int x, int y, int w, int h, Gui parent, Color c, Color c2, Color c3, String text, Font font) {
        super(x, y, w, h, parent);
        this.color = c;
        this.textColor = c2;
        this.text = text;
        this.font = font;
        this.borderColor = c3;
        this.editing = false;
    }


    @Override
    public void render(RenderEvent event) {
        RenderEngine.drawQuadA(new Vector2(x - 5, y - 5), w + 10, h + 10, borderColor);
        RenderEngine.drawQuadA(new Vector2(x, y), w, h, color);
        font.drawText((this.editing) ? text + getCaret() : text, x + 10, y + (h / 2f) - (font.getHeight((this.editing) ? text + getCaret() : text) / 2f) , textColor);
    }

    @Override
    public void mouseClick(MouseClickEvent event) {
        if (inBounds((int)event.mX, (int)event.mY) && event.action == 1){
            editing = !editing;
        }
        else if(event.action == 1 && editing){
            editing = false;
        }

    }

    @Override
    public void keyClick(KeyEvent event) {
        if(editing && event.action == GLFW.GLFW_PRESS){

            if(event.key == GLFW.GLFW_KEY_BACKSPACE){
                this.text = this.text.substring(0, this.text.length() - 1);
            }else if(font.getWidth(this.text + KeyEvent.convertKey(event.key)) < this.w - 10 && KeyEvent.convertKey(event.key) != null){
                this.text += KeyEvent.convertKey(event.key);
            }
        }
    }

    private String getCaret() {
        if (this.timer.passedMs(1000L)) {
            timer.reset();
        }
        if (timer.passedMs(500l)) {
            return "_";
        }
        return "";
    }
}
