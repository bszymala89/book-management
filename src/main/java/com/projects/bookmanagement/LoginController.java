package com.projects.bookmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    private static final String userDefaultName = "admin";
    private static final String userDefaultPass = "admin";
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button login;

    public void userLogin(ActionEvent event) {

    }

    public void checkLogin() {
        //Main m = new Main(); | to do add main class


        if (username.getText().toString().equals(userDefaultName) &&
            password.getText().toString().equals(userDefaultPass)) {

        }

    }
}
