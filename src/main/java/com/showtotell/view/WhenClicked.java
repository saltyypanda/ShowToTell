package com.showtotell.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class WhenClicked implements EventHandler<ActionEvent> {
    private String filename;

    public WhenClicked(String filename) {
        this.filename = filename;
    }

    @Override
    public void handle(ActionEvent arg0) {
        System.out.println(filename);
    }
}
