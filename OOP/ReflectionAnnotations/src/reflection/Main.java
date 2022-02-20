package reflection;


import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;


        try {
            System.out.println("class "+clazz.getSimpleName());
            System.out.println(clazz.getSuperclass());

            Class<?>[] interfaces = clazz.getInterfaces();
            Arrays.stream(interfaces).forEach(System.out::println);


            Reflection ref = clazz.getDeclaredConstructor().newInstance();
            System.out.println(ref);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
