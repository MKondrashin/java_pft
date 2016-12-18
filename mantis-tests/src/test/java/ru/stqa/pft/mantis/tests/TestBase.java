package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;

import java.io.File;
import java.io.IOException;

/**
 * Created by UserData on 30.10.2016.
 */
public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
        app.ftp().upload(new File("src/test/resources/config_defaults_inc.php"),"config_defaults_inc.php",
                "config_defaults_inc.php.backup");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws IOException {
        app.ftp().restore("config_defaults_inc.php.backup", "config_defaults_inc.php");
        app.stop();
    }



}
