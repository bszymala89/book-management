module com.projects.bookmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens com.projects.bookmanagement to javafx.fxml;
    exports com.projects.bookmanagement;
}