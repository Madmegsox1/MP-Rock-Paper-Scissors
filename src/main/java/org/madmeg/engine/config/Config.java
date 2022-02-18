package org.madmeg.engine.config;

import org.madmeg.engine.render.font.Font;
import org.madmeg.engine.render.font.FontRenderer;

/**
 * @author Madmegsox1
 * @since 17/02/2022
 */

public final class Config {
    public boolean comicSans;


    public boolean isComicSans() {
        return comicSans;
    }

    public void setComicSans(boolean comicSans) {
        this.comicSans = comicSans;
    }



    public void update(){ // put things that need to be updated when the game is launched
        if(this.comicSans) {
            FontRenderer.titleFont = (new Font(new java.awt.Font("Comic Sans MS", java.awt.Font.BOLD, 50), true));
        }
    }

}
