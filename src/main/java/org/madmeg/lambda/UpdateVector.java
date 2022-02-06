package org.madmeg.lambda;

import org.madmeg.engine.render.elements.Vector2;

/**
 * @author Madmegsox1
 * @since 06/02/2022
 */

public interface UpdateVector<T> {
    Vector2 run(T t);
}
