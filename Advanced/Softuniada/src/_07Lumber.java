import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _07Lumber {

   static class Point{
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x,y;
    }
    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);

        int[] input = Arrays.stream(scann.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();


        List<List<Integer>> rectangles = new ArrayList<>();


        for (int i = 0; i < input[0]; i++) {
            rectangles.add(Arrays.stream(scann.nextLine().split("\\s+")).
                    map(Integer::parseInt).collect(Collectors.toList()));
        }

        for (int i = 0; i < input[1]; i++) {
            List<Integer> rectanglesToCheck = Arrays.stream(scann.nextLine().split("\\s+")).
                    map(Integer::parseInt).collect(Collectors.toList());

            List<Integer> rec1 = rectangles.get(rectanglesToCheck.get(0)-1);
            List<Integer> rec2 = rectangles.get(rectanglesToCheck.get(1)- 1);


            Point l1=new Point(rec2.get(0),rec2.get(1));
            Point r1=new Point(rec2.get(2),rec2.get(3));
            Point l2=new Point(rec1.get(0),rec1.get(1));
            Point r2=new Point(rec1.get(2),rec1.get(3));
            if (doOverlap(l1,r1,l2,r2) ){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static  boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {

        // To check if either rectangle is actually a line
        // For example :  l1 ={-1,0}  r1={1,1}  l2={0,-1}  r2={0,1}

        if (l1.x == r1.x || l1.y == r1.y || l2.x == r2.x || l2.y == r2.y)
        {
            // the line cannot have positive overlap
            return false;
        }


        // If one rectangle is on left side of other
        if (l1.x > r2.x || l2.x > r1.x) {
            return false;
        }

        // If one rectangle is above other
        if (r1.y > l2.y || r2.y > l1.y) {
            return false;
        }

        return true;
    }
}
