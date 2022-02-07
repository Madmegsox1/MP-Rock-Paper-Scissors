package org.madmeg.engine.render;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.NULL;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWFramebufferSizeCallback;
import org.lwjgl.opengl.GL11;
import org.madmeg.engine.Engine;
import org.madmeg.engine.Profile;
import org.madmeg.event.events.KeyEvent;
import org.madmeg.event.events.MouseClickEvent;

public final class Display {
    private final String title;
    private GLFWErrorCallback errorCallback;
    private long window;

    public Display(final String title)
    {
        this.title = title;
    }

    public void init(boolean aa)
    {
        // Error callback.
        glfwSetErrorCallback(this.errorCallback = GLFWErrorCallback.createPrint(System.err));

        // GLFW initialize
        if (!glfwInit())
        {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        // Window config
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);

        if(aa) {
            glfwWindowHint(GLFW_SAMPLES, 4);
        }

        // Window creation
        this.window = GLFW.glfwCreateWindow(Profile.Display.WIDTH, Profile.Display.HEIGHT, this.title, NULL, NULL);

        // Make fullscreen
        // this.window = glfwCreateWindow(Constants.Display.WIDTH,
        // Constants.Display.HEIGHT, this.title, GLFW.glfwGetPrimaryMonitor(),
        // NULL);



        if (this.window == NULL)
        {
            throw new RuntimeException("Failed to create the GLFW window");
        }

        glfwSetMouseButtonCallback(window, ((window1, button, action, mods) -> Engine.getEventProcessor().postEvent(new MouseClickEvent(button, action, window))));
        glfwSetKeyCallback(window, ((window1, key, scancode, action, mods) -> Engine.getEventProcessor().postEvent(new KeyEvent(key, action, window))));

        // final GLFWVidMode vidmode =
        // glfwGetVideoMode(glfwGetPrimaryMonitor());

        glfwSetWindowAspectRatio(this.window, Profile.Display.ASPECT_RATIO_NUMERATOR, Profile.Display.ASPECT_RATIO_DENOMINATOR);
        glfwMakeContextCurrent(this.window);
        glfwSwapInterval(1);
        glfwShowWindow(this.window);

        org.lwjgl.glfw.GLFW.glfwSetFramebufferSizeCallback(this.window, resizeWindow);
        // GLFW.glfwSetCursorPos(window, 1080, 1920);
    }

    private static GLFWFramebufferSizeCallback resizeWindow = new GLFWFramebufferSizeCallback()
    {
        @Override
        public void invoke(final long window, final int width, final int height)
        {
            // Keep ratio when resizing window
            final int newHeight = (int) (width / 1.777777777777778D);

            GL11.glViewport(0, 0, width, newHeight);
        }
    };

    public GLFWErrorCallback getErrorCallback()
    {
        return this.errorCallback;
    }

    public long getWindow()
    {
        return this.window;
    }

    public void setTitle(final String title)
    {
        glfwSetWindowTitle(this.window, title);
    }

}
