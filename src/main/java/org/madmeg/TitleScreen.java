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

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Madmegsox1
 * @since 03/02/2022
 * @author Basker12
 * @since 07/02/22
 */

public final class TitleScreen extends Gui {


    public Texture paper;
    public Texture rock;
    public Texture scissors;


    public TitleScreen() {

        paper = new Texture("paper");
        rock = new Texture("rock");
        scissors = new Texture("scissor");


        Core.getDisplay().setTitle("Login");

        Core.getFontRenderer().addFont(new Font(new java.awt.Font("impact", java.awt.Font.BOLD,50), true));

        addElement(new Background(new Texture("mountainBg"), this));

        addElement(new Label(Profile.Display.WIDTH / 2 - Core.getFontRenderer().fonts.get(1).getWidth("RPS-101") / 2, 40, this, Core.getFontRenderer().fonts.get(1), "RPS-101",
                new Color(32, 44, 57)));

        addElement(new Button(Profile.Display.WIDTH / 2  - 20, 150,
                80,
                40,
                this,
                "Credits",
                new Color(100,0,0),
                n -> Core.getUiManager().setCurrentGui(new Credits())));

        addElement(new Button(Profile.Display.WIDTH / 2  - 20, 100,
                60,
                40,
                this,
                "Menu",
                new Color(100,0,0),
                n -> Core.getUiManager().setCurrentGui(new Menu())
        ));

        //addElement(new Input(600, 600, 200, 20, this, new Color(255,255,255), new Color(0,0,0), "", Core.getFontRenderer().fonts.get(0)));
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
