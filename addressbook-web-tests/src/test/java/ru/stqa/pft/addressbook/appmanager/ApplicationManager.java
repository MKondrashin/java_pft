package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Created by User on 30.10.2016.
 */
public class ApplicationManager {

    private SessionHelper sessionHelper;
    private  NavigationHelper navigationHelper;
    WebDriver wd;
    private  GroupHelper groupHelper;
    private  ContactHelper contactHelper;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() {

        if(browser.equals(BrowserType.FIREFOX))         {
            System.setProperty("webdriver.gecko.driver","C:\\Selenium\\Firefox driver\\geckodriver.exe");
            wd = new FirefoxDriver();
        } else if(browser.equals(BrowserType.CHROME)) {
            System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Chrome driver\\chromedriver.exe");
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE))
        {
            System.setProperty("webdriver.ie.driver","C:\\Selenium\\InternetExplorer driver32\\IEDriverServer.exe");
            wd = new InternetExplorerDriver();
        }

        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        contactHelper = new ContactHelper(wd);
        wd.get("http://localhost/addressbook/group.php");
        sessionHelper.login("admin", "secret");
    }


    public void stop() {
        wd.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
