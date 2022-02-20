package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);

        Class<RichSoilLand> clazz = RichSoilLand.class;

        String input = scann.nextLine();
        while (!input.equals("HARVEST")) {

            switch (input) {
                case "public":
                    Arrays.stream(clazz.getDeclaredFields())
                            .filter(f -> Modifier.isPublic(f.getModifiers()))
                            .forEach(Main::printFieldInfo);
                    break;
                case "private":
                    Arrays.stream(clazz.getDeclaredFields())
                            .filter(f -> Modifier.isPrivate(f.getModifiers()))
                            .forEach(Main::printFieldInfo);
                    break;
                case "protected":
                    Arrays.stream(clazz.getDeclaredFields())
                            .filter(f -> Modifier.isProtected(f.getModifiers()))
                            .forEach(Main::printFieldInfo);
                    break;
                case "all":
                    Arrays.stream(clazz.getDeclaredFields())
                            .forEach(Main::printFieldInfo);
                    break;
            }


            input = scann.nextLine();
        }
    }

    public static void printFieldInfo(Field f) {
        System.out.printf("%s %s %s%n", Modifier.toString(f.getModifiers()), f.getType().getSimpleName(), f.getName());
    }
}
