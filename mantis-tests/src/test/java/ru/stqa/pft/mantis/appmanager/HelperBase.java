package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

/**
 * Created by UserData on 30.10.2016.
 */
public class HelperBase {
    protected WebDriver wd;
    protected ApplicationManager app;
    public HelperBase(ApplicationManager app) {

        this.app = app;
        this.wd = app.getDriver();
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        click(locator);
        if(text != null){
            WebElement element = wd.findElement(locator);
            String existingText = element.getAttribute("value");
            if(!text.equals(existingText)) {
                element.clear();
                element.sendKeys(text);
            }

        }
    }

    protected void attach(By locator, File file) {

        if(file != null){
            wd.findElement(locator).sendKeys(file.getAbsolutePath());


        }
    }

    protected void select(By locator, String visibleText)
    {
        new Select(wd.findElement(locator)).selectByVisibleText(visibleText);
    }

    protected boolean isElementPresented(By locator)
    {
        try
        {
            wd.findElement(locator);
            return true;
        }
        catch(NoSuchElementException ex)
        {
            return false;
        }
    }

    public  boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

}
