package pointRectangle;

public class Point {
    private int x;
    private int y;
    public  Point(int x,int y){
        this.x=x;
        this.y=y;
    }
    public boolean isInsideX(Point a,Point c){
        return x>=a.x&&x<=c.x;
    }
    public boolean isInsideY(Point a,Point c){
        return y>=a.y&&y<=c.y;
    }
   // public boolean isGreaterThanOrEqual(Point p) {
   //     return x >= p.x && y >= p.y;
   // }
//
   // public boolean isLessThanOrEqual(Point p) {
   //     return x <= p.x && y <= p.y;
   // }
}
