package CCF;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created on 2020/4/19 0019
 * BY Jianlong
 */
public class TreePlant {

    private class Circle{
        int x;
        int y;
        int r;

        public Circle(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }

        @Override
        public String toString() {
            return "Circle{" +
                    "x=" + x +
                    ", y=" + y +
                    ", r=" + r +
                    '}';
        }
    }

    public boolean isIntersect(Circle c1, Circle c2){
        double distance = Math.sqrt(Math.pow(c1.x-c2.x, 2) + Math.pow(c1.y-c2.y, 2));
        if (distance >= c1.r + c2.r){
            return false;
        }
        else {
            return true;
        }
    }

    public int sumArea(List<Circle> circles){
        int sum = 0;
        for (Circle c : circles){
            sum += c.r * c.r;
        }

        return sum;
    }

    public void calArea(){
        int maxSum = 0;
        boolean hasIntersect;

        Scanner in = new Scanner(System.in);
        List<Circle> circles = new ArrayList<>();
        List<Circle> temp;
        int n = in.nextInt();

        for (int i=0; i<n; i++){
            circles.add(new Circle(in.nextInt(), in.nextInt(), in.nextInt()));
        }

        for (int i=0; i<circles.size(); i++){
            temp = new ArrayList<>();
            temp.add(circles.get(i));
            for (int j=i+1; j<circles.size(); j++){
                hasIntersect = false;
                Circle c1 = circles.get(j);
                for (Circle c2 : temp){
                    if (isIntersect(c1, c2)){
                        hasIntersect = true;
                    }
                }

                if (!hasIntersect){
                    temp.add(c1);
                }
            }

            if (sumArea(temp) > maxSum){
                maxSum = sumArea(temp);
            }
        }

        System.out.print(maxSum);
    }

    public static void main(String[] args) {
        TreePlant tp = new TreePlant();
        tp.calArea();
    }
}
