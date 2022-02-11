package org.madmeg;

import org.madmeg.engine.Profile;
import org.madmeg.engine.render.RenderEngine;
import org.madmeg.engine.render.elements.Color;
import org.madmeg.engine.render.elements.Texture;
import org.madmeg.engine.render.elements.Vector2;
import org.madmeg.engine.render.font.Font;
import org.madmeg.event.events.KeyEvent;
import org.madmeg.event.events.MouseClickEvent;
import org.madmeg.event.events.RenderEvent;
import org.madmeg.ui.Gui;
import org.madmeg.ui.elements.Background;
import org.madmeg.ui.elements.Button;
import org.madmeg.ui.elements.Label;

// gold 242, 212, 146
// blue 32, 44, 57

public final class Credits extends Gui {

    public Credits(){
        Core.getDisplay().setTitle("Credits");

        //background
        addElement(new Background(new Texture("mountainBg"), this));

        //title
        addElement(new Label(Profile.Display.WIDTH / 2 - Core.getFontRenderer().fonts.get(1).getWidth("RPS-101") / 2, 40, this, Core.getFontRenderer().fonts.get(1), "RPS-101", new Color(242, 212, 146)));
        addElement(new Label(Profile.Display.WIDTH / 2 - Core.getFontRenderer().fonts.get(1).getWidth(" RPS-101") / 2, 40, this, Core.getFontRenderer().fonts.get(1), "RPS-101", new Color(32, 44, 57)));

        //credits
        addElement(new Label(Profile.Display.WIDTH / 2 - Core.getFontRenderer().fonts.get(1).getWidth("Credits") / 2, 80, this, Core.getFontRenderer().fonts.get(1), "Credits", new Color(32, 44, 57,98)));

        //names
        addElement(new Label(Profile.Display.WIDTH / 2 - Core.getFontRenderer().fonts.get(1).getWidth("aaa") / 2, 120, this, Core.getFontRenderer().fonts.get(1), "PlaceHolder", new Color(242, 212, 146)));

        //back button
        addElement(new Button(Profile.Display.WIDTH / 2 - Core.getFontRenderer().fonts.get(1).getWidth("Bk") / 2, Profile.Display.HEIGHT-100,
                50,
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
        //box for names to be in
        //RenderEngine.drawQuad(new Vector2(x, y), w, h, color);

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
