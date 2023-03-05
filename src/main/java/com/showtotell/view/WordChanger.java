package com.showtotell.view;

import com.showtotell.model.Node;

import javafx.scene.control.Button;

public class WordChanger implements WordObserver {
    private Button button;

    public WordChanger (Button button) {
        this.button = button;
    }

    @Override
    public void wordChanged(Node node) {
        button.setText(node.getName());
    }
}
