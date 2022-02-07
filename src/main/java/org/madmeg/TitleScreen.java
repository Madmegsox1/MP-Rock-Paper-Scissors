package org.madmeg;

import org.madmeg.engine.Profile;
import org.madmeg.engine.render.elements.Color;
import org.madmeg.engine.render.font.Font;
import org.madmeg.event.events.KeyEvent;
import org.madmeg.event.events.MouseClickEvent;
import org.madmeg.event.events.RenderEvent;
import org.madmeg.ui.Gui;
import org.madmeg.ui.elements.Background;
import org.madmeg.ui.elements.Button;
import org.madmeg.ui.elements.Label;

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


public class TitleScreen implements Gui {



    public TitleScreen(){

        Core.getDisplay().setTitle("Login");

        Core.getFontRenderer().addFont(new Font(new java.awt.Font("impact", java.awt.Font.BOLD,50), true));

        addElement(new Background(new Color(0,0,0), this));
        addElement(new Label(Profile.Display.WIDTH / 2 - Core.getFontRenderer().fonts.get(1).getWidth("RPS CARDS") / 2, 40, this, Core.getFontRenderer().fonts.get(1), "RPS CARDS"));
        addElement(new Button(Profile.Display.WIDTH / 2  - 20, 100,
                60,
                40,
                this,
                "START",
                new Color(100,0,0),
                n -> Core.getUiManager().setCurrentGui(new Credits())
        ));
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
