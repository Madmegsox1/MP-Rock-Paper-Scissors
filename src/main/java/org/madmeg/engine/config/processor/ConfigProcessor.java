package org.madmeg.engine.config.processor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author Madmegsox1
 * @since 20/02/2022
 */

public final class ConfigProcessor {

    public final ArrayList<Configurable> configurables;

    public ConfigProcessor() {
        this.configurables = new ArrayList<>();
    }


    public void processClass(Object object) {
        final Class<?> clazz = object.getClass();
        for (final Field field : clazz.getFields()) {
            if (!field.isAnnotationPresent(ConfigType.class)) continue;
            configurables.add(new Configurable(clazz, field, field.getAnnotation(ConfigType.class).dataType(), object));
        }
    }


    public void saveConfigs(String path) throws IOException, IllegalAccessException {
        Class<?> openClass = null;
        File file;
        FileWriter fr = null;
        for (final Configurable c : configurables) {
            if (openClass != c.clazz()) {
                file = new File(path + "/" + c.clazz().getSimpleName() + ".cfg");
                file.createNewFile();
                fr = new FileWriter(file);
                openClass = c.clazz();
            }
            c.field().setAccessible(true);
            fr.write(c.field().getName() + ":" + c.field().get(c.instance()).toString());
            fr.write("\n");
        }
        if (fr != null) fr.close();
    }


    public void loadConfigs(String path) throws FileNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class<?> openClass = null;
        File file;
        Scanner sc = null;
        for (final Configurable c : configurables) {
            if (openClass != c.clazz()) {
                file = new File(path + "/" + c.clazz().getSimpleName() + ".cfg");
                if (!file.exists()) continue;
                sc = new Scanner(file);
                openClass = c.clazz();
            }

            while (sc.hasNextLine()) {
                final String line = sc.nextLine();
                if (!line.contains(":")) continue;
                final String head = line.split(":")[0]; // gets the head or the config type
                final String val = line.split(":")[1]; // gets the value

                final Field field = c.instance().getClass().getField(head); // gets the field linked to the head

                field.setAccessible(true);


                switch (field.getType().getSimpleName()) { // gets the type of the field so the jvm knows what to cast the val string too
                    case "String" -> field.set(c.instance(), val);
                    case "double" -> field.set(c.instance(), Double.valueOf(val));
                    case "float" -> field.set(c.instance(), Float.valueOf(val));
                    case "int" -> field.set(c.instance(), Integer.valueOf(val));
                    case "boolean" -> field.set(c.instance(), (Objects.equals(val, "true")));
                    case "long" -> field.set(c.instance(), Long.valueOf(val));
                    case "short" -> field.set(c.instance(), Short.valueOf(val));
                    case "char" -> field.set(c.instance(), val.charAt(0));
                    default -> System.out.println("Unknown datatype from config " + c.clazz().getName() + " skipping...");
                }
            }
        }

    }


}
