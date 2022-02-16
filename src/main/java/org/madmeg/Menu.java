package org.madmeg;

import org.madmeg.engine.Profile;
import org.madmeg.engine.render.elements.Color;
import org.madmeg.engine.render.elements.Texture;
import org.madmeg.engine.render.font.FontRenderer;
import org.madmeg.event.events.KeyEvent;
import org.madmeg.event.events.MouseClickEvent;
import org.madmeg.event.events.RenderEvent;
import org.madmeg.ui.Gui;
import org.madmeg.ui.elements.*;

import static org.madmeg.engine.Profile.Colors.navyBlue;

/**
 * @author DraconicVoid
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
        addElement(new Label(Profile.Display.WIDTH / 2 - Core.getFontRenderer().fonts.get(1).getWidth(" RPS-101") / 2, 40, this, FontRenderer.titleFont, "RPS-101", new Color(242, 212, 146)));

        //sub-title
        addElement(new Label(Profile.Display.WIDTH / 2 - Core.getFontRenderer().fonts.get(1).getWidth("Menu") / 2, 120, this, FontRenderer.titleFont, "Menu", new Color(32,44,57)));
        //

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
