package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.WebDriver;

/**
 * Created by User on 17.12.2016.
 */
public class RegistrationHelper {
    private final ApplicationManager app;
    private WebDriver wd;

    public RegistrationHelper(ApplicationManager applicationManager) {
        this.app = applicationManager;
        wd = app.getDriver();
    }

    public void start(String username, String email){
        wd.get(app.getProperty("web.baseUrl") + "/signap_page.php");
    }
}
