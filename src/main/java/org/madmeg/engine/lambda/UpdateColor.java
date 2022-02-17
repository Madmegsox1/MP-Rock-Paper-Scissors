package org.madmeg.engine.lambda;

import org.madmeg.engine.render.elements.Color;

/**
 * @author Madmegsox1
 * @since 06/02/2022
 */

public interface UpdateColor<T> {
    Color run(T t);
}
