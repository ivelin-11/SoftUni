package Serialiazable;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Cube cube = new Cube();
        cube.setColor("Green");
        cube.setWidth(15.3);
        cube.setHeight(12.4);
        cube.setDepth(3);

        String path = "src\\Serialiazable\\out-ser.txt";

        FileOutputStream outputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(cube);

        FileInputStream inputStream=new FileInputStream(path);
        ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);

        Object cube2=(Cube)objectInputStream.readObject();

    }
}
