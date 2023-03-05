package com.showtotell.model;

import java.util.List;
import java.util.ArrayList;

public class Category {
    private String name;
    private String imageFilename;
    private List<Category> children;

    public Category(String name, String imageFilename) {
        this.name = name;
        this.imageFilename = imageFilename;
        children = new ArrayList<Category>();
    }

    public String getName() {
        return name;
    }

    public String getImageFilename() {
        return imageFilename;
    }

    public void addChild(Category category) {
        children.add(category);
    }

    @Override
    public String toString() {
        return name + ",\t" + imageFilename + ",\t" + children.toString();
    }

    public static void main(String[] args) {
        String data = CategoryParser.readFileContents("resources/tree.csv");
        for (Category v : CategoryParser.getCategories(data).values()) {
            System.out.println("\n" + v);
        }
    }

}