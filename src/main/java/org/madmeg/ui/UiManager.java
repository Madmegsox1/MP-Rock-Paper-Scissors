package org.madmeg.ui;

import org.madmeg.engine.event.events.KeyEvent;
import org.madmeg.engine.event.events.MouseClickEvent;
import org.madmeg.engine.event.events.RenderEvent;
import org.madmeg.engine.event.processor.Event;

import java.util.Objects;

/**
 * @author Madmegsox1
 * @since 06/02/2022
 */

public final class UiManager {
    private Gui currentGui;

    public Gui getCurrentGui() {
        return currentGui;
    }

    public void setCurrentGui(Gui currentGui) {
        this.currentGui = currentGui;
    }


    public boolean isGuiCurrent(Gui gui){
        if(currentGui == null)return false;
        return Objects.equals(gui.name(), currentGui.name());
    }

    public void renderCurrentGui(RenderEvent event) {
        currentGui.render(event);
    }


    public void passEvents(Event event) {
            if (event instanceof MouseClickEvent) {
                currentGui.mouseClick((MouseClickEvent) event);
            } else if (event instanceof KeyEvent) {
                currentGui.keyTyped((KeyEvent) event);
            }
    }
}
