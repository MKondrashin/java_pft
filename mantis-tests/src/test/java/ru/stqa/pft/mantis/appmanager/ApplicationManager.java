package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by User on 30.10.2016.
 */
public class ApplicationManager {

    WebDriver wd;
    private String browser;
    private final Properties properties;
    private RegistrationHelper registration;

    public ApplicationManager(String browser) {

        this.browser = browser;
        properties = new Properties();

    }


    public void init() throws IOException {

        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties",target))));



    }


    public void stop() {
       if(wd != null) {
           wd.quit();
       }
    }

    public String getProperty(String key)
    {
        return properties.getProperty(key);
    }


    public HttpSession newSession()
    {
        return  new HttpSession(this);
    }

    public RegistrationHelper registration() {
        if(registration==null)
        {
            registration = new RegistrationHelper(this);
        }

        return registration;
    }

    public WebDriver getDriver() {
        if(wd == null)
        {
            if(browser.equals(BrowserType.FIREFOX)){
                System.setProperty("webdriver.gecko.driver",properties.getProperty("web.pathToFirefoxDriver"));
                wd = new FirefoxDriver();
            } else if(browser.equals(BrowserType.CHROME)) {
                System.setProperty("webdriver.chrome.driver",properties.getProperty("web.pathToChromeDriver"));
                wd = new ChromeDriver();
            } else if (browser.equals(BrowserType.IE))
            {
                System.setProperty("webdriver.ie.driver",properties.getProperty("web.pathToIeDriver"));
                wd = new InternetExplorerDriver();
            }

            wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            wd.get(properties.getProperty("web.baseUrl"));// "http://localhost/addressbook");
        }
        return wd;
    }
}
