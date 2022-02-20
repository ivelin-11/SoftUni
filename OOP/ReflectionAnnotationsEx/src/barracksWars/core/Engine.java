package barracksWars.core;

import barracksWars.core.commands.Add;
import barracksWars.core.commands.Command;
import barracksWars.core.commands.Fight;
import barracksWars.core.commands.Report;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Runnable;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public class Engine implements Runnable {

    private static String COMMAND_PATH_NAMES = "barracksWars.core.commands.";
    private static String EXECUTE_METHOD_NAME = "execute";
    private Repository repository;
    private UnitFactory unitFactory;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = interpretCommand(data, commandName);
                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException | ExecutionControl.NotImplementedException e) {
                e.printStackTrace();
            }
        }
    }

    // TODO: refactor for problem 4
    private String interpretCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException {
        String result = "";

        try {
            String className=commandName.substring(0,1).toUpperCase()+commandName.substring(1);
            Class comamnd = Class.forName(COMMAND_PATH_NAMES + className);
            Constructor<Command> ctor = comamnd.getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class);
            Command commandInstance = ctor.newInstance(data, this.repository, this.unitFactory);
            Method executeMethod = comamnd.getDeclaredMethod(EXECUTE_METHOD_NAME);
            try{
                result = (String) executeMethod.invoke(commandInstance);
            }
           catch (InvocationTargetException e){
               System.out.print(e.getCause().getMessage());
           }
        } catch (ClassNotFoundException | NoSuchMethodException  | InvocationTargetException
        | InstantiationException |IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }


        return result;
    }


}
