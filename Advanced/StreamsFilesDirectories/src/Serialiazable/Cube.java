package Serialiazable;

import java.io.Serializable;

public class Cube implements Serializable {

    private String color;
    private double width;
    private double height;
    private double depth;

    public Cube() {
        this.color = "";
        this.width = 0;
        this.height = 0;
        this.depth = 0;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }
}
