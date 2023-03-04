package com.showtotell.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ShowToTellGUI extends Application {
    private Button makeButton(String filename) {
        Image image = new Image(filename);
        Button button = new Button();
        button.setPadding(Insets.EMPTY);
        button.setPrefSize(500, 500);

        ImageView view = new ImageView(image);
        view.setFitHeight(500);
        view.setFitWidth(500);

        button.setGraphic(view);
        ImageChanger changer = new ImageChanger(view);
        button.setOnAction(new WhenClicked(this, filename, changer));
        return button;
    }

    public void whenClicked(String filename, ImageChanger changer) {
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane bp = new BorderPane();
        Button button = makeButton("file:resources/images/food/foodcollage.png");
        
        VBox box = new VBox();
        box.getChildren().add(button);
        box.setAlignment(Pos.CENTER);
        bp.setCenter(box);

        Scene scene = new Scene(bp);
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}