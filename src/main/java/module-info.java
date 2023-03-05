module main.java.com.showtotell {
    requires transitive javafx.graphics;
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.media;
    requires transitive javafx.base;

    opens com.showtotell.view to javafx.fxml;
    exports com.showtotell.view;
}
