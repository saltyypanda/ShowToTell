package com.showtotell.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShowToTellGUI extends Application {
    private Button makeButton(String filename) {
        Image image = new Image(filename);
        Button button = new Button();
        button.setBackground(new Background(new BackgroundImage(image,
                        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        button.setPadding(Insets.EMPTY);
        button.setPrefSize(500, 500);

        button.setOnAction(new WhenClicked(filename));
        return button;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button = makeButton("file:resources/images/food/foodcollage.png");
        
        VBox box = new VBox();
        box.getChildren().add(button);

        Scene scene = new Scene(box);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}
