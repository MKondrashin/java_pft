package ru.stqa.pft.task2;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sftqa.pft.task2.Point;

/**
 * Created by User on 30.10.2016.
 */
public class PointTests {
    @Test()
    void testDistance()
    {
        Point p1 = new Point(0,3);
        Point p2 = new Point(4,0);
        //assert p1.getDistanceTo(p2) == 7;
        Assert.assertEquals(p1.getDistanceTo(p2) , 5.0);
        Assert.assertEquals(p1.getDistanceTo(p2) , p2.getDistanceTo(p1));
        Assert.assertEquals(p1.getDistanceTo(p1) , 0.0);

        p1 = new Point(Double.MAX_VALUE, 0);
        p2 = new Point(Double.MIN_VALUE, 0);

        Assert.assertEquals(p1.getDistanceTo(p2) , Double.POSITIVE_INFINITY);

        p1 = new Point(19390812038.0, 39823982839281938.0);
        p2 = new Point(-19390812038.0, -39823982839281938.0);

        Assert.assertEquals(p1.getDistanceTo(p2) , 7.9647965678573328E16);
    }

}
