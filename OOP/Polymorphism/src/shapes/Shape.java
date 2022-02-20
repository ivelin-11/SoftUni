package shapes;

public abstract class Shape {
    private Double area;
    private Double perimeter;

    protected abstract void calculatePerimeter();
    protected abstract void calculateArea();


    protected void setArea(Double area) {
        this.area = area;
    }

    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    public Double getPerimeter() {

        return perimeter;
    }

    public Double getArea() {

        return area;
    }
}

