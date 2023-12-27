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

public class LoginFormController {
    public PasswordField txtPassword;
    public AnchorPane context;
    public TextField txtEmail;

    public void loginOnAction(ActionEvent actionEvent) {
        String email=txtEmail.getText().toLowerCase();
        String password=txtPassword.getText().trim();
        for(User user: Database.userTable){
            if (user.getEmail().equals(email)){
                if(user.getPassword().equals(password)){
                    System.out.println(user.toString());
                    return;
                }else {
                    new Alert(Alert.AlertType.ERROR,"wrong password").show();
                    return;

                }

            }

        }
        new Alert(Alert.AlertType.WARNING,String.format("user not found(%s),email")).show();

    }

    public void createAnAccountOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SignupForm");
    }

    public void frogotPasswordOnAction(ActionEvent actionEvent) {
    }
    private void setUi(String location) throws IOException{
        Stage stage= (Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }
}
