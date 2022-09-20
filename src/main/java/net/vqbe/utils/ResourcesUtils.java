package net.vqbe.utils;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ResourcesUtils {
    private final Gson gson;

    public ResourcesUtils() {
        this.gson = new Gson();
    }

    public InputStream getFileFromResourceAsStream(String fileName) throws FileNotFoundException {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new FileNotFoundException("file " + fileName + " not found!");
        } else {
            return inputStream;
        }
    }

    public <T> T getJsonFileFromResourcesAsObject(String fileName, Class<T> tClass) throws FileNotFoundException {
        InputStream inputStream = getFileFromResourceAsStream(fileName);

        Reader reader = new InputStreamReader(inputStream);
        return gson.fromJson(reader, tClass);
    }
}
