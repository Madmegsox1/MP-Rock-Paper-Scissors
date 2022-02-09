package org.madmeg.ui;

import org.madmeg.event.events.KeyEvent;
import org.madmeg.event.events.MouseClickEvent;
import org.madmeg.event.events.RenderEvent;
import org.madmeg.event.processor.Event;

import java.util.ArrayList;

/**
 * @author Madmegsox1
 * @since 02/02/2022
 */

public abstract class Gui {

    public ArrayList<Element> elements = new ArrayList<>();

    public String name(){
        return "";
    }

    public void addElement(Element e){
        e.assignId(this.elements.size() + 1);
        this.elements.add(e);
    }

    public void passEvents(Event event){
        try {
            for (Element e : this.elements) {
                if (!e.shouldShow) continue;
                if (event instanceof RenderEvent) {
                    e.render((RenderEvent) event);
                } else if (event instanceof MouseClickEvent) {
                    e.mouseClick((MouseClickEvent) event);
                } else if (event instanceof KeyEvent) {
                    e.keyClick((KeyEvent) event);
                }
            }
        }catch (Exception ignored){}
    }

    public void update(){}

    public void render(RenderEvent event){}

    public void mouseClick(MouseClickEvent event){}

    public void keyTyped(KeyEvent event){}
}
