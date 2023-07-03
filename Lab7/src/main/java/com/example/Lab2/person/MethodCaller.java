package com.example.Lab2.person;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import com.example.Lab2.annotation.MyAnnotation;
import javafx.scene.control.TextArea;

public class MethodCaller {
    public void callMyClassMethods(Object object, TextArea output) throws InvocationTargetException, IllegalAccessException {
        Class<? extends Object> c = object.getClass();
        for (Method method:c.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                output.appendText("***************************\n");
                output.appendText("*** Annotation value: " + method.getAnnotation(MyAnnotation.class).value() + " ***\n");
                output.appendText("***************************\n");
                for (int i = 0; i < method.getAnnotation(MyAnnotation.class).value(); i++) {
                    method.setAccessible(true);
                    method.invoke(object, "1", output);
                }
            }
        }
    }
}

