package com.example.Lab7.controller;

import com.example.Lab7.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class MainController {

    @FXML
    private Button selectLab1;

    @FXML
    private Button selectLab2;

    @FXML
    private Button selectLab3;

    @FXML
    private Button selectLab4;

    @FXML
    private Button selectLab5;

    @FXML
    private Button selectLab6;

    @FXML
    void showLab1Window(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Lab1Window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 519, 375);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Lab1");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.showAndWait();
    }

    @FXML
    void showLab2Window(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Lab2Window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 339, 471);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Lab2");
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    @FXML
    void showLab3Window(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Lab3Window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 367, 365);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Lab3");
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    @FXML
    void showLab4Window(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Lab4Window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 365);
        Stage stage = new Stage();
        stage.setMinHeight(365);
        stage.setMinWidth(500);
        stage.setScene(scene);
        stage.setTitle("Lab4");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    @FXML
    void showLab5Window(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Lab5Window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 367, 365);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Lab5");
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    @FXML
    void showLab6Window(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Lab6Window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 367, 365);
        Stage stage = new Stage();
        stage.setMinHeight(365);
        stage.setMinWidth(367);
        stage.setScene(scene);
        stage.setTitle("Lab6");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

}