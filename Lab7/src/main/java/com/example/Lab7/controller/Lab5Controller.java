package com.example.Lab7.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import com.example.Lab5.Methods.*;

public class Lab5Controller {

    @FXML
    private TextArea output;
    @FXML
    private void initialize() {
        output.appendText("Method - 1\n");
        List<Integer> list1 = List.of(2, 5, 6, 1);
        output.appendText(Methods.average(list1)+"\n\n");

        output.appendText("Method - 2\n");
        List<String> list2 = List.of("AaaA", "Bbbb", "cccc", "DDDd");
        output.appendText(Methods.strToUpperNew(list2)+"\n\n");

        output.appendText("Method - 3\n");
        List<Integer> list3 = List.of(1, 2, 3, 1, 5, 4, 9, 4);
        output.appendText(Methods.uniqSquares(list3)+"\n\n");

        output.appendText("Method - 4\n");
        List<String> list4 = List.of("abcdefg", "cdef", "azwxy", "abcdefg", "cdef", "afffzwxy", "abcdefasdhhg");
        output.appendText(Methods.firstLetterStrSort(list4, 'a') + "\n\n");

        output.appendText("Method - 5\n");
        List<Integer> list5 = List.of(1861, 1865, 888, 78498, 5);
        List<String> emptyList = new ArrayList<>();
        try {
            output.appendText(Methods.lastElement(list5)+"\n");
            output.appendText(Methods.lastElement(emptyList)+"\n");
        } catch (NoSuchElementException e) {
            output.appendText(e.getMessage()+"\n");
        }
        output.appendText("\n");

        output.appendText("Method - 6\n");
        int[] arrayFirst = {1, 2, 3, 4, 5};
        output.appendText(Methods.numsEven(arrayFirst)+"\n");
        arrayFirst = new int[]{1, 3, 5};
        output.appendText(Methods.numsEven(arrayFirst)+"\n\n");

        output.appendText("Method - 7\n");
        List<String> list7 = List.of("Abcdefg", "qwerty", "asdfghkj");
        output.appendText(Methods.stringToMap(list7)+"\n");
    }
}
