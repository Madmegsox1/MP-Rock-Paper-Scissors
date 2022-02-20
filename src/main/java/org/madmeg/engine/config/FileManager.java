package org.madmeg.engine.config;

import org.madmeg.engine.config.processor.ConfigProcessor;

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

    public ConfigProcessor configProcessor;

    private final String path = "rps";
    private final String configPath = path + "/configs";

    public FileManager(){

        configProcessor = new ConfigProcessor();

        config = new Config();
        new File(path).mkdirs();
        new File(configPath).mkdirs();


        configProcessor.processClass(config);
    }

    /**
     * @param config takes an existing config if needed.
     */
    public FileManager(Config config){

        configProcessor = new ConfigProcessor();
        this.config = config;
        new File(path).mkdirs();
        new File(configPath).mkdirs();

        configProcessor.processClass(config);
    }

    /**
     * @throws IOException throws when an error occurs when writing to the config file
     * @throws IllegalAccessException throws when a filed can't be accessed
     */

    public void saveSettings() throws IOException, IllegalAccessException {
        configProcessor.saveConfigs(configPath);
    }

    /**
     * @throws FileNotFoundException throws if no file is found
     * @throws NoSuchFieldException throws if the name in the file doesn't link to the name of the fields
     * @throws IllegalAccessException throws if we are accessing the fields illegally
     */

    public void loadSettings() throws FileNotFoundException, NoSuchFieldException, IllegalAccessException {
        configProcessor.loadConfigs(configPath);
    }


    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }
}
