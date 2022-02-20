package org.madmeg.engine.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author Madmegsox1
 * @since 17/02/2022
 */

public final class FileManager {
    public Config config;

    private final String path = "rps";
    private final String configPath = path + "/configs";

    public FileManager(){
        config = new Config();
        new File(path).mkdirs();
        new File(configPath).mkdirs();
    }

    /**
     * @param config takes an existing config if needed.
     */
    public FileManager(Config config){
        this.config = config;
        new File(path).mkdirs();
        new File(configPath).mkdirs();
    }

    /**
     * @throws IOException throws when an error occurs when writing to the config file
     * @throws IllegalAccessException throws when a filed can't be accessed
     */

    public void saveSettings() throws IOException, IllegalAccessException {
        final File f = new File(configPath + "/settings.cfg");
        f.createNewFile();

        final Field[] fields =  config.getClass().getFields(); // Collects all fields in the class Config.java

        final FileWriter fr = new FileWriter(f);
        for(Field field : fields){  // Iterates through the collection of fields
            field.setAccessible(true); // sets the filed too accessible to avoid errors

            final String header = field.getName(); // gets the name of the filed
            final String val = field.get(config).toString(); // gets the value of the filed in the config instance

            fr.write(header+":"+val);
            fr.write("\n"); // writes it to the file

        }
        fr.close();
    }

    /**
     * @throws FileNotFoundException throws if no file is found
     * @throws NoSuchFieldException throws if the name in the file doesn't link to the name of the fields
     * @throws IllegalAccessException throws if we are accessing the fields illegally
     */

    public void loadSettings() throws FileNotFoundException, NoSuchFieldException, IllegalAccessException {
        final File f = new File(configPath + "/settings.cfg");
        if(!f.exists())return;

        final Scanner sc = new Scanner(f);

        while (sc.hasNextLine()){

            final String line = sc.nextLine(); // reads the file line
            if(!line.contains(":")) continue;
            final String head = line.split(":")[0]; // gets the head or the config type
            final String val = line.split(":")[1]; // gets the value

            final Field field = config.getClass().getField(head); // gets the field linked to the head
            field.setAccessible(true);

            switch (field.getType().getSimpleName()){ // gets the type of the field so the jvm knows what to cast the val string too
                case "String"-> {
                    field.set(config, val);
                }
                case "double" -> {
                    field.set(config, Double.valueOf(val));
                }
                case "float" -> {
                    field.set(config, Float.valueOf(val));
                }
                case "int" -> {
                    field.set(config, Integer.valueOf(val));
                }
                case "boolean" -> {
                    field.set(config, (Objects.equals(val, "true")));
                }
                default -> {
                    System.out.println("Unknown datatype from config skipping...");
                }
            }
        }
        sc.close();
    }


    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }
}
