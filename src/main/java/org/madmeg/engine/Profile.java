package org.madmeg.engine;


import org.madmeg.engine.render.Color;

public final class Profile {

    public final static class Display
    {

        public final static int WIDTH = 1280;
        public final static int HEIGHT = 720;
        public final static int ASPECT_RATIO_NUMERATOR = 16;
        public final static int ASPECT_RATIO_DENOMINATOR = 9;

        private final static int BACKGROUND_RED = 0;
        private final static int BACKGROUND_GREEN = 0;
        private final static int BACKGROUND_BLUE = 0;
        private final static int BACKGROUND_ALPHA = 0;
        public final static float[] BACKGROUND_COLOR = new float[]{BACKGROUND_RED/255f, BACKGROUND_GREEN/255f, BACKGROUND_BLUE/255f, BACKGROUND_ALPHA/255f};

    }

    public final static class Textures
    {

        public static final String TEXTURE_LOCATION = "res/";
        public static final String TEXTURE_FILEFORMAT = "png";

    }

    public final static class Sound
    {

        public static final String SOUND_LOCATION = "res/sound/";
        public static final String SOUND_FILEFORMAT = "wav";

    }

    public final static class Colors
    {

        public static final Color WHITE = new Color(255, 255, 255, 255);
        public static final Color BLACK = new Color(0, 0, 0, 255);
        public static final Color RED = new Color(255, 0, 0, 255);
        public static final Color GREEN = new Color(0, 255, 0, 255);
        public static final Color BLUE = new Color(0, 0, 255, 255);

    }

    public final static class UI
    {

        public static class Text
        {
            public final static int LETTER_SPACING = 12;
            public final static char[] LETTERS =
                    // Chars for the letters in the same order as the texture
                    { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0',
                            '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', '=', '!', ':', 32 };
        }
    }
}
