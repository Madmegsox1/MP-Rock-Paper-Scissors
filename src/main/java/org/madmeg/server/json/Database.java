package org.madmeg.server.json;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;

public final class Database {

    private File file;

    public void createDatabase(Object model) throws IOException {
        this.file = new File(model.getClass().getSimpleName()+".json");
        if(file.exists())return;
        this.file.createNewFile();
    }

    public void searchDatabase(String key, Object modelToLoad) throws FileNotFoundException {
        if(!file.exists())return;
        final JsonParser parser = new JsonParser();
        final FileReader reader = new FileReader(file);
        final JsonObject jsonObject = parser.parse(reader).getAsJsonObject();

        if(!jsonObject.has(key)){
            return;
        }



    }






}
