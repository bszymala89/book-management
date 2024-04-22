module com.projects.bookmanagement {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.projects.bookmanagement to javafx.fxml;
    exports com.projects.bookmanagement;
}