package org.madmeg;

import org.lwjgl.opengl.GL11;
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
import org.madmeg.ui.elements.Input;
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

/** Colours
 * #202C39
 * #283845
 * #B8B08D
 * #F2D492
 * #F29559
 */


public final class TitleScreen implements Gui {


    public Texture rpsTexture;


    public TitleScreen() {

        rpsTexture = new Texture("rps");

        Core.getDisplay().setTitle("Login");

        Core.getFontRenderer().addFont(new Font(new java.awt.Font("impact", java.awt.Font.BOLD,50), true));

        addElement(new Background(new Texture("mountainBg"), this));

        addElement(new Label(Profile.Display.WIDTH / 2 - Core.getFontRenderer().fonts.get(1).getWidth("RPS-101") / 2, 40, this, Core.getFontRenderer().fonts.get(1), "RPS-101",
                new Color(32, 44, 57)));

        addElement(new Button(Profile.Display.WIDTH / 2  - 20, 100,
                80,
                40,
                this,
                "Credits",
                new Color(100,0,0),
                n -> Core.getUiManager().setCurrentGui(new Credits())));

        addElement(new Button(Profile.Display.WIDTH / 2  - 20, 150,
                60,
                40,
                this,
                "Menu",
                new Color(100,0,0),
                n -> Core.getUiManager().setCurrentGui(new Menu())
        ));

        addElement(new Input(600, 600, 200, 20, this, new Color(255,255,255), new Color(0,0,0), "", Core.getFontRenderer().fonts.get(0)));
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
        GL11.glPushMatrix();

        GL11.glRotatef(10, 0,0,1);
        GL11.glTranslatef(-500f, -500f, 1);
        RenderEngine.drawQuadTexture(new Vector2(500, 500), 100, 150, RenderEngine.normalize(40, 128, 0), 0, RenderEngine.normalize(45, 128, 0), RenderEngine.normalize(68, 128, 0), rpsTexture);
        GL11.glPopMatrix();
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
