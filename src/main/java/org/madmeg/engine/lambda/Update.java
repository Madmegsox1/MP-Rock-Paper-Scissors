package org.madmeg.engine.lambda;

/**
 * @author Madmegsox1
 * @since 02/02/2022
 */

public interface Update<T> {
    void run(T t);
}
