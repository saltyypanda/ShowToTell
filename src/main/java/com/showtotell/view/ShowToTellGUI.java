package com.showtotell.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ShowToTellGUI extends Application {
    private GridPane makeImageCollage(Image one, Image two, Image three, Image four) {
        ImageView viewOne = new ImageView(one);
        ImageView viewTwo = new ImageView(two);
        ImageView viewThree = new ImageView(three);
        ImageView viewFour = new ImageView(four);

        viewOne.setFitHeight(400);
        viewOne.setFitWidth(400);
        viewTwo.setFitHeight(400);
        viewTwo.setFitWidth(400);
        viewThree.setFitHeight(400);
        viewThree.setFitWidth(400);
        viewFour.setFitHeight(400);
        viewFour.setFitWidth(400);

        GridPane pane = new GridPane();
        pane.add(viewOne, 0, 0);
        pane.add(viewTwo, 0, 1);
        pane.add(viewThree, 1, 0);
        pane.add(viewFour, 1, 1);

        return pane;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Image one = new Image("file:resources/images/bananas.jpg");
        Image two = new Image("file:resources/images/burger.jpg");
        Image three = new Image("file:resources/images/pancakes.jpg");
        Image four = new Image("file:resources/images/pasta.jpg");
        GridPane pane = makeImageCollage(one, two, three, four);

        Button button = 

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}
