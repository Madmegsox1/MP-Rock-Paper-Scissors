package org.madmeg.ui.elements;

import org.madmeg.engine.event.events.MouseClickEvent;
import org.madmeg.engine.event.events.RenderEvent;
import org.madmeg.engine.lambda.Update;
import org.madmeg.engine.render.RenderEngine;
import org.madmeg.engine.render.elements.Color;
import org.madmeg.engine.render.elements.Vector2;
import org.madmeg.ui.Element;
import org.madmeg.ui.Gui;

public final class Switch extends Element {

    public Update<Boolean> update;
    public Color c1;
    public Color c2;

    public boolean switched;

    public Switch(int x, int y, Color c1, Color c2, Gui parent, boolean switched, Update<Boolean> update) {
        super(x, y, parent);
        this.update = update;
        this.c1 = c1;
        this.c2 = c2;
        this.switched = switched;
    }


    @Override
    public void render(RenderEvent event) {
        RenderEngine.drawQuadA(new Vector2(x, y), 50, 20, c1);
        RenderEngine.drawQuadA(new Vector2(((!switched) ? x + 5 : x + 25), y + 5/2f), 20, 15, c2);
    }

    @Override
    public void mouseClick(MouseClickEvent event) {
        if(inBounds((int)event.mX, (int)event.mY, 50, 20) && event.action == 1){
            switched = !switched;
            this.update.run(switched);
        }
    }
}
