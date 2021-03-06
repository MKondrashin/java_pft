package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by UserData on 17.12.2016.
 */
public class RegistrationTests extends TestBase {

    //@BeforeMethod
    public void startMailServer()
    {
        app.mail().start();
    }

    @Test
    public void testRegistration() throws IOException, MessagingException {
        long now = System.currentTimeMillis();
        String user = String.format("user%s",now);
        String email = String.format("%s@localhost.localdomain", user);
        String password = "password";
        app.james().createUser(user, password);
        app.registration().start(user, email);
        List<MailMessage> mailMessages = app.james().waitForMail(user, password, 60000);

        //List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
        String confirmationLink = findConfirmationLink(mailMessages, email);
        app.registration().finish(confirmationLink, password);
        assertTrue(app.newSession().login(user, password));
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

   // @AfterMethod(alwaysRun = true)
    public void stopMailServer()
    {
        app.mail().stop();
    }

}
