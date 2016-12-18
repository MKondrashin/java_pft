package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by User on 30.10.2016.
 */
public class NavigationHelper extends HelperBase{


    public NavigationHelper(ApplicationManager app)
    {
     super(app);
    }

    public void managePage()
    {
        click(By.linkText("управление"));
    }

    public void manageUsersPage()
    {
        click(By.linkText("Управление пользователями"));
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
