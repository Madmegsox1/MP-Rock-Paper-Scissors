package org.madmeg.engine.render.elements;

/**
 * @author Madmegsox1
 * @since 20/08/2021
 */

public final class Vector2 {
    public float x, y;

    public Vector2(final int x, final int y){
        this.x = x;
        this.y = y;
    }

    public Vector2(final double x, final double y) {
        this.x = (float) x;
        this.y = (float) y;
    }

    public Vector2(final float x, final float y) {
        this.x = x;
        this.y = y;
    }

    public void addToVect(final float x, final float y){
        this.x += x;
        this.y += y;
    }

    public void subToVect(final float x, final float y){
        this.x -= x;
        this.y -= y;
    }

    @Override
    public String toString(){
        return "[X: " + this.x + ", Y: " + this.y + "]";
    }
}
