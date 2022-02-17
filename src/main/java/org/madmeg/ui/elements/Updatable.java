package org.madmeg.ui.elements;

import org.madmeg.engine.event.events.RenderEvent;
import org.madmeg.engine.lambda.Update;
import org.madmeg.ui.Element;
import org.madmeg.ui.Gui;

public final class Updatable extends Element {
    public Update<RenderEvent> update;

    public Updatable(int x, int y, int w, int h, Gui parent, Update<RenderEvent> updatable) {
        super(x, y, w, h, parent);
        this.update = updatable;
    }


    @Override
    public void render(RenderEvent event) {
        update.run(event);
    }
}
