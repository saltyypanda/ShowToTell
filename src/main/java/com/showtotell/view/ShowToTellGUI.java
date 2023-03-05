package com.showtotell.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ShowToTellGUI extends Application {
    private Button makeImageButton(String filename) {
        Image image = new Image(filename);
        Button button = new Button();
        button.setPadding(new Insets(30, 30, 30, 30));
        button.setPrefSize(500, 500);

        ImageView view = new ImageView(image);
        view.setFitHeight(500);
        view.setFitWidth(500);

        button.setGraphic(view);
        ImageChanger changer = new ImageChanger(view);
        button.setOnAction(new PictureClicked(this, filename, changer));
        return button;
    }
    
    private Button makeWordButton(String word) {
        Button button = new Button();
        button.setText(word);
        button.setFont(new Font(100));
        button.setBackground(new Background(new BackgroundFill(Color.MISTYROSE, null, null)));
        button.setPadding(new Insets(30, 50, 20, 50));

        return button;
    }

    private Button makeThumbButton(String filename, HBox box, boolean bool) {
        Image image = new Image(filename);
        Button button = new Button();
        button.setBackground(new Background(new BackgroundFill(Color.MISTYROSE, null, null)));
        button.setPadding(new Insets(30, 50, 0, 50));
        button.setPrefSize(70, 70);

        ImageView view = new ImageView(image);
        view.setFitHeight(70);
        view.setFitWidth(70);

        button.setGraphic(view);
        ThumbChanger changer = new ThumbChanger(box);
        button.setOnAction(new ThumbClicked(this, changer, bool));
        return button;
    }

    public HBox makeThumbBox() {
        HBox hbox = new HBox();

        Button thumbsUp = makeThumbButton("file:resources/images/thumbs/thumbsup.png", hbox, true);
        Button thumbsDown = makeThumbButton("file:resources/images/thumbs/thumbsdown.png", hbox, false);

        hbox.getChildren().add(thumbsUp);
        hbox.getChildren().add(thumbsDown);
        hbox.setAlignment(Pos.TOP_CENTER);

        return hbox;
    }

    public void pictureClicked(String filename, ImageChanger changer) {
        
    }

    public void thumbClicked(ThumbChanger changer, boolean bool) {
        changer.thumbChanged(this, bool);
    }

    public void returnToRoot() { // when finding does not work, go back to beginning

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane bp = new BorderPane();
        Button button = makeImageButton("file:resources/images/food/foodcollage.png");
        
        HBox hbox = makeThumbBox();

        Button word = makeWordButton("Food");

        VBox vbox = new VBox();
        vbox.getChildren().add(word);
        vbox.getChildren().add(button);
        vbox.getChildren().add(hbox);
        vbox.setAlignment(Pos.CENTER);


        bp.setCenter(vbox);
        bp.setBackground(new Background(new BackgroundFill(Color.MISTYROSE, null, null)));

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