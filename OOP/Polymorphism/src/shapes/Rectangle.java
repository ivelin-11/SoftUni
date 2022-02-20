package shapes;

public class Rectangle extends Shape {
    private  Double width;
    private  Double height;

    public Rectangle(Double width, Double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    protected void calculatePerimeter() {
        super.setPerimeter(this.width * 2 + this.height * 2);
    }

    @Override
    protected void calculateArea() {
        super.setArea(this.width * this.height);
    }

    public  Double getHeight() {
        return height;
    }

    public  Double getWidth() {
        return width;
    }
}