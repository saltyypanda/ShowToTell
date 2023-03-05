package com.showtotell.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class PictureClicked implements EventHandler<ActionEvent> {
    private ShowToTellGUI gui;
    private String name;
    private ImageChanger changer;

    public PictureClicked(ShowToTellGUI gui, String name, ImageChanger changer) {
        this.gui = gui;
        this.name = name;
        this.changer = changer;
    }

    @Override
    public void handle(ActionEvent event) {
        gui.pictureClicked(name, changer);
    }
}