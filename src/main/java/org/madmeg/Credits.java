package org.madmeg;

import org.madmeg.engine.Profile;
import org.madmeg.engine.render.elements.Texture;
import org.madmeg.engine.event.events.KeyEvent;
import org.madmeg.engine.event.events.MouseClickEvent;
import org.madmeg.engine.event.events.RenderEvent;
import org.madmeg.engine.render.font.FontRenderer;
import org.madmeg.ui.Gui;
import org.madmeg.ui.elements.*;


/**
 * @author JLey21
 * @since 08/02/2022
 */

public final class Credits extends Gui {


    public Credits(){

        //page name
        Core.getDisplay().setTitle("RPS-101 | Credits");

        //background
        addElement(new Background(Core.BgTexture, this));


        //title
        addElement(new Quad(485, 20, 300,100, this, Core.title));
        addElement(new Label(Profile.Display.WIDTH / 2 - FontRenderer.titleFont.getWidth(" RPS-101") / 2, 40, this, FontRenderer.titleFont, "RPS-101", Profile.Colors.lighterTealSand));

        //sub-title
        addElement(new Label(Profile.Display.WIDTH / 2 - FontRenderer.titleFont.getWidth("Credits") / 2, 120, this, FontRenderer.titleFont, "Credits", Profile.Colors.navyBlue));

        //names and roles
        addElement(new Label(Profile.Display.WIDTH / 2 - 150 - FontRenderer.normalFont.getWidth("Everything") / 2, 220, this, FontRenderer.normalFont, "Everything", Profile.Colors.black));
        addElement(new Label(Profile.Display.WIDTH / 2 + 150 - FontRenderer.normalFont.getWidth("MadMegSox") / 2, 220, this, FontRenderer.normalFont, "MadMegSox", Profile.Colors.black));

        addElement(new Label(Profile.Display.WIDTH / 2 - 150 - FontRenderer.normalFont.getWidth("GUI Pages") / 2, 260, this, FontRenderer.normalFont, "GUI Pages", Profile.Colors.black));
        addElement(new Label(Profile.Display.WIDTH / 2 + 150 - FontRenderer.normalFont.getWidth("JLey21") / 2, 260, this, FontRenderer.normalFont, "JLey21", Profile.Colors.black));

        addElement(new Label(Profile.Display.WIDTH / 2 - 150 - FontRenderer.normalFont.getWidth("Useful") / 2, 300, this, FontRenderer.normalFont, "Useful", Profile.Colors.black));
        addElement(new Label(Profile.Display.WIDTH / 2 + 150 - FontRenderer.normalFont.getWidth("Basker12") / 2, 300, this, FontRenderer.normalFont, "Basker12", Profile.Colors.black));

        addElement(new Label(Profile.Display.WIDTH / 2 - 150 - FontRenderer.normalFont.getWidth("RPS Game") / 2, 340, this, FontRenderer.normalFont, "RPS Game", Profile.Colors.black));
        addElement(new Label(Profile.Display.WIDTH / 2 + 150 - FontRenderer.normalFont.getWidth("Cryo") / 2, 340, this, FontRenderer.normalFont, "Cryo", Profile.Colors.black));

        addElement(new Label(Profile.Display.WIDTH / 2 - 150 - FontRenderer.normalFont.getWidth("Menu") / 2, 380, this, FontRenderer.normalFont, "Menu", Profile.Colors.black));
        addElement(new Label(Profile.Display.WIDTH / 2 + 150 - FontRenderer.normalFont.getWidth("DraconicDroid") / 2, 380, this, FontRenderer.normalFont, "DraconicDroid", Profile.Colors.black));

        addElement(new Label(Profile.Display.WIDTH / 2 - 150 - FontRenderer.normalFont.getWidth("Artist") / 2, 420, this, FontRenderer.normalFont, "Artist", Profile.Colors.black));
        addElement(new Label(Profile.Display.WIDTH / 2 + 150 - FontRenderer.normalFont.getWidth("Hiddenmaask") / 2, 420, this, FontRenderer.normalFont, "Hiddenmaask", Profile.Colors.black));

        addElement(new Label(Profile.Display.WIDTH / 2 - 150 - FontRenderer.normalFont.getWidth("Useless") / 2, 460, this, FontRenderer.normalFont, "Useless", Profile.Colors.black));
        addElement(new Label(Profile.Display.WIDTH / 2 + 150 - FontRenderer.normalFont.getWidth("obro1738") / 2, 460, this, FontRenderer.normalFont, "obro1738", Profile.Colors.black));

        addElement(new Label(Profile.Display.WIDTH / 2 - 150 - FontRenderer.normalFont.getWidth("Useless") / 2, 500, this, FontRenderer.normalFont, "Useless", Profile.Colors.black));
        addElement(new Label(Profile.Display.WIDTH / 2 + 150 - FontRenderer.normalFont.getWidth("SquidNugi") / 2, 500, this, FontRenderer.normalFont, "SquidNugi", Profile.Colors.black));

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