package org.madmeg.ui;

import org.madmeg.engine.event.events.KeyEvent;
import org.madmeg.engine.event.events.MouseClickEvent;
import org.madmeg.engine.event.events.RenderEvent;

/**
 * @author Madmegsox1
 * @since 02/02/2022
 */

public abstract class Element {
    public int x;
    public int y;
    public int w;
    public int h;
    public int id;
    public Gui parent;
    public boolean shouldShow;

    public Element(int x, int y,Gui parent){
        this.x = x;
        this.y = y;
        this.parent = parent;
        this.shouldShow = true;
    }

    public Element(int x, int y,int w, int h, Gui parent){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.parent = parent;
        this.shouldShow = true;
    }

    public void assignId(int id){
        this.id = id;
    }

    public void render(RenderEvent event){
    }

    public void mouseClick(MouseClickEvent event){
    }

    public void keyClick(KeyEvent event){
    }

    public boolean inBounds(int mX, int mY){
        return inBounds(mX, mY, w, h);
    }

    public boolean inBounds(int mX, int mY, int w, int h){
        return mX > x && mX < x + w && mY >y && mY < y + h;
    }
}
