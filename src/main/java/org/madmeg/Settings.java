package org.madmeg;

import org.madmeg.engine.Profile;
import org.madmeg.engine.event.events.KeyEvent;
import org.madmeg.engine.event.events.MouseClickEvent;
import org.madmeg.engine.event.events.RenderEvent;
import org.madmeg.engine.render.elements.Color;
import org.madmeg.engine.render.elements.Texture;
import org.madmeg.engine.render.font.Font;
import org.madmeg.engine.render.font.FontRenderer;
import org.madmeg.ui.Gui;
import org.madmeg.ui.elements.*;


/**
 * @author JLey21
 * @since 15/02/2022
 */

//josh is making a toggle switch to use for settings.

public final class Settings extends Gui {

    public Settings(){

        //page name
        Core.getDisplay().setTitle("RPS-101 | Settings");

        //background
        addElement(new Background(new Texture("mountainBg"), this));

        //title
        addElement(new Quad(485, 20, 300,100, this, Core.title));
        addElement(new Label(Profile.Display.WIDTH / 2 - FontRenderer.titleFont.getWidth(" RPS-101") / 2, 40, this, FontRenderer.titleFont, "RPS-101", Profile.Colors.lighterTealSand));

        //sub-title
        addElement(new Label(Profile.Display.WIDTH / 2 - FontRenderer.titleFont.getWidth("Settings") / 2, 120, this, FontRenderer.titleFont, "Settings", Profile.Colors.navyBlue));

        //Settings button - will change buttons to toggle switches when made
        addElement(new Label(Profile.Display.WIDTH / 2 - Core.getFontRenderer().fonts.get(2).getWidth("Comic Sans") / 2, 200, this, Core.getFontRenderer().fonts.get(2), "Comic Sans", Profile.Colors.navyBlue));
        addElement(new Switch(Profile.Display.WIDTH / 2 - 25, 225, new Color(255,255,255), new Color(100, 100,100), this, Core.getFileManager().getConfig().isComicSans(),n ->  {
            if(n) {
                FontRenderer.titleFont = (new Font(new java.awt.Font("Comic Sans MS", java.awt.Font.BOLD,50), true));
                Core.getFileManager().getConfig().setComicSans(true);
            } else {
                FontRenderer.titleFont = (new Font(new java.awt.Font("impact", java.awt.Font.BOLD,50), true));
                Core.getFileManager().getConfig().setComicSans(false);
            }
        }));

        //back button
        addElement(new Button(Profile.Display.WIDTH / 2 - FontRenderer.buttonFont.getWidth("Back") / 2, Profile.Display.HEIGHT-100,
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
