package codingTracker;


import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;


public class Tracker {

    @Author (name="Peter")
    public static void printMethodsByAuthor(Class<?> cl){
        Arrays.stream(cl.getDeclaredMethods())
                .filter(m -> m.getAnnotation(Author.class) != null)
                .map(m -> m.getAnnotation(Author.class))
                .forEach(a->
                        System.out.println("Method autor is "+a.name()));
    }
}
