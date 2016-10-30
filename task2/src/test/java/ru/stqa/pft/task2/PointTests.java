package ru.stqa.pft.task2;

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
        assert p1.getDistanceTo(p2) == 7;
    }

}
