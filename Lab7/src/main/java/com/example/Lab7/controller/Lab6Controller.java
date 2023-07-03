package com.example.Lab7.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.Random;
import com.example.Lab6.ProcessState;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class Lab6Controller {

    @FXML
    private TextArea output;

    private static ProcessState processState = ProcessState.RUNNING;
    private static final Object mutex = new Object();
    private Thread abstractProgram = new Thread(new Lab6Controller.AbstractProgram());

    private class AbstractProgram implements Runnable {

        @Override
        public void run() {
            Thread daemonThread = new Thread(() -> {
                while (true) {
                    //приостановка выполнения текущего потока на случайное
                    // количество времени, не превышающее 3 секунд
                    try {
                        Thread.sleep(new Random().nextInt(3000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (abstractProgram.isInterrupted()) {
                        break;
                    }
                    synchronized (mutex) {
                        processState = ProcessState.values()[new Random().nextInt(ProcessState.values().length)];
                        output.appendText("Daemon changed program state to " + processState + "\n");
                        mutex.notify();
                    }
                }
            });
            daemonThread.setDaemon(true); //поток не будет препятствовать выходу JVM после завершения программы
            daemonThread.start();
            output.appendText("Abstract program running and started the daemon thread\n");

        }
    }

    private class Supervisor implements Runnable {

        @Override
        public void run() {
            try {
                output.appendText("Supervisor is working\n");
                abstractProgram.start();
                while (!abstractProgram.isInterrupted()) {
                    synchronized (mutex) {
                        mutex.wait();
                        switch (processState) {
                            case FATAL_ERROR:
                                abstractProgram.interrupt();
                                output.appendText("Supervisor stopped the program\n");
                                break;
                            case STOPPING, UNKNOWN:
                                processState = ProcessState.RUNNING;
                                output.appendText("Supervisor restarted the program\n");
                                break;
                            case RUNNING:
                                output.appendText("Supervisor did nothing\n");
                                break;
                        }
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    private void initialize() {
        new Thread(new Lab6Controller.Supervisor()).start();
    }
}
