package org.madmeg.engine.render;

public class Color
{

    public float r;
    public float g;
    public float b;
    public float a;

    public Color(float r, float g, float b, float a)
    {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public Color(float r, float g, float b)
    {
        this(r, g, b, 255);
    }

    public Color()
    {
        this(255, 255, 255, 255);
    }

    public Color(int value)
    {
        int r = (value & 0x00FF0000) >> 16;
        int g = (value & 0x0000FF00) >> 8;
        int b = (value & 0x000000FF);
        int a = (value & 0xFF000000) >> 24;

        if (a < 0)
        {
            a += 256;
        }
        if (a == 0)
        {
            a = 255;
        }

        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

}