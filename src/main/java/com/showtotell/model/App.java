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
    private List<Node> roots;
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
        this.roots = categories;
        return categories;
    }

    public App(ShowToTellGUI gui, String filename) throws IOException {
        this.gui = gui;
        this.main = makeMain(filename);
    }

    public void pictureClicked(Text text, ImageChanger changer) {
        Node node;
        String category = text.getText();
        for (Node item : main) {
            if (item.getName().toLowerCase().equals(category)) {
                if (item.getChildren().size() > 0) {
                    main = item.getChildren();
                    currentIndex = 0;
                    node = main.get(currentIndex);
                    changer.imageChanged(node);
                }
                break;
            }
        }
    }

    public void thumbClicked() {
        ImageChanger changer = gui.getChanger();
        if (currentIndex < main.size() - 1) {
            currentIndex++;
            Node node = main.get(currentIndex);
            changer.imageChanged(node);
        }
        else {
            if (main.get(currentIndex).getPrevious() != null) {
                currentIndex = 0;
                Node oldNode = main.get(currentIndex).getPrevious();
                if (oldNode.getPrevious() != null) {
                    oldNode = oldNode.getPrevious();
                    main = main.get(currentIndex).getPrevious().getChildren();
                }
                else {
                    main = this.roots;
                }
                Node node = main.get(currentIndex);
                changer.imageChanged(node);
            }
            else {
                System.out.println("Could not find item.");
                return;
            }
        }
    }

    @Override
    public String toString() {
        return main.toString();
    }
}
