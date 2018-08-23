package com.homedirect.study.storage;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;


public class AbstractStorage<T> {

    protected List<T> readDataSource(String source) {
        Gson gson = new Gson();
        JsonReader reader;
        try {
            reader = new JsonReader(new FileReader(source));
            return gson.fromJson(reader, new TypeToken<List<T>>() {}.getType());
        } catch (FileNotFoundException e) {
            System.out.println("failed to read file " + source + ", cause: " + e.getMessage());
            return null;
        }
    }

}
