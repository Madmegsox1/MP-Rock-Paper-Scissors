package org.madmeg.engine.render.font;

import org.madmeg.engine.render.elements.Color;
import org.madmeg.engine.render.elements.Vector2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Madmegsox1
 * @since 02/02/2022
 */

public final class FontRenderer {

    public ArrayList<Font> fonts = new ArrayList<>();

    public FontRenderer(Font... f1){
        fonts.addAll(List.of(f1));
    }


    public void addFont(Font f){
        fonts.add(f);
    }


    public void renderFont(String text, Vector2 vector, Color c){
        fonts.get(0).drawText(text, vector.x, vector.y, c);
    }

    public void renderFont(String text, Vector2 vector){
        fonts.get(0).drawText(text, vector.x, vector.y);
    }

    public void renderFont(String text, Vector2 vector, Color c, int index){
        fonts.get(index).drawText(text, vector.x, vector.y, c);
    }

    public void renderFont(String text, Vector2 vector, int index){
        fonts.get(index).drawText(text, vector.x, vector.y);
    }

}
