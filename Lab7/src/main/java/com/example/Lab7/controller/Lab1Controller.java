package com.example.Lab7.controller;

import com.example.Lab1.hero.Hero;
import com.example.Lab1.move.Flying;
import com.example.Lab1.move.RideOnHorse;
import com.example.Lab1.move.Walk;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Lab1Controller {

    @FXML
    private TextField input;

    @FXML
    private TextArea output;

    @FXML
    private Button readInputButton;

    private int num = -1;
    private boolean isFinished = false;
    private static Object mutex = new Object();

    private class Program implements Runnable{
        Hero hero;
        Program(Hero hero_){
            hero = hero_;
        }
        public void run() {
            try{
                while (num != 3) {
                    if (num >= 0 && num <= 2) {
                        switch (num) {
                            case 0 -> hero.setMoveStrategy(new Walk());
                            case 1 -> hero.setMoveStrategy(new RideOnHorse());
                            case 2 -> hero.setMoveStrategy(new Flying());
                        }
                        output.appendText(hero.move()+"\n");
                    } else {
                        output.appendText("Введите число от 0 до 3\n");
                    }
                    synchronized (mutex) {
                            mutex.wait();
                    }
                    Thread.sleep(100);
                }
                output.appendText("Программа завершила свою работу!\n");
                isFinished = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    private void initialize() {
        Hero hero = new Hero();
        new Thread(new Program(hero)).start();
        readInputButton.setOnAction(event -> {
            if(!isFinished) {
                String text = input.getText();
                if (text.matches("[0-9]+")) {
                    synchronized (mutex) {
                        num = Integer.parseInt(text);
                        mutex.notify();
                    }
                } else {
                    output.appendText("Введите число\n");
                }
                input.clear();
            }
        });

    }
}
