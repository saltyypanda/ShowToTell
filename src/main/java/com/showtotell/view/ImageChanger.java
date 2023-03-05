package com.showtotell.view;

import com.showtotell.model.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class ImageChanger implements ImageObserver {
    private Button button;
    private Text text;

    public ImageChanger (Button button, Text text) {
        this.button = button;
        this.text = text;
    }

    @Override
    public void imageChanged(Node node) {
        String filename;
        if (node.getPrevious() != null) {
            filename = "file:resources/images/" + node.getPrevious().getName() + "/" + node.getName() + ".png";
        }
        else {
            filename = "file:resources/images/" + node.getName() + "/" + node.getName() + "collage.png";
        }

        ImageView view = new ImageView(new Image(filename));
        view.setFitHeight(500);
        view.setFitWidth(500);
        button.setGraphic(view);
        text.setText(node.getName());
    }
}