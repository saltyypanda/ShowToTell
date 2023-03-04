package com.showtotell.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageChanger implements ImageObserver {
    private ImageView view;

    public ImageChanger (ImageView view) {
        this.view = view;
    }

    @Override
    public void imageChanged(String filename) {
        view.setImage(new Image(filename));
    }
}