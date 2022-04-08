package org.madmeg;

import org.madmeg.RPSGame.Game;
import org.madmeg.engine.Profile;
import org.madmeg.engine.render.RenderEngine;
import org.madmeg.engine.render.elements.Color;
import org.madmeg.engine.render.elements.Texture;
import org.madmeg.engine.render.elements.Vector2;
import org.madmeg.engine.event.events.KeyEvent;
import org.madmeg.engine.event.events.MouseClickEvent;
import org.madmeg.engine.event.events.RenderEvent;
import org.madmeg.engine.render.font.FontRenderer;
import org.madmeg.networking.Auth;
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

    public Input username;
    public Input password;
    public static Label feedback;


    public TitleScreen() {

        //bottom textures
        paper = new Texture("paper");
        rock = new Texture("rock");
        scissors = new Texture("scissor");

        //page name
        Core.getDisplay().setTitle("RPS-101 | Login");

        //background
        addElement(new Background(Core.BgTexture, this));

        //title
        addElement(new Quad(485, 20, 300,100, this, Core.title));
        addElement(new Label(Profile.Display.WIDTH / 2 - FontRenderer.titleFont.getWidth("RPS-101") / 2, 40, this, FontRenderer.titleFont, "RPS-101", Profile.Colors.lighterTealSand));


        //user inputs
        addElement(new Label(Profile.Display.WIDTH / 2 - FontRenderer.normalFont.getWidth("Username") / 2, 200, this, FontRenderer.normalFont, "Username", Profile.Colors.navyBlue));
        addElement(username = new Input(Profile.Display.WIDTH / 2  - 280 / 2, 250, 280, 40, this, Profile.Colors.navyBlue, Profile.Colors.tealSand, "", FontRenderer.normalFont));

        //change password to display * instead of text
        addElement(new Label(Profile.Display.WIDTH / 2 - FontRenderer.normalFont.getWidth("Password") / 2, 300, this, FontRenderer.normalFont, "Password", Profile.Colors.navyBlue));
        addElement(password = new Input(Profile.Display.WIDTH / 2  - 280 / 2, 350, 280, 40, this, Profile.Colors.navyBlue, Profile.Colors.tealSand, "", FontRenderer.normalFont));
        //add a show password button

        addElement(feedback = new Label(Profile.Display.WIDTH / 2, 460, this, FontRenderer.normalFont, "", new Color(255, 0,0)));

        addElement(new Button(Profile.Display.WIDTH / 2  - 140, 400, 140, 60, this, "Register", Core.btnTexture, n -> Auth.auth(username.text, password.text, feedback, true))); //on click registers new user and logs in
        addElement(new Button(Profile.Display.WIDTH / 2, 400, 140, 60, this, "Login", Core.btnTexture, n ->Auth.auth(username.text, password.text, feedback, false)));  //on click checks user details and logs in



        //settings page
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
        // draws rps textures to screen
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
