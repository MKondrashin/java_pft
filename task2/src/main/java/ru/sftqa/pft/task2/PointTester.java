package main.java.ru.sftqa.pft.task2;

/**
 * Created by User on 22.10.2016.
 */
public class PointTester
{
    public static void main(String[] args)
    {
        Point p1 = new Point();
        Point p2 = new Point(3,4);
        print(p1,p2);
        print(p2,p1);
        p1 = new Point(19390812038.0, 39823982839281938.0);
        p2 = new Point(-19390812038.0, -39823982839281938.0);
        print(p1,p2);
        print(p2,p1);
        p1 = new Point(1e-250, 0);
        p2 = new Point(100000000000.0, 0);
        print(p1,p2);
        print(p2,p1);
        p1 = new Point(Double.MAX_VALUE, 0);
        p2 = new Point(Double.MIN_VALUE, 0);
        print(p1,p2);
        print(p2,p1);
        p1 = new Point(Double.NEGATIVE_INFINITY, 0);
        p2 = new Point(Double.POSITIVE_INFINITY, 0);
        print(p1,p2);
        print(p2,p1);
    }

    public static double getDistance(Point p1, Point p2)
    {
        return p1.getDistanceTo(p2);
    }

    public static void print(Point p1, Point p2)
    {
        System.out.println("distance between " + p1.toString() + " and " + p2.toString() + " = " + Double.toString(getDistance(p1,p2)) );
    }



}
