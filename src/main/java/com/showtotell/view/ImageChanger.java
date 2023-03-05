package com.showtotell.view;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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

    public ImageChanger (Button button) {
        this.button = button;
    }

    @Override
    public void imageChanged(String filename) {
        ImageView view = new ImageView(new Image(filename));
        view.setFitHeight(500);
        view.setFitWidth(500);
        button.setGraphic(view);
    }
}