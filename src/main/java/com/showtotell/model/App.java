package com.showtotell.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.showtotell.view.ImageChanger;

import javafx.scene.text.Text;

public class App {
    private List<Node> main;

    public List<Node> makeMain(String filename) throws IOException {
        List<Node> categories = new ArrayList<Node>();
        File file = new File(filename);
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);

        while (br.ready()) {
            String tokens[] = br.readLine().split(",");
            Node root = new Node(tokens[0], "file:resources/images/" + tokens[0] + "/" + tokens[0] + "collage.png");
            categories.add(root);
            for (int i = 1; i < tokens.length; i++) {
                root.add(new Node(tokens[i], "file:resources/images/" + tokens[i] + "/" + tokens[i] + ".png"));
            }
        }
        br.close();
        return categories;
    }

    public App(String filename) throws IOException {
        this.main = makeMain(filename);
    }

    public void pictureClicked(Text text, ImageChanger changer) {
        String category = text.getText();
        for (Node node : main) {
            if (node.getName().toLowerCase().equals(category)) {
                main = node.getChildren();
                break;
            }
        }
        String name = main.get(0).getName();
        changer.imageChanged(category, name);
    }

    @Override
    public String toString() {
        return main.toString();
    }
}
