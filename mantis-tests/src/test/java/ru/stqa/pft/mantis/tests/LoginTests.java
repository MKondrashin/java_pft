package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.mantis.appmanager.HttpSession;

import javax.xml.rpc.ServiceException;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Created by UserData on 17.12.2016.
 */
public class LoginTests extends TestBase {
    @Test
    public void testLogin() throws IOException, SkipException, ServiceException {
        skipIfNotFixed(5);
        HttpSession session = app.newSession();
        assertTrue(session.login("administrator","root"));
        assertTrue(session.isLoggedInAs("administrator"));
    }
}
