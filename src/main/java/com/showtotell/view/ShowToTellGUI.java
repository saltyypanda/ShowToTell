package com.showtotell.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShowToTellGUI extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Label label = new Label("this is a label");
        VBox box = new VBox(label);
        Scene scene = new Scene(box);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
