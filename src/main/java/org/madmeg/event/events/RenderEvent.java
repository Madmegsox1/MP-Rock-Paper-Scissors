package org.madmeg.event.events;

import org.madmeg.engine.render.RenderEngine;
import org.madmeg.engine.render.Renderer;
import org.madmeg.event.processor.Event;

/**
 * @author Madmegsox1
 * @since 20/08/2021
 */

public final class RenderEvent extends Event {
    public final Renderer renderer;
    public final RenderEngine renderEngine;

    public RenderEvent(Renderer renderer, RenderEngine renderEngine){
        this.renderer = renderer;
        this.renderEngine = renderEngine;
    }
}
