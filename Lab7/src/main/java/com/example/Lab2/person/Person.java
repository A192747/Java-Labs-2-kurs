package com.example.Lab2.person;

import com.example.Lab2.annotation.MyAnnotation;
import javafx.scene.control.TextArea;

public class Person {

        @MyAnnotation(value = 1)
        public void getName(String name, TextArea output){
            output.appendText("public void getName, argument value:" + name + "\n");
        }
        @MyAnnotation(value = 2)
        public void getWeight(String weight, TextArea output){
            output.appendText("public void getWeight, argument value: " + weight + "\n");
        }
        @MyAnnotation(value = 3)
        private void getAddress(String address, TextArea output){
            output.appendText("private void getAddress, argument value: " + address + "\n");
        }

        @MyAnnotation(value = 4)
        private void getAge(String age, TextArea output){
            output.appendText("private void getAge, argument value: " + age + "\n");
        }

        @MyAnnotation(value = 5)
        protected void getPhone(String phone, TextArea output){
            output.appendText("protected void getPhone, argument value: " + phone + "\n");
        }

        @MyAnnotation(value = 6)
        protected void getSurname(String surname, TextArea output){
            output.appendText("protected void getSurname, argument value: " + surname + "\n");
        }


}
