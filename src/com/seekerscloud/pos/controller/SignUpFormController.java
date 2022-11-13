package com.seekerscloud.pos.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.seekerscloud.pos.db.Database;
import com.seekerscloud.pos.model.User;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

public class SignUpFormController {
    public JFXTextField txtEmail;
    public JFXPasswordField txtPassword;
    public JFXTextField txtFullName;
    public JFXPasswordField txtContact;
    public JFXPasswordField txtRePassword;

    public void signUpOnAction(ActionEvent actionEvent) {
        //check password match

        String realPwd=txtPassword.getText().trim();
        String matchPwd=txtRePassword.getText().trim();
        if(!realPwd.equals(matchPwd))
        {
            new Alert(Alert.AlertType.WARNING,"Both passwords should match").show();
            return;//we will stop the JVM
        }
        User u = new User(txtEmail.getText().trim(),txtFullName.getText(),txtContact.getText(),realPwd);

        if(saveUser(u)){
            new Alert(Alert.AlertType.CONFIRMATION,"User Registered!").show();
            clearFields();
        }

        else{
            new Alert(Alert.AlertType.WARNING,"Try Again!").show();
        }

    }
    private void clearFields()
    {
        txtEmail.clear();
        txtFullName.clear();
        txtContact.clear();
        txtPassword.clear();
        txtRePassword.clear();
    }

    private boolean saveUser(User u){
        return Database.userTable.add(u);//inbuilt method ==> java.util

    }
}
