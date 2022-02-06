package org.madmeg;

import org.madmeg.engine.Profile;
import org.madmeg.engine.render.elements.Color;
import org.madmeg.engine.render.font.Font;
import org.madmeg.event.events.KeyEvent;
import org.madmeg.event.events.MouseClickEvent;
import org.madmeg.event.events.RenderEvent;
import org.madmeg.ui.Gui;
import org.madmeg.ui.elements.Button;
import org.madmeg.ui.elements.Label;

/**
 * @author Madmegsox1
 * @since 03/02/2022
 */

public class TitleScreen implements Gui {

    public Font f;


    public TitleScreen(){
        f = new Font(new java.awt.Font("impact", java.awt.Font.BOLD,50), false);

        addElement(new Label(Profile.Display.WIDTH / 2 - f.getWidth("RPS CARDS") / 2, 40, this, f, "RPS CARDS"));
        addElement(new Button(Profile.Display.WIDTH / 2  - 20, 100,
                60,
                40,
                this,
                "START",
                new Color(0,0,0),
                n -> System.out.println("asd")
        ));
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
