package org.madmeg;

import org.lwjgl.system.CallbackI;
import org.madmeg.engine.Profile;
import org.madmeg.engine.render.elements.Color;
import org.madmeg.engine.render.elements.Texture;
import org.madmeg.engine.render.font.Font;
import org.madmeg.engine.render.font.FontRenderer;
import org.madmeg.event.events.KeyEvent;
import org.madmeg.event.events.MouseClickEvent;
import org.madmeg.event.events.RenderEvent;
import org.madmeg.ui.Gui;
import org.madmeg.ui.elements.*;


import static org.madmeg.engine.Profile.Colors.navyBlue;

/**
 * @author JLey21
 * @since 15/02/2022
 */

//josh is making a toggle switch to use for settings.

public final class Settings extends Gui {

    public Settings(){

        //page name
        Core.getDisplay().setTitle("Settings");

        //background
        addElement(new Background(new Texture("mountainBg"), this));

        //title
        addElement(new Quad(485, 20, 300,100, this, Core.title));
        addElement(new Label(Profile.Display.WIDTH / 2 - FontRenderer.titleFont.getWidth(" RPS-101") / 2, 40, this, FontRenderer.titleFont, "RPS-101", new Color(242, 212, 146)));

        //sub-title
        addElement(new Label(Profile.Display.WIDTH / 2 - FontRenderer.titleFont.getWidth("Settings") / 2, 120, this, FontRenderer.titleFont, "Settings", new Color(32,44,57)));

        //Settings button - will change buttons to toggle switches when made
        addElement(new Label(Profile.Display.WIDTH / 2 - Core.getFontRenderer().fonts.get(2).getWidth("Comic Sans") / 2, 200, this, Core.getFontRenderer().fonts.get(2), "Comic Sans", new Color(32,44,57)));
        addElement(new Switch(Profile.Display.WIDTH / 2 - 25, 225, new Color(255,255,255), new Color(100, 100,100), this, n ->  {
            if(n) FontRenderer.titleFont = (new Font(new java.awt.Font("Comic Sans MS", java.awt.Font.BOLD,50), true));
            else FontRenderer.titleFont = (new Font(new java.awt.Font("impact", java.awt.Font.BOLD,50), true));
        }));

        //back button
        addElement(new Button(Profile.Display.WIDTH / 2 - Core.getFontRenderer().fonts.get(1).getWidth("Bk") / 2, Profile.Display.HEIGHT-100,
                80,
                40,
                this,
                "Back",
                Core.btnTexture,
                n -> Core.getUiManager().setCurrentGui(new TitleScreen())
        ));

    }

    @Override
    public String name() {
        return "Settings";
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
