package org.madmeg.engine.render;

import org.lwjgl.opengl.GL11;
import org.madmeg.engine.Engine;
import org.madmeg.engine.render.elements.Color;
import org.madmeg.engine.render.elements.Texture;
import org.madmeg.engine.render.elements.Vector2;
import org.madmeg.event.events.RenderEvent;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL14.glBlendFuncSeparate;

public final class RenderEngine {
    public void render(final Renderer renderer, final Display display) {
        while (!renderer.shouldClose()) {
            renderer.prepare();
            Engine.getEventProcessor().postEvent(new RenderEvent(renderer, this));
            renderer.render(display.getWindow());
        }

        System.exit(0);
    }


    public static void drawLine(final Vector2 a, final Vector2 b, final float width, final Color color){
        final float[] c = Color.convertColorToFloatAlpha(color);
        glColor4f(c[0], c[1], c[2], c[3]);
        glLineWidth(width);
        glBegin(GL_LINE_STRIP);

        glVertex2f(a.x, a.y);
        glVertex2f(b.x, b.y);

        glEnd();
    }


    public static void drawQuad(final Vector2 vector, final float width, final float height, final Color color){

        final float[] c = Color.convertColorToFloat(color);
        glColor3f(c[0], c[1], c[2]);
        glBegin(GL_QUADS);

        glVertex2f(vector.x, vector.y);
        glVertex2f(vector.x, vector.y + height);
        glVertex2f(vector.x + width, vector.y + height);
        glVertex2f(vector.x + width ,vector.y);

        glEnd();
    }

    public static void drawQuadA(final Vector2 vector, final float width, final float height, final Color color){

        final float[] c = Color.convertColorToFloatAlpha(color);
        glColor4f(c[0], c[1], c[2], c[3]);
        glBegin(GL_QUADS);

        glVertex2f(vector.x, vector.y);
        glVertex2f(vector.x, vector.y + height);
        glVertex2f(vector.x + width, vector.y + height);
        glVertex2f(vector.x + width ,vector.y);

        glEnd();
    }

    public static void drawQuadTexture(final Vector2 vector2, final float width, final float height, final Texture texture){
        glEnable(GL11.GL_BLEND);
        glBlendFuncSeparate(GL_SRC_ALPHA, GL_ONE, GL_ZERO, GL_ONE);
        texture.bind();
        glBegin(GL_QUADS);

        glTexCoord2f(0, 0);
        glVertex2f(vector2.x, vector2.y);

        glTexCoord2f(1, 0);
        glVertex2f(vector2.x + width ,vector2.y);

        glTexCoord2f(1, 1);
        glVertex2f(vector2.x + width, vector2.y + height);

        glTexCoord2f(0, 1);
        glVertex2f(vector2.x, vector2.y + height);

        glEnd();
        texture.disable();
        GL11.glDisable(GL_BLEND);
    }


    public static void drawQuadTexture(final Vector2 vector2, final float width, final float height, final float tx, final float ty, final float tw, final float th,final Texture texture){
        GL11.glEnable(GL11.GL_BLEND);
        glBlendFuncSeparate(GL_SRC_ALPHA, GL_ONE, GL_ZERO, GL_ONE);
        texture.bind();
        glBegin(GL_QUADS);

        glTexCoord2f(tx, ty);
        glVertex2f(vector2.x, vector2.y);

        glTexCoord2f(tx + tw, ty);
        glVertex2f(vector2.x + width ,vector2.y);

        glTexCoord2f(tx + tw, ty + th);
        glVertex2f(vector2.x + width, vector2.y + height);

        glTexCoord2f(tx, ty + th);
        glVertex2f(vector2.x, vector2.y + height);

        glEnd();
        texture.disable();
       GL11.glDisable(GL_BLEND);
    }
}