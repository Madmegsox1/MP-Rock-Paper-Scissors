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

public interface Gui {

    ArrayList<Element> elements = new ArrayList<>();

    String name();

    default void addElement(Element e){
        e.assignId(elements.size() + 1);
        elements.add(e);
    }

    default void passEvents(Event event){
        try {
            for (Element e : elements) {
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

    void update();

    void render(RenderEvent event);

    void mouseClick(MouseClickEvent event);

    void keyTyped(KeyEvent event);
}
