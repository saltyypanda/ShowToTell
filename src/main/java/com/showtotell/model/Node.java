package com.showtotell.model;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private final String name;
    private Node previous;
    private List<Node> children;

    public Node(String name, Node previous) {
        this.name = name;
        this.previous = previous;
        this.children = new ArrayList<>();
    }

    public Node(String name) {
        this.name = name;
        this.previous = null;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Node getPrevious() {
        return previous;
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
}