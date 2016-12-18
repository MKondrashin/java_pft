package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by User on 30.10.2016.
 */
public class SessionHelper extends HelperBase{

    public SessionHelper(ApplicationManager app) {
        super(app);
    }

    public void login(String username, String password) {
        wd.get(app.getProperty("web.baseUrl"));
        type(By.name("username"),username);
        type(By.name("password"),password);
        click(By.cssSelector("input[value='Войти']"));
       }

       public void logout()
       {
           click(By.linkText("Logout"));
       }


}
