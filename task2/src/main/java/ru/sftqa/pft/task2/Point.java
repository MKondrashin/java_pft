package main.java.ru.sftqa.pft.task2;

/**
 * Created by User on 22.10.2016.
 */

@SuppressWarnings("Unused")
public class Point
{
    private double x;
    private double y;
    private static final double eps = 1e-27;

    public Point()
    {
        this.setX(0);
        this.setY(0);
    }

    public Point(double x, double y)
    {
        this.setX(x);
        this.setY(y);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getDistanceTo(Point p)
    {
        double xLength = p.x - this.x;
        double yLength = p.y - this.y;
        return Math.sqrt(xLength*xLength + yLength*yLength);
    }

    public String toString()
    {
        return "(" + Double.toString(this.x) + " , " + Double.toString(this.y) + ")";
    }

}
