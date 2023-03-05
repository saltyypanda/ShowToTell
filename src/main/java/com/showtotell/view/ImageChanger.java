package com.showtotell.view;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

// public class ImageChanger implements ImageObserver {
//     private ImageView view;

//     public ImageChanger (ImageView view) {
//         this.view = view;
//     }

//     @Override
//     public void imageChanged(String filename) {
//         view.setImage(new Image(filename));
//     }
// }

public class ImageChanger implements ImageObserver {
    private Button button;
    private Text text;

    public ImageChanger (Button button, Text text) {
        this.button = button;
        this.text = text;
    }

    @Override
    public void imageChanged(String category, String name) {
        String filename = "file:resources/images/" + category + "/" + name + ".png";
        ImageView view = new ImageView(new Image(filename));
        view.setFitHeight(500);
        view.setFitWidth(500);
        button.setGraphic(view);
        text.setText(name);
    }
}