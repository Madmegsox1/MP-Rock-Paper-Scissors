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
        addElement(new Background(new Texture("mountainBg"), this));


        //title
        addElement(new Quad(485, 20, 300,100, this, Core.title));
        addElement(new Label(Profile.Display.WIDTH / 2 - FontRenderer.titleFont.getWidth(" RPS-101") / 2, 40, this, FontRenderer.titleFont, "RPS-101", Profile.Colors.lighterTealSand));

        //sub-title
        addElement(new Label(Profile.Display.WIDTH / 2 - FontRenderer.titleFont.getWidth("Credits") / 2, 120, this, FontRenderer.titleFont, "Credits", Profile.Colors.navyBlue));

        //names  - use GitHub api to get names from commits
        addElement(new Label(Profile.Display.WIDTH / 2 - 150 - FontRenderer.normalFont.getWidth("Role1") / 2, 200, this, FontRenderer.normalFont, "Role1", Profile.Colors.funnyOrange));
        addElement(new Label(Profile.Display.WIDTH / 2 + 150 - FontRenderer.normalFont.getWidth("Name1") / 2, 200, this, FontRenderer.normalFont, "Name1", Profile.Colors.funnyOrange));

        addElement(new Label(Profile.Display.WIDTH / 2 - 150 - FontRenderer.normalFont.getWidth("Role2") / 2, 240, this, FontRenderer.normalFont, "Role2", Profile.Colors.funnyOrange));
        addElement(new Label(Profile.Display.WIDTH / 2 + 150 - FontRenderer.normalFont.getWidth("Name2") / 2, 240, this, FontRenderer.normalFont, "Name2", Profile.Colors.funnyOrange));

        addElement(new Label(Profile.Display.WIDTH / 2 - 150 - FontRenderer.normalFont.getWidth("Role3") / 2, 280, this, FontRenderer.normalFont, "Role3", Profile.Colors.funnyOrange));
        addElement(new Label(Profile.Display.WIDTH / 2 + 150 - FontRenderer.normalFont.getWidth("Name3") / 2, 280, this, FontRenderer.normalFont, "Name3", Profile.Colors.funnyOrange));

        addElement(new Label(Profile.Display.WIDTH / 2 - 150 - FontRenderer.normalFont.getWidth("Role4") / 2, 320, this, FontRenderer.normalFont, "Role4", Profile.Colors.funnyOrange));
        addElement(new Label(Profile.Display.WIDTH / 2 + 150 - FontRenderer.normalFont.getWidth("Name4") / 2, 320, this, FontRenderer.normalFont, "Name4", Profile.Colors.funnyOrange));

        addElement(new Label(Profile.Display.WIDTH / 2 - 150 - FontRenderer.normalFont.getWidth("Role5") / 2, 360, this, FontRenderer.normalFont, "Role5", Profile.Colors.funnyOrange));
        addElement(new Label(Profile.Display.WIDTH / 2 + 150 - FontRenderer.normalFont.getWidth("Name5") / 2, 360, this, FontRenderer.normalFont, "Name5", Profile.Colors.funnyOrange));

        addElement(new Label(Profile.Display.WIDTH / 2 - 150 - FontRenderer.normalFont.getWidth("Role6") / 2, 400, this, FontRenderer.normalFont, "Role6", Profile.Colors.funnyOrange));
        addElement(new Label(Profile.Display.WIDTH / 2 + 150 - FontRenderer.normalFont.getWidth("Name6") / 2, 400, this, FontRenderer.normalFont, "Name6", Profile.Colors.funnyOrange));

        addElement(new Label(Profile.Display.WIDTH / 2 - 150 - FontRenderer.normalFont.getWidth("Role7") / 2, 440, this, FontRenderer.normalFont, "Role7", Profile.Colors.funnyOrange));
        addElement(new Label(Profile.Display.WIDTH / 2 + 150 - FontRenderer.normalFont.getWidth("Name7") / 2, 440, this, FontRenderer.normalFont, "Name7", Profile.Colors.funnyOrange));

        addElement(new Label(Profile.Display.WIDTH / 2 - 150 - FontRenderer.normalFont.getWidth("Role8") / 2, 480, this, FontRenderer.normalFont, "Role8", Profile.Colors.funnyOrange));
        addElement(new Label(Profile.Display.WIDTH / 2 + 150 - FontRenderer.normalFont.getWidth("Name8") / 2, 480, this, FontRenderer.normalFont, "Name8", Profile.Colors.funnyOrange));

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