package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.Users;
import ru.stqa.pft.mantis.model.UserData;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by User on 18.12.2016.
 */
public class ChangePasswordTests extends TestBase {

    @BeforeMethod
    public void startMailServer()
    {
        app.mail().start();
    }

    @Test
    public void testChangePassword() throws IOException, InterruptedException {

        String newPassword = String.format("password%s", System.currentTimeMillis());
        UserData user = app.db().users().stream().filter(u-> !u.getUsername().equals("administrator")).iterator().next();
        app.getSessionHelper().login("administrator", "root");
        app.goTo().managePage();
        app.goTo().manageUsersPage();
        app.user().openUserDetailsOnManageUsersPage(user);
        app.user().initResetPassword();
        List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
        String changePasswordLink = findConfirmationLink(mailMessages, user.getEmail());
        app.user().changePassword(changePasswordLink, newPassword);
        Thread.sleep(1000);
        assertTrue(app.newSession().login(user.getUsername(), newPassword));
    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage message = mailMessages.stream().
                filter(m -> m.getRecepient().equals(email)).
                findFirst().
                get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().
                oneOrMore().build();
        return regex.getText(message.getContent());


    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer()
    {
        app.mail().stop();
    }

}

