module com.showtotell {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.showtotell.view to javafx.fxml;
    exports com.showtotell.view;
}
