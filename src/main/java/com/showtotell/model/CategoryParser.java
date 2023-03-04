package com.showtotell.model;

import java.util.Map;
import java.util.HashMap;

import java.io.FileReader;
import java.io.File;
import java.io.IOException;

public class CategoryParser {

    public static String readFileContents(String path) {
        String text = "";
        int read;
        try {
            FileReader reader = new FileReader(new File(path));
            while ((read = reader.read()) != -1) {
                text += (char) read;
            }
            reader.close();
            return text;
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Category> getCategories(String text) {
        Map<String, String> childrenMap = new HashMap<String, String>();
        Map<String, Category> categoryMap = new HashMap<String, Category>();
        for(String line : text.split("\n")) {
            String[] tokens = line.split(",");
            String key = tokens[0];
            childrenMap.put(key, tokens[1]);
            String image = tokens[2];
            categoryMap.put(key, new Category(key, image));
        }
        for(String key : categoryMap.keySet()) {
            String[] children = childrenMap.get(key).split("/");
            for (String child : children) {
                categoryMap.get(key).addChild(categoryMap.get(child));
            }
        }
        return categoryMap;
    }
}