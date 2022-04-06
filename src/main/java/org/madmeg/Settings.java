package org.madmeg;

import org.madmeg.engine.Profile;
import org.madmeg.engine.event.events.KeyEvent;
import org.madmeg.engine.event.events.MouseClickEvent;
import org.madmeg.engine.event.events.RenderEvent;
import org.madmeg.engine.render.elements.Color;
import org.madmeg.engine.render.elements.Texture;
import org.madmeg.engine.render.font.Font;
import org.madmeg.engine.render.font.FontRenderer;
import org.madmeg.ui.Element;
import org.madmeg.ui.Gui;
import org.madmeg.ui.elements.*;

import java.util.Arrays;


/**
 * @author JLey21
 * @since 15/02/2022
 */

public final class Settings extends Gui {

    public Settings(){

        //page name
        Core.getDisplay().setTitle("RPS-101 | Settings");

        //background
        addElement(new Background(Core.BgTexture, this));

        //title
        addElement(new Quad(485, 20, 300,100, this, Core.title));
        addElement(new Label(Profile.Display.WIDTH / 2 - FontRenderer.titleFont.getWidth(" RPS-101") / 2, 40, this, FontRenderer.titleFont, "RPS-101", Profile.Colors.lighterTealSand));

        //sub-title
        addElement(new Label(Profile.Display.WIDTH / 2 - FontRenderer.titleFont.getWidth("Settings") / 2, 120, this, FontRenderer.titleFont, "Settings", Profile.Colors.navyBlue));

        //Settings button - will change buttons to toggle switches when made
        addElement(new Label(Profile.Display.WIDTH / 2 - FontRenderer.buttonFont.getWidth("Font") / 2, 200, this, FontRenderer.buttonFont, "Font", Profile.Colors.navyBlue));
        addElement(new ComboBox(Profile.Display.WIDTH / 2 - FontRenderer.buttonFont.getWidth("Comic Sans MS") / 2, 225, this, Profile.Colors.navyBlue, Color.WHITE, FontRenderer.buttonFont, Arrays.asList("        Impact        ", "Comic Sans MS", "       Curlz MT       ", "       Papyrus       ")));


        addElement(new Switch(Profile.Display.WIDTH / 2 - 25, 500, Profile.Colors.navyBlue, Profile.Colors.white, this, Core.getFileManager().getConfig().isComicSans(), n ->  {
            if(n) {
                //comic sans
                FontRenderer.titleFont = (new Font(new java.awt.Font("Comic Sans MS", java.awt.Font.BOLD,40), true));
                Core.getFileManager().getConfig().setComicSans(true);
                FontRenderer.normalFont = (new Font(new java.awt.Font("Comic Sans MS", java.awt.Font.PLAIN,30), true));
                Core.getFileManager().getConfig().setComicSans(true);
                FontRenderer.buttonFont = (new Font(new java.awt.Font("Comic Sans MS", java.awt.Font.PLAIN,20), true));
                Core.getFileManager().getConfig().setComicSans(true);

            } //else {
                //impact
                //FontRenderer.titleFont = (new Font(new java.awt.Font("impact", java.awt.Font.BOLD,50), true));
                //Core.getFileManager().getConfig().setComicSans(false);
                //FontRenderer.normalFont = (new Font(new java.awt.Font("impact", java.awt.Font.PLAIN,30), true));
                //Core.getFileManager().getConfig().setComicSans(false);
                //FontRenderer.buttonFont = (new Font(new java.awt.Font("impact", java.awt.Font.PLAIN,20), true));
              //  Core.getFileManager().getConfig().setComicSans(false);
            //}
            //else {
                //Curlz MT
              //  FontRenderer.titleFont = (new Font(new java.awt.Font("Curlz MT", java.awt.Font.BOLD,50), true));
               // Core.getFileManager().getConfig().setComicSans(false);
                //FontRenderer.normalFont = (new Font(new java.awt.Font("Curlz MT", java.awt.Font.PLAIN,30), true));
                //Core.getFileManager().getConfig().setComicSans(false);
                //FontRenderer.buttonFont = (new Font(new java.awt.Font("Curlz MT", java.awt.Font.PLAIN,20), true));
                //Core.getFileManager().getConfig().setComicSans(false);
            //}
            else {
                //papyrus
                FontRenderer.titleFont = (new Font(new java.awt.Font("papyrus", java.awt.Font.BOLD,50), true));
                Core.getFileManager().getConfig().setComicSans(false);
                FontRenderer.normalFont = (new Font(new java.awt.Font("papyrus", java.awt.Font.PLAIN,30), true));
                Core.getFileManager().getConfig().setComicSans(false);
                FontRenderer.buttonFont = (new Font(new java.awt.Font("papyrus", java.awt.Font.PLAIN,20), true));
                Core.getFileManager().getConfig().setComicSans(false);
            }
        }));

        addElement(new Label(Profile.Display.WIDTH / 2 - FontRenderer.buttonFont.getWidth("Anti Aliasing") / 2, 255, this, FontRenderer.buttonFont, "Anti Aliasing", Profile.Colors.navyBlue));
        addElement(new Switch(Profile.Display.WIDTH / 2 - 25, 280, Profile.Colors.navyBlue, Profile.Colors.white, this, Core.getFileManager().getConfig().isAntiAliasing(), n ->  {
            Core.getFileManager().getConfig().setAntiAliasing(n);
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
