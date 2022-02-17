package org.madmeg;

import org.madmeg.engine.Profile;
import org.madmeg.engine.event.events.KeyEvent;
import org.madmeg.engine.event.events.MouseClickEvent;
import org.madmeg.engine.event.events.RenderEvent;
import org.madmeg.engine.render.elements.Color;
import org.madmeg.engine.render.elements.Texture;
import org.madmeg.engine.render.font.FontRenderer;
import org.madmeg.ui.Gui;
import org.madmeg.ui.elements.*;


/**
 * @author JLey21
 * @since 08/02/2022
 */


public final class Login extends Gui {


    public Login(){

        //page name
        Core.getDisplay().setTitle("RPS-101 | Login");

        //background
        addElement(new Background(new Texture("mountainBg"), this));


        //title
        addElement(new Quad(485, 20, 300,100, this, Core.title));
        addElement(new Label(Profile.Display.WIDTH / 2 - FontRenderer.titleFont.getWidth(" RPS-101") / 2, 40, this, FontRenderer.titleFont, "RPS-101", new Color(242, 212, 146)));

        //sub-title
        addElement(new Label(Profile.Display.WIDTH / 2 - FontRenderer.titleFont.getWidth("Login") / 2, 120, this, FontRenderer.titleFont, "Login", new Color(32, 44, 57)));

        //user inputs
        addElement(new Label(Profile.Display.WIDTH / 2 - FontRenderer.titleFont.getWidth("Username") / 2, 120, this, FontRenderer.normalFont, "Username", new Color(32, 44, 57)));
        addElement(new Input(200, 200, 100, 40, this, new Color(255,255,255), new Color(0,0,0), "", Core.getFontRenderer().fonts.get(3)));

        addElement(new Label(Profile.Display.WIDTH / 2 - FontRenderer.titleFont.getWidth("Password") / 2, 120, this, FontRenderer.normalFont, "Password", new Color(32, 44, 57)));
        addElement(new Input(200, 200, 100, 40, this, new Color(255,255,255), new Color(0,0,0), "", Core.getFontRenderer().fonts.get(3)));

        //back button
        addElement(new Button(Profile.Display.WIDTH / 2 - FontRenderer.normalFont.getWidth("Bk") / 2, Profile.Display.HEIGHT-100,
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
        //box for names to be in
        //RenderEngine.drawQuad(new Vector2(x, y), w, h, color);
        //RenderEngine.drawQuad(new Vector2(544, 39), 202, 52,new Color(242, 212, 146, 50));
        //RenderEngine.drawQuad(new Vector2(545, 40), 200, 50,new Color(32, 44, 57, 50));
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