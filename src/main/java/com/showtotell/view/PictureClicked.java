package com.showtotell.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class PictureClicked implements EventHandler<ActionEvent> {
    private ShowToTellGUI gui;
    private String filename;
    private ImageChanger changer;

    public PictureClicked(ShowToTellGUI gui, String filename, ImageChanger changer) {
        this.gui = gui;
        this.filename = filename;
        this.changer = changer;
    }

    @Override
    public void handle(ActionEvent event) {
        gui.pictureClicked(filename, changer);
        System.out.println(filename);
    }
}