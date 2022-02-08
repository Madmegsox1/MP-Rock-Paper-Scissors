package org.madmeg.engine.render.elements;

import org.madmeg.engine.render.RenderEngine;

import java.util.ArrayList;

public final class Animation {
    public ArrayList<Texture> textures;
    public Timer timer;
    public int keyFrame;
    public int index;
    public float w, h;
    public Vector2 pos;

    private int frame;

    public Animation(Vector2 pos, float w, float h, int keyFrame){
        this.keyFrame = keyFrame;
        this.timer = new Timer();
        this.textures = new ArrayList<>();
        this.index = 0;
        this.pos = pos;
        this.w = w;
        this.h =h;
    }



    public void addTexture(Texture texture){
        textures.add(texture);
    }

    public void setKeyFrame(int keyFrame){this.keyFrame = keyFrame;}


    public void render(){
        if(this.textures.isEmpty())return;

        if(frame > keyFrame){
            frame = 0;
            index++;
        }

        if(index > textures.size() -1 ){
            index = 0;
        }

        RenderEngine.drawQuadTexture(pos, w, h, textures.get(index));


        frame++;
    }






}
