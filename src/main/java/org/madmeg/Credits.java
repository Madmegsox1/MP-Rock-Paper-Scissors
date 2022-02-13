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
import org.madmeg.ui.Element;
import org.madmeg.ui.Gui;
import org.madmeg.ui.elements.*;

// gold 242, 212, 146
// blue 32, 44, 57

public final class Credits extends Gui {

    public Texture title;

    public Credits(){

        title = new Texture("button"); //replace with title.png when made


        Core.getDisplay().setTitle("Credits");

        //background
        addElement(new Background(new Texture("mountainBg"), this));


        //title
        addElement(new Quad(515, 30, 250,80, this,title));
        addElement(new Label(Profile.Display.WIDTH / 2 - Core.getFontRenderer().fonts.get(1).getWidth(" RPS-101") / 2, 40, this, Core.getFontRenderer().fonts.get(1), "RPS-101", new Color(242, 212, 146)));

        //sub-title
        addElement(new Label(Profile.Display.WIDTH / 2 - Core.getFontRenderer().fonts.get(1).getWidth("Credits") / 2, 120, this, Core.getFontRenderer().fonts.get(1), "Credits", new Color(32, 44, 57)));

        //names  - use github api to get names from commits
        addElement(new Label(Profile.Display.WIDTH / 2 - Core.getFontRenderer().fonts.get(2).getWidth("Name1") / 2, 240, this, Core.getFontRenderer().fonts.get(2), "Name1", new Color(242, 212, 146)));

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
        //RenderEngine.drawQuad(new Vector2(544, 39), 202, 52,new Color(242, 212, 146, 50));
        //RenderEngine.drawQuad(new Vector2(545, 40), 200, 50,new Color(32, 44, 57, 50));



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