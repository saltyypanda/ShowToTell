package com.showtotell.view;

import javafx.scene.layout.HBox;

public class ThumbChanger implements ThumbObserver {
    private HBox box;

    public ThumbChanger(HBox box) {
        this.box = box;
    }

    @Override
    public void thumbChanged(ShowToTellGUI gui, boolean bool) {
        if (bool) {
            box.getChildren().clear();
        }
        else {
            gui.returnToRoot();
        }
    }
}
