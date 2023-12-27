package com.developersstack.wildlife.controller;

import com.developersstack.wildlife.db.Database;
import com.developersstack.wildlife.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SignupFormController {
    public TextField txtLastName;
    public TextField txtFirstName;
    public PasswordField txtPassword;
    public TextField txtEmail;
    public AnchorPane context;

    public void signUpOnAction(ActionEvent actionEvent) throws IOException {
        String email=txtEmail.getText().toLowerCase();
        String firstName=txtFirstName.getText();
        String lastName=txtLastName.getText();
        String password=txtPassword.getText().trim();
        Database.userTable.add(new User(firstName,lastName,email,password));
        new Alert(Alert.AlertType.INFORMATION,"welcome!").show();
        setUi("LoginForm");

    }

    public void alreadyHaveAnAccountOnAction(ActionEvent actionEvent)throws IOException {
        setUi("LoginForm");
    }
    private void setUi(String location) throws IOException {
        Stage stage= (Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();

    }
}
