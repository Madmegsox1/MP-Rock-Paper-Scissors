package org.madmeg;

import org.madmeg.engine.Profile;
import org.madmeg.engine.render.RenderEngine;
import org.madmeg.engine.render.elements.Texture;
import org.madmeg.engine.render.elements.Vector2;
import org.madmeg.engine.event.events.KeyEvent;
import org.madmeg.engine.event.events.MouseClickEvent;
import org.madmeg.engine.event.events.RenderEvent;
import org.madmeg.engine.render.font.FontRenderer;
import org.madmeg.ui.Gui;
import org.madmeg.ui.elements.*;

/**
 * @author Madmegsox1
 * @since 03/02/2022
 * @author Baskersmells
 * @since 07/02/2022
 * @author JLey21
 * @since 08/02/2022
 *
 */

public final class TitleScreen extends Gui {


    public Texture paper;
    public Texture rock;
    public Texture scissors;


    public TitleScreen() {

        //bottom textures
        paper = new Texture("paper");
        rock = new Texture("rock");
        scissors = new Texture("scissor");

        //page name
        Core.getDisplay().setTitle("RPS-101 | Login");

        //background
        addElement(new Background(new Texture("mountainBg"), this));

        //title
        addElement(new Quad(485, 20, 300,100, this, Core.title));
        addElement(new Label(Profile.Display.WIDTH / 2 - FontRenderer.titleFont.getWidth(" RPS-101") / 2, 40, this, FontRenderer.titleFont, "RPS-101", Profile.Colors.lighterTealSand));


        //menu page - will remove button and load when user logs in
        addElement(new Button(30, 100,
                140,
                60,
                this,
                "Menu",
                Core.btnTexture,
                n -> Core.getUiManager().setCurrentGui(new Menu())));


        //user inputs
        Input Username;
        Input Password;
        addElement(new Label(Profile.Display.WIDTH / 2 - FontRenderer.normalFont.getWidth("Username") / 2, 200, this, FontRenderer.normalFont, "Username", Profile.Colors.navyBlue));
        addElement(Username = new Input(Profile.Display.WIDTH / 2  - 280 / 2, 250, 280, 40, this, Profile.Colors.white, Profile.Colors.black, "", FontRenderer.normalFont));

        addElement(new Label(Profile.Display.WIDTH / 2 - FontRenderer.normalFont.getWidth("Password") / 2, 300, this, FontRenderer.normalFont, "Password", Profile.Colors.navyBlue));
        addElement(Password = new Input(Profile.Display.WIDTH / 2  - 280 / 2, 350, 280, 40, this, Profile.Colors.white, Profile.Colors.black, "", FontRenderer.normalFont));

        addElement(new Button(Profile.Display.WIDTH / 2  - 140/2, 400, 140, 60, this, "Submit", Core.btnTexture, n ->System.out.println(Password))); //on click checks user details and logs in


        //settings page  -  also add to menu so don't have to log out to change settings
        addElement(new Button(Profile.Display.WIDTH / 2  - 140, 550,
                140,
                60,
                this,
                "Settings",
                Core.btnTexture,
                n -> Core.getUiManager().setCurrentGui(new Settings())));


        //credits page
        addElement(new Button(Profile.Display.WIDTH / 2 , 550,
                140,
                60,
                this,
                "Credits",
                Core.btnTexture,
                n -> Core.getUiManager().setCurrentGui(new Credits())));

    }


    @Override
    public String name() {
        return "TitleScreen";
    }

    @Override
    public void update() {

    }

    @Override
    public void render(RenderEvent event) {
        passEvents(event);
        RenderEngine.drawQuadTexture(new Vector2(100, 610), 50, 80, rock);
        RenderEngine.drawQuadTexture(new Vector2(Profile.Display.WIDTH/2 + 50/2 - 50, 610), 50, 80, paper);
        RenderEngine.drawQuadTexture(new Vector2(1130, 610), 50, 80, scissors);
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
