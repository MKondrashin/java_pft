package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by User on 30.10.2016.
 */
public class NavigationHelper extends HelperBase{


    public NavigationHelper(WebDriver wd)
    {
     super(wd);
    }

    public void groupPage() {
        if(isElementPresented(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresented(By.name("new"))){
            return;
        }
        click(By.linkText("groups"));
    }

    public void contactCreationPage() {
        if(isElementPresented(By.tagName("h1"))
                && isElementPresented(By.xpath("//div[@id='content']//h1[.='Edit / add address book entry']"))
                && isElementPresented(By.name("submit"))){
                           return;
        }
        click(By.linkText("add new"));
    }

    public void homePage() {
        if(isElementPresented(By.id("maintable")))        {
            return;
        }
        click(By.linkText("home"));
    }
}
