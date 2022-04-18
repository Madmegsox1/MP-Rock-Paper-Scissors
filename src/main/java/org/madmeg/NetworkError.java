package org.madmeg;

import org.madmeg.engine.Profile;
import org.madmeg.engine.event.events.RenderEvent;
import org.madmeg.engine.render.elements.Color;
import org.madmeg.engine.render.font.FontRenderer;
import org.madmeg.ui.Gui;
import org.madmeg.ui.elements.Background;
import org.madmeg.ui.elements.Label;

/**
 * @author Madmegsox1
 * @since 18/04/2022
 */

public final class NetworkError extends Gui {

    public NetworkError(){
        addElement(new Background(new Color(100,100,100, 150), this));
        addElement(new Label(Profile.Display.WIDTH / 2 - FontRenderer.titleFont.getWidth("Network Error - Cannot Connect to server") / 2, 80, this, FontRenderer.titleFont, "Network Error - Cannot Connect to server", Profile.Colors.white));
    }

    @Override
    public String name() {
        return "Network Error";
    }

    @Override
    public void render(RenderEvent event) {
        passEvents(event);
    }
}
