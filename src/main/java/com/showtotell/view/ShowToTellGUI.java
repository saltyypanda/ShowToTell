package com.showtotell.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ShowToTellGUI extends Application {
    private Button makeButton(Image image) {
        Button button = new Button();
        button.setBackground(new Background(new BackgroundImage(image,
                        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        button.setPadding(Insets.EMPTY);
        button.setPrefSize(500, 700);

        button.setOnAction(new WhenClicked());
        SquareChanger changer = new SquareChanger(view);
        game.getSquare(row, col).setOnChange(changer);
        return button;
    }


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
        Image one = new Image("file:resources/images/drinks/orangejuice.jpg");
        Image two = new Image("file:resources/images/drinks/soda.jpg");
        Image three = new Image("file:resources/images/drinks/tea.jpeg");
        Image four = new Image("file:resources/images/drinks/water.jpg");
        GridPane pane = makeImageCollage(one, two, three, four);

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
