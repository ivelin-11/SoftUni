package shapes;



public class Circle extends Shape {
    private final Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public final Double getRadius() {
        return radius;
    }

    @Override
    protected void calculatePerimeter() {
        super.setPerimeter(2 * Math.PI * this.radius);
    }

    @Override
    protected void calculateArea() {
        super.setArea(Math.PI * this.radius * this.radius);
    }
}

