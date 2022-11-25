package com.seekerscloud.pos.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DashBoardFormController {

    public Label lblDate;
    public Label lblTime;
    public AnchorPane dashboardContext;

    public void initialize(){
        setDateAndTime();
    }

    private void setDateAndTime() {
        //set Date
      /*  Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String formattedDate = dateFormat.format(date);
        lblDate.setText(formattedDate);*/

        lblDate.setText(new SimpleDateFormat("YYYY-MM-dd").format(new Date()));

        //set Time
        final DateFormat format=DateFormat.getDateInstance();
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO,e->{
           /* Calendar cal = Calendar.getInstance();
            lblTime.setText(format.format(cal.getTime()));*/

            lblTime.setText(LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("HH:mm:ss")
            ));
        }),new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void openCustomerFormOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("CustomerForm","Customer Form");
    }

    public void openOrderDetailsOnAction(MouseEvent mouseEvent) {
    }

    public void openPlaceOrderFormOnAction(MouseEvent mouseEvent) {
    }

    public void openProductManagementOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("ProductForm", "Dashboard");
    }

    public void openStatisticsOnAction(MouseEvent mouseEvent) {
    }

    private void setUi(String location,String title) throws IOException {
        Stage window = (Stage) dashboardContext.getScene().getWindow();
        window.setTitle(title);
        window.setScene(
                new Scene(FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml")))
        );
    }
}
