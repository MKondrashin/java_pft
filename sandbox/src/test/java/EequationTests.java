import org.testng.Assert;
import ru.stqa.pft.sandbox.Equation;

/**
 * Created by User on 05.11.2016.
 */
public class EequationTests {
    @org.testng.annotations.Test
    public void test0()
    {
        Equation e = new Equation(1,1,1);
        Assert.assertEquals(e.rootNumber(),0);
    }

    @org.testng.annotations.Test
    public void test1()
    {
        Equation e = new Equation(1,2,1);
        Assert.assertEquals(e.rootNumber(),1);
    }

    @org.testng.annotations.Test
    public void test2()
    {
        Equation e = new Equation(1,5,6);
        Assert.assertEquals(e.rootNumber(),2);
    }

}
