module main.java.com.showtotell {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens com.showtotell.view to javafx.fxml;
    exports com.showtotell.view;
}
