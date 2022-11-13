package com.seekerscloud.pos.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.seekerscloud.pos.db.Database;
import com.seekerscloud.pos.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpFormController {
    public JFXTextField txtEmail;
    public JFXPasswordField txtPassword;
    public JFXTextField txtFullName;
    public JFXPasswordField txtContact;
    public JFXPasswordField txtRePassword;
    public AnchorPane signUpFormContext;

    public void signUpOnAction(ActionEvent actionEvent) throws InterruptedException, IOException {
        //check password match

        String realPwd = txtPassword.getText().trim();
        String matchPwd = txtRePassword.getText().trim();
        if (!realPwd.equals(matchPwd)) {
            new Alert(Alert.AlertType.WARNING, "Both passwords should match").show();
            return;//we will stop the JVM
        }
        User u = new User(txtEmail.getText().trim(), txtFullName.getText(), txtContact.getText(), realPwd);

        if (saveUser(u)) {
            new Alert(Alert.AlertType.CONFIRMATION, "User Registered!").show();
            clearFields();
            Thread.sleep(2000);//wait 2 seconds
            setUi("DashBoardForm",u.getEmail());
        } else {
            new Alert(Alert.AlertType.WARNING, "Already Exists!,Try Again!").show();
        }

    }

    private void clearFields() {
        txtEmail.clear();
        txtFullName.clear();
        txtContact.clear();
        txtPassword.clear();
        txtRePassword.clear();
    }

    private boolean saveUser(User u) {
        for (User tempUser: Database.userTable){
            if (tempUser.getEmail().equals(u.getEmail())){
                return false;
            }
        }
        return Database.userTable.add(u);//inbuilt method ==> java.util

    }

    private void setUi(String location,String title) throws IOException {
        Stage window = (Stage) signUpFormContext.getScene().getWindow();
        window.setTitle(title);
        window.setScene(
                new Scene(FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml")))
        );
    }

    public void alreadyHaveAnAccountOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoginForm","Login Form");
    }
}