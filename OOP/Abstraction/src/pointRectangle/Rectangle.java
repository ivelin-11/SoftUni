package pointRectangle;

public class Rectangle {
    private Point pointA;
    private Point pointC;

    public Rectangle(Point pointA,Point pointC){
        this.pointA=pointA;
        this.pointC =pointC;
    }

public boolean contains(Point p){

        return p.isInsideX(pointA,pointC)&&p.isInsideY(pointA,pointC);
}
}
