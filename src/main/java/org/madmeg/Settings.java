package org.madmeg;

import org.madmeg.engine.Profile;
import org.madmeg.engine.render.elements.Color;
import org.madmeg.engine.render.elements.Texture;
import org.madmeg.event.events.KeyEvent;
import org.madmeg.event.events.MouseClickEvent;
import org.madmeg.event.events.RenderEvent;
import org.madmeg.ui.Gui;
import org.madmeg.ui.elements.Background;
import org.madmeg.ui.elements.Button;
import org.madmeg.ui.elements.Label;
import static org.madmeg.engine.Profile.Colors.navyBlue;

/**
 * @author JLey21
 * @since 15/02/2022
 */

//josh is making a toggle switch to use for settings.

public final class Settings extends Gui {

    public Settings(){
        Core.getDisplay().setTitle("Settings");

        addElement(new Background(new Texture("mountainBg"), this));
        addElement(new Label(Profile.Display.WIDTH / 2 - Core.getFontRenderer().fonts.get(3).getWidth("Settings") / 2, 40, this, Core.getFontRenderer().fonts.get(3), "Settings", new Color(32,44,57)));
        addElement(new Button(Profile.Display.WIDTH / 4  - 20, Profile.Display.HEIGHT-100,
                60,
                40,
                this,
                "Back",
                new Color(100,0,0),
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
