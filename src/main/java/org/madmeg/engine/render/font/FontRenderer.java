package org.madmeg.engine.render.font;

import org.madmeg.engine.render.elements.Vector2;

import java.awt.*;

/**
 * @author Madmegsox1
 * @since 02/02/2022
 */

public final class FontRenderer {
    public Font font1;
    public Font font2;
    public Font font3;

    public FontRenderer(Font f1, Font f2, Font f3){
        this.font1 = f1;
        this.font2 = f2;
        this.font3 = f3;
    }

    public void renderFont(String text, Vector2 vector, Color c){
        font1.drawText(text, vector.x, vector.y, c);
    }

    public void renderFont(String text, Vector2 vector){
        font1.drawText(text, vector.x, vector.y);
    }

    public void renderFont2(String text, Vector2 vector, Color c){
        font2.drawText(text, vector.x, vector.y, c);
    }

    public void renderFont2(String text, Vector2 vector){
        font2.drawText(text, vector.x, vector.y);
    }

    public void renderFont3(String text, Vector2 vector, Color c){
        font3.drawText(text, vector.x, vector.y, c);
    }

    public void renderFont3(String text, Vector2 vector){
        font3.drawText(text, vector.x, vector.y);
    }
}
