package com.showtotell.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;

public class PictureClicked implements EventHandler<ActionEvent> {
    private ShowToTellGUI gui;
    private Text text;
    private ImageChanger changer;

    public PictureClicked(ShowToTellGUI gui, Text text, ImageChanger changer) {
        this.gui = gui;
        this.text = text;
        this.changer = changer;
    }

    @Override
    public void handle(ActionEvent event) {
        gui.pictureClicked(text, changer);
    }
}