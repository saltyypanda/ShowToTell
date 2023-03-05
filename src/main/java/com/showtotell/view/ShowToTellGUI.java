package com.showtotell.view;

import com.showtotell.model.App;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ShowToTellGUI extends Application {
    private App app;
    private Image mainImage;
    private ImageChanger changer;
    private WordChanger wordChanger;

    public ImageChanger getChanger() {
        return changer;
    }

    public WordChanger getWordChanger() {
        return wordChanger;
    }

    private Button makeImageButton(String name) {
        String filename = "file:resources/images/" + name + "/" + name + "collage.png";
        this.mainImage = new Image(filename);
        Button button = new Button();
        button.setPadding(new Insets(30, 30, 30, 30));
        button.setPrefSize(500, 500);

        ImageView view = new ImageView(mainImage);
        view.setFitHeight(500);
        view.setFitWidth(500);

        button.setGraphic(view);
        Text text = new Text(name);
        this.changer = new ImageChanger(button, text);
        button.setOnAction(new PictureClicked(this, text, changer));
        return button;
    }
    
    private Button makeWordButton(String word) {
        Button button = new Button();
        button.setText(word);
        button.setFont(new Font(100));
        button.setBackground(new Background(new BackgroundFill(Color.MISTYROSE, null, null)));
        button.setPadding(new Insets(30, 50, 20, 50));

        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        button.setPrefSize(primaryScreenBounds.getWidth(), 100);

        this.wordChanger = new WordChanger(button);

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
        ThumbChanger changer = new ThumbChanger(this.app, box);
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

    public void pictureClicked(Text text, ImageChanger changer) {
        app.pictureClicked(text, changer);
    }

    public void thumbClicked(ThumbChanger changer, boolean bool) {
        changer.thumbChanged(bool);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.app = new App(this, "resources/lists/categories.txt");

        BorderPane bp = new BorderPane();
        Button button = makeImageButton("food");
        
        HBox hbox = makeThumbBox();

        Button word = makeWordButton(app.getMain().get(0).getName());

        VBox vbox = new VBox();
        vbox.getChildren().add(word);
        vbox.getChildren().add(button);
        vbox.getChildren().add(hbox);
        vbox.setAlignment(Pos.CENTER);


        bp.setCenter(vbox);
        bp.setBackground(new Background(new BackgroundFill(Color.MISTYROSE, null, null)));

        Button check = new Button("file:resources/images/button/check.png");
        check.setMinSize(20,20);
        check.setMaxSize(20,20);
        bp.setBottom(check);
    

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