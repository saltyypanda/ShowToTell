package com.showtotell.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ThumbClicked implements EventHandler<ActionEvent> {
    private ShowToTellGUI gui;
    private ThumbChanger changer;
    private boolean correct;

    public ThumbClicked(ShowToTellGUI gui, ThumbChanger changer, boolean correct) {
        this.gui = gui;
        this.changer = changer;
        this.correct = correct;
    }

    @Override
    public void handle(ActionEvent event) {
        gui.thumbClicked(changer, correct);
        System.out.println("it worked!");
    }
}
