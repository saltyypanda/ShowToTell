package com.showtotell.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.showtotell.view.ImageChanger;
import com.showtotell.view.ShowToTellGUI;

import javafx.scene.text.Text;

public class App {
    private ShowToTellGUI gui;
    private List<Node> main;
    private int currentIndex;

    public List<Node> makeMain(String filename) throws IOException {
        List<Node> categories = new ArrayList<Node>();
        File file = new File(filename);
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);

        while (br.ready()) {
            String tokens[] = br.readLine().split(",");
            Node root = new Node(tokens[0]);
            categories.add(root);
            for (int i = 1; i < tokens.length; i++) {
                Node node = new Node(tokens[i], root);
                root.add(node);
            }
        }
        br.close();
        return categories;
    }

    public App(ShowToTellGUI gui, String filename) throws IOException {
        this.gui = gui;
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
        currentIndex = 0;
        Node node = main.get(currentIndex);
        System.out.println(node);
        changer.imageChanged(node);
    }

    public void thumbClicked() {
        if (currentIndex < main.size() - 1) {
            Node node = main.get(currentIndex + 1);
            System.out.println(node);
            ImageChanger changer = gui.getChanger();
            changer.imageChanged(node);
        }
    }

    @Override
    public String toString() {
        return main.toString();
    }
}
