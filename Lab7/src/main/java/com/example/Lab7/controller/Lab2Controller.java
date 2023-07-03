package com.example.Lab7.controller;

import com.example.Lab2.person.MethodCaller;
import com.example.Lab2.person.Person;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.lang.reflect.InvocationTargetException;

public class Lab2Controller {

    @FXML
    private TextArea output;
    @FXML
    private void initialize() {
        Person Egor = new Person();
        MethodCaller method = new MethodCaller();
        try {
            method.callMyClassMethods(Egor, output);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
