package com.showtotell.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class WhenClicked implements EventHandler<ActionEvent> {
    private String filename;
    private ImageChanger changer;

    public WhenClicked(String filename, ImageChanger changer) {
        this.filename = filename;
        this.changer = changer;
    }

    @Override
    public void handle(ActionEvent event) {
        System.out.println(filename);
    }
}
