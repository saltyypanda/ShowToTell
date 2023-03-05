module main.java.com.showtotell {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.showtotell.view to javafx.fxml;
    exports com.showtotell.view;
}
