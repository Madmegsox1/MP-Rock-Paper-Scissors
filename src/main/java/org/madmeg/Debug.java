package org.madmeg;

import com.sun.management.OperatingSystemMXBean;
import org.madmeg.engine.Profile;
import org.madmeg.engine.render.RenderEngine;
import org.madmeg.engine.render.elements.Color;
import org.madmeg.engine.render.font.Font;
import org.madmeg.event.events.KeyEvent;
import org.madmeg.event.events.MouseClickEvent;
import org.madmeg.event.events.RenderEvent;
import org.madmeg.ui.Gui;
import org.madmeg.ui.elements.Background;
import org.madmeg.ui.elements.Label;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * @author Madmegsox1
 * @since 09/02/2022
 */

public final class Debug extends Gui {

    private final OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    private final RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();

    public Debug(){
        Font f = Core.getFontRenderer().fonts.get(0);
        addElement(new Background(new Color(100,100,100, 80), this));
        addElement(new Label(40, 40, this, f, "FPS: " + RenderEngine.fps, Color.WHITE));
        addElement(new Label(40, 60, this, f, "CORES: " + Runtime.getRuntime().availableProcessors(), Color.WHITE));
        addElement(new Label(40, 80, this ,f, "CPU: "+ operatingSystemMXBean.getProcessCpuLoad()* 100+"%", Color.WHITE));
        addElement(new Label(40, 100, this, f, "DISPLAY: " + Profile.Display.WIDTH + " x " + Profile.Display.HEIGHT, Color.WHITE));
        addElement(new Label(40, 120, this, f,"CURRENT SCREEN: " + Core.getUiManager().getCurrentGui().name(), Color.WHITE));
    }

    public String name(){
        return "Debug";
    }

    public void update(){}

    public void render(RenderEvent event){
        passEvents(event);
        Label label = (Label) elements.get(1);
        label.updateText("FPS: " + RenderEngine.fps);
        label = (Label) elements.get(3);
        label.updateText("CPU: "+ operatingSystemMXBean.getProcessCpuLoad() * 100 + "%");
    }

    public void mouseClick(MouseClickEvent event){
        passEvents(event);
    }

    public void keyTyped(KeyEvent event){
        passEvents(event);
    }
}
