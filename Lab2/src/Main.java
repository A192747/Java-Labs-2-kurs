import person.*;
import java.lang.reflect.InvocationTargetException;
    public class Main {
    public static void main(String[] args) {

        Person Egor = new Person();
        MethodCaller method = new MethodCaller();
        try {
            method.callMyClassMethods(Egor);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}