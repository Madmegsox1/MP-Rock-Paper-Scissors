package org.madmeg;

import org.madmeg.engine.Profile;
import org.madmeg.engine.render.elements.Texture;
import org.madmeg.engine.render.font.FontRenderer;
import org.madmeg.engine.event.events.KeyEvent;
import org.madmeg.engine.event.events.MouseClickEvent;
import org.madmeg.engine.event.events.RenderEvent;
import org.madmeg.ui.Gui;
import org.madmeg.ui.elements.*;


/**
 * @author DraconicDroid
 * @since 08/02/2022
 * @author JLey21
 * @since 08/02/2022
 */


public final class Menu extends Gui {


    public Menu(){

        //page name
        Core.getDisplay().setTitle("RPS-101 | Menu");

        //background
        addElement(new Background(new Texture("mountainBg"), this));

        //title
        addElement(new Quad(485, 20, 300,100, this, Core.title));
        addElement(new Label(Profile.Display.WIDTH / 2 - FontRenderer.titleFont.getWidth(" RPS-101") / 2, 40, this, FontRenderer.titleFont, "RPS-101", Profile.Colors.lighterTealSand));

        //sub-title
        addElement(new Label(Profile.Display.WIDTH / 2 - Core.getFontRenderer().fonts.get(1).getWidth("Menu") / 2, 120, this, FontRenderer.titleFont, "Menu", Profile.Colors.navyBlue));

        //


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
        return "Menu";
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
