package com.showtotell.view;

import com.showtotell.model.App;

import javafx.scene.layout.HBox;

public class ThumbChanger implements ThumbObserver {
    private App app;
    private HBox box;

    public ThumbChanger(App app, HBox box) {
        this.app = app;
        this.box = box;
    }

    @Override
    public void thumbChanged(boolean bool) {
        if (bool) {
            box.getChildren().clear();
        }
        else {
            app.thumbClicked();
        }
    }
}
