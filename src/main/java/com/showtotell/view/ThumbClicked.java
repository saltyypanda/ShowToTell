package com.showtotell.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ThumbClicked implements EventHandler<ActionEvent> {
    private ShowToTellGUI gui;
    private ThumbChanger changer;

    public ThumbClicked(ShowToTellGUI gui, ThumbChanger changer) {
        this.gui = gui;
        this.changer = changer;
    }

    @Override
    public void handle(ActionEvent event) {
        gui.thumbClicked(changer);
        System.out.println("it worked!");
    }
}
