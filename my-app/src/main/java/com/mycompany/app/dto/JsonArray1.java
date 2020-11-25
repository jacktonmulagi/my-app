//package com.mycompany.app.Api;
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//import com.mycompany.app.utils.Item;
//import org.apache.commons.io.IOUtils;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.lang.reflect.Type;
//import java.nio.charset.StandardCharsets;
//import java.util.List;
//
//public class JsonArray1 {
//
//    public static void main(String[] args) throws IOException {
//
//        JavaParseJsonArray main = new JavaParseJsonArray();
//
//        Gson gson = new Gson();
//
//        Type listType = new TypeToken<List<Item>>() {}.getType();
//
//        List<Item> list = gson.fromJson(main.loadFileFromClasspath("array1.json"), listType);
//
//        System.out.println(gson.toJson(list));
//
//    }
//
//    public String loadFileFromClasspath(String fileName) throws IOException {
//        ClassLoader classLoader = getClass().getClassLoader();
//        try (InputStream inputStream = classLoader.getResourceAsStream(fileName)) {
//            // common-io
//            return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
//        }
//    }
//
//}}
