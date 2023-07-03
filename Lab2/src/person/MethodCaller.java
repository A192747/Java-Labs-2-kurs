package person;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import annotation.MyAnnotation;
public class MethodCaller {
    public void callMyClassMethods(Object object) throws InvocationTargetException, IllegalAccessException {
        Class<? extends Object> c = object.getClass();
        for (Method method:c.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                System.out.println("***************************");
                System.out.println("*** Annotation value: " + method.getAnnotation(MyAnnotation.class).value() + " ***");
                System.out.println("***************************");
                for (int i = 0; i < method.getAnnotation(MyAnnotation.class).value(); i++) {
                    method.setAccessible(true);
                    method.invoke(object, "1");
                }
            }
        }
    }
}

