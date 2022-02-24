package org.madmeg.server.json;

import com.google.gson.*;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Objects;

public final class Database {

    private File file;
    private JsonObject parentObject;

    public void createDatabase(final Class<?> model) throws IOException {
        this.file = new File(model.getSimpleName()+".json");
        if(file.exists())return;
        this.file.createNewFile();
    }

    public void initJsonObject(){
        parentObject = new JsonObject();
    }

    public void saveModelToObject(final String key, final Object modelToSave) throws IllegalAccessException {
        if(!file.exists())return;


        final JsonObject jsonObject = new JsonObject();

        final Field[] fields = modelToSave.getClass().getFields();

        for(final Field f : fields){
            f.setAccessible(true);
            switch (f.getType().getSimpleName()) {
                case "String" -> jsonObject.addProperty(f.getName(), f.get(modelToSave).toString());
                case "double" ->  jsonObject.addProperty(f.getName(), f.getDouble(modelToSave));
                case "float" -> jsonObject.addProperty(f.getName(), f.getFloat(modelToSave));
                case "int" -> jsonObject.addProperty(f.getName(), f.getInt(modelToSave));
                case "boolean" -> jsonObject.addProperty(f.getName(), f.getBoolean(modelToSave));
                case "long" -> jsonObject.addProperty(f.getName(), f.getLong(modelToSave));
                case "short" -> jsonObject.addProperty(f.getName(), f.getShort(modelToSave));
                case "char" -> jsonObject.addProperty(f.getName(), f.getChar(modelToSave));
                default -> System.out.println("Unknown datatype from json DB " + modelToSave.getClass().getName() + " skipping...");
            }
        }
        parentObject.add(key, jsonObject);
    }

    public void saveModelsToDb() throws IOException {
        final FileWriter fr = new FileWriter(file);
        final Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create();

        @SuppressWarnings("deprecation")
        final JsonParser jp = new JsonParser();

        final JsonElement je = jp.parse(parentObject.toString());
        fr.write(gsonBuilder.toJson(je));
        fr.close();
    }

    public void searchDatabase(final String key, final Object modelToLoad) throws FileNotFoundException, IllegalAccessException {
        if(!file.exists())return;


        @SuppressWarnings("deprecation")
        final JsonParser parser = new JsonParser();

        final FileReader reader = new FileReader(file);
        final JsonObject jsonObject = parser.parse(reader).getAsJsonObject();

        if(!jsonObject.has(key)){
            return;
        }

        final JsonObject loadingObject = jsonObject.get(key).getAsJsonObject();

        final Field[] fields = modelToLoad.getClass().getFields();

        for (final Field f : fields){
            f.setAccessible(true);
            switch (f.getType().getSimpleName()) {
                case "String" -> f.set(modelToLoad, loadingObject.get(f.getName()).getAsString());
                case "double" -> f.set(modelToLoad, loadingObject.get(f.getName()).getAsDouble());
                case "float" -> f.set(modelToLoad, loadingObject.get(f.getName()).getAsFloat());
                case "int" -> f.set(modelToLoad, loadingObject.get(f.getName()).getAsInt());
                case "boolean" -> f.set(modelToLoad, loadingObject.get(f.getName()).getAsBoolean());
                case "long" -> f.set(modelToLoad, loadingObject.get(f.getName()).getAsLong());
                case "short" -> f.set(modelToLoad, loadingObject.get(f.getName()).getAsShort());
                case "char" -> f.set(modelToLoad, loadingObject.get(f.getName()).getAsCharacter());
                default -> System.out.println("Unknown datatype from json DB " + modelToLoad.getClass().getName() + " skipping...");
            }
        }



    }






}
