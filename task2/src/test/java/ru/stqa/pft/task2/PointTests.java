package ru.stqa.pft.task2;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sftqa.pft.task2.Point;

/**
 * Created by User on 30.10.2016.
 */
public class PointTests {
    @Test(testName = "t1")
    void testDistanceSmall() {
        Point p1 = new Point(0, 3);
        Point p2 = new Point(4, 0);

        Assert.assertEquals(p1.getDistanceTo(p2), 5.0);
    }

    @Test(testName = "t2")
    void testDistanceSymmetry() {
        Point p1 = new Point(0, 3);
        Point p2 = new Point(4, 0);

        Assert.assertEquals(p1.getDistanceTo(p2), p2.getDistanceTo(p1));
    }

    @Test
    void testDisntanceZero() {
        Point p1 = new Point(0, 3);

        Assert.assertEquals(p1.getDistanceTo(p1), 0.0);
    }

    @Test
    void testDisntanceMaxValues() {
        Point p1 = new Point(Double.MAX_VALUE, 0);
        Point p2 = new Point(Double.MIN_VALUE, 0);

        Assert.assertEquals(p1.getDistanceTo(p2), Double.POSITIVE_INFINITY);
    }

    @Test
    void testDisntanceBig() {
        Point p1 = new Point(19390812038.0, 39823982839281938.0);
        Point p2 = new Point(-19390812038.0, -39823982839281938.0);

        Assert.assertEquals(p1.getDistanceTo(p2), 7.9647965678573328E16);
    }
}