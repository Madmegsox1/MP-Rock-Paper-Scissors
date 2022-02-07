package org.madmeg.event.events;

import org.lwjgl.glfw.GLFW;
import org.madmeg.event.processor.Event;

/**
 * @author Madmegsox1
 * @since 20/08/2021
 */

public final class KeyEvent extends Event {
    public final int key, action;
    public final long window;
    public KeyEvent(int key, int action,long window){
        this.key = key;
        this.action = action;
        this.window = window;
    }


    public static String convertKey(int key){
        return GLFW.glfwGetKeyName(key, GLFW.glfwGetKeyScancode(key));
    }
}
