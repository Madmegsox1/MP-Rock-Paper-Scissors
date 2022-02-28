package org.madmeg;

import org.madmeg.engine.Profile;
import org.madmeg.engine.event.events.KeyEvent;
import org.madmeg.engine.event.events.MouseClickEvent;
import org.madmeg.engine.event.events.RenderEvent;
import org.madmeg.engine.render.elements.Color;
import org.madmeg.engine.render.font.FontRenderer;
import org.madmeg.ui.Gui;
import org.madmeg.ui.elements.Background;
import org.madmeg.ui.elements.Button;
import org.madmeg.ui.elements.Input;
import org.madmeg.ui.elements.Label;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.MessageFormat;

public class Game extends Gui {

    public Game(){

        addElement(new Background(Core.BgTexture, this));


        Input input1;
        Input input2;
        Label winnerLabel;
        addElement(input1 = new Input(200, 200, 500, 45, this, new Color(255,255,255), new Color(0,0,0), "Player 1", FontRenderer.normalFont));
        addElement(input2 = new Input(200, 320, 500, 45, this, new Color(255,255,255), new Color(0,0,0), "Player 2", FontRenderer.normalFont));
        addElement(winnerLabel = new Label(200, 500, this, FontRenderer.normalFont, "", new Color(32, 44, 57)));


        addElement(new Button(Profile.Display.WIDTH / 2  - 120/2+300, 320,
                120,
                60,
                this,
                "Enter",
                Core.btnTexture,
                n -> {
                    String link = MessageFormat.format("https://rps101.pythonanywhere.com/api/v1/match?object_one={0}&object_two={1}", input1.text, input2.text);

                    try {
                        URL url = new URL(link);
                        BufferedReader in = new BufferedReader(
                                new InputStreamReader(url.openStream()));
                        winnerLabel.text = in.readLine();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }));
//https://www.delftstack.com/howto/java/java-get-json-from-url/
    }

    @Override
    public String name() {
        return "Game";
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
