package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, InstantiationException {

        Scanner scann = new Scanner(System.in);

        String[] input = scann.nextLine().split("_");

        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> ctor = clazz.getDeclaredConstructor();

        ctor.setAccessible(true);
        BlackBoxInt blackBoxInt = ctor.newInstance();


        while (!input[0].equals("END")) {

            String command = input[0];
            int value = Integer.parseInt(input[1]);

            Method method = clazz.getDeclaredMethod(command, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, value);

            Field field=clazz.getDeclaredField("innerValue");
            field.setAccessible(true);
            System.out.println(field.get(blackBoxInt));

            input = scann.nextLine().split("_");
        }
    }
}
