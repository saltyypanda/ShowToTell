package com.showtotell.model;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private final String name;
    private final String imgFile;
    private List<Node> children;

    public Node(String name, String imgFile) {
        this.name = name;
        this.imgFile = imgFile;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getImgFile() {
        return imgFile;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void add(Node child) {
        children.add(child);
    }

    @Override
    public String toString() {
        String info = name + "\n";
        for (Node child : children) {
            if (children.size() > 0) {
                info += "\t" + child.toString();
            }
        }
        return info;
    }

    public static void main(String[] args) {
        Node food = new Node("Food", "file:resources/images/food/foodcollage.png");
        String tokens[] = "bananas burger pancakes pasta".split(" ");
        for (String item : tokens) {
            String filename = "file:resources/images/food/" + item + ".png";
            food.add(new Node(item, filename));
        }
        System.out.println(food);
    }
}