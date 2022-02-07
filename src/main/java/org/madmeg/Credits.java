package org.madmeg;

import org.madmeg.engine.Profile;
import org.madmeg.engine.render.elements.Color;
import org.madmeg.engine.render.font.Font;
import org.madmeg.event.events.KeyEvent;
import org.madmeg.event.events.MouseClickEvent;
import org.madmeg.event.events.RenderEvent;
import org.madmeg.ui.Gui;
import org.madmeg.ui.elements.Background;
import org.madmeg.ui.elements.Button;
import org.madmeg.ui.elements.Label;

public final class Credits implements Gui {

    public Credits(){
        Core.getDisplay().setTitle("Credits");

        addElement(new Background(new Color(0,0,200), this));
        addElement(new Label(Profile.Display.WIDTH / 2 - Core.getFontRenderer().fonts.get(1).getWidth("Credits") / 2, 40, this, Core.getFontRenderer().fonts.get(1), "RPS CARDS", new Color(255,255,255)));
        addElement(new Button(Profile.Display.WIDTH / 4  - 20, Profile.Display.HEIGHT-100,
                60,
                40,
                this,
                "Back",
                new Color(100,0,0),
                n -> Core.getUiManager().setCurrentGui(new TitleScreen())
        ));

    }

    @Override
    public String name() {
        return "Credits";
    }

    @Override
    public void update() {

    }

    @Override
    public void render(RenderEvent event) {
        passEvents(event);
    }

    @Override
    public void mouseClick(MouseClickEvent event) {
        passEvents(event);
    }

    @Override
    public void keyTyped(KeyEvent event) {
        passEvents(event);
    }
}
