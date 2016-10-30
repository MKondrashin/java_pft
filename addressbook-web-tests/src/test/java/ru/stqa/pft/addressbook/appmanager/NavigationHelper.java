package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by User on 30.10.2016.
 */
public class NavigationHelper extends HelperBase{


    public NavigationHelper(FirefoxDriver wd)
    {
     super(wd);
    }

    public void goToGroupPage() {
        click(By.linkText("groups"));
    }

    public void goToContactCreationPage() {
        click(By.linkText("add new"));
    }
}
