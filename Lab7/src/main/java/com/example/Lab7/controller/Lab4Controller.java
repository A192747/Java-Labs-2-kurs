package com.example.Lab7.controller;

import com.example.Lab4.Exceptions.FileReadException;
import com.example.Lab4.Exceptions.InvalidFileFormatException;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import com.example.Lab4.Translator.*;
public class Lab4Controller {

    @FXML
    private TextArea output;

    @FXML
    private void initialize() {
        try {
            Translator translator = new Translator("src/main/resources/com/example/lab7/Lab4Files/dictionary.txt");
            String translatedFile = translator.translateFile("src/main/resources/com/example/lab7/Lab4Files/input.txt");
            output.appendText(translatedFile);
        } catch (InvalidFileFormatException | FileReadException e) {
            output.appendText(e.toString());
        }
    }

}
