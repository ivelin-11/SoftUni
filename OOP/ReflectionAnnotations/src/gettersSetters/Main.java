package gettersSetters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;

        Arrays.stream(clazz.getDeclaredMethods()).
                filter(m -> m.getName().startsWith("get"))
                .sorted(Comparator.comparing(Method::getName)).forEach(Main::messageOutput);

        Arrays.stream(clazz.getDeclaredMethods()).
                filter(m -> m.getName().startsWith("set")).sorted(Comparator.comparing(Method::getName)).forEach(Main::messageOutput);

    }
    private static void messageOutput(Method m){
        if(m.getName().startsWith("get")){
            System.out.println(String.format("%s will return class %s",m.getName(),m.getReturnType().getName()));
        }
        else if(m.getName().startsWith("set")){
            System.out.println(String.format("%s and will set field of class %s",m.getName(),m.getParameterTypes()[0].getName()));
        }
    }
}
