module com.showtotell {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.showtotell to javafx.fxml;
    exports com.showtotell;
}
