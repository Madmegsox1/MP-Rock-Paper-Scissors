package org.madmeg.engine;


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
}
