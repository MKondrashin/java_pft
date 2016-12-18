package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by UserData on 17.12.2016.
 */
public class RegistrationHelper extends HelperBase{
    //private final ApplicationManager app;
    private WebDriver wd;

    public RegistrationHelper(ApplicationManager applicationManager) {
        super(applicationManager);
        this.app = applicationManager;
        wd = app.getDriver();
    }

    public void start(String username, String email){
        wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
        type(By.name("username"),username);
        type(By.name("email"),email);
        click(By.cssSelector("input[value='Зарегистрироваться']"));
    }

    public void finish(String confirmationLink, String password) {
        wd.get(confirmationLink);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.cssSelector("input[value='Изменить учетную запись']"));
    }
}
