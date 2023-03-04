package com.showtotell.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ShowToTellGUI extends Application {
    private GridPane makeImageCollage(Image one, Image two, Image three, Image four) {
        ImageView viewOne = new ImageView(one);
        ImageView viewTwo = new ImageView(two);
        ImageView viewThree = new ImageView(three);
        ImageView viewFour = new ImageView(four);

        GridPane pane = new GridPane();
        pane.add(viewOne, 0, 0);
        pane.add(viewTwo, 0, 1);
        pane.add(viewThree, 1, 0);
        pane.add(viewFour, 1, 1);

        return pane;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Image one = new Image(null);
        GridPane pane = makeImageCollage(null, null, null, null);




        Label label = new Label("this is a label");
        //label.setBackground(new Background(new BackgroundImage(, null, null, null, null)));


        VBox box = new VBox(label);
        Scene scene = new Scene(box);
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}
