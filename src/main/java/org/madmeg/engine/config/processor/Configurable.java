package org.madmeg.engine.config.processor;

import java.lang.reflect.Field;

/**
 * @author Madmegsox1
 * @since 20/02/2022
 */

public record Configurable(Class<?> clazz, Field field, String dataType, Object instance) {
}
