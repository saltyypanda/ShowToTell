package com.showtotell.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class WordClicked implements EventHandler<ActionEvent> {
    private String filename;

    public WordClicked(String filename) {
        this.filename = filename;
    }

    @Override
    public void handle(ActionEvent event) {
        System.out.println("it worked");
        MediaPlayer player = new MediaPlayer(new Media(filename));
        player.play();
        player.stop();
    }
}
