package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by User on 31.10.2016.
 */
public class ContactHelper extends HelperBase {

    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void fillContactCreationForm(ContactData c)
    {
        click(By.name("theform"));
        type(By.name("firstname"),c.getFirstName());
        type(By.name("middlename"),c.getMiddleName());
        type(By.name("lastname"),c.getLastName());
        type(By.name("nickname"),c.getNickName());
        type(By.name("title"),c.getTitle());
        type(By.name("company"),c.getCompany());
        type(By.name("address"),c.getAddressWork());
        type(By.name("home"),c.getPhoneHome());
        type(By.name("mobile"),c.getPhoneMobile());
        type(By.name("work"),c.getPhoneWork());
        type(By.name("fax"),c.getFax());
        type(By.name("email"),c.getEmail());
        click(By.name("theform"));
        type(By.name("homepage"),c.getHomepage());
        type(By.name("byear"),Integer.toString(c.getBirthday().getYear()));
        type(By.name("address2"),c.getAddressHome());
        type(By.name("phone2"),c.getHome());
        type(By.name("notes"),c.getNotes());

        //birthday and group
        click(By.xpath("//div[@id='content']/form/select[1]//option[1]"));
        click(By.xpath("//div[@id='content']/form/select[1]//option[5]"));
        click(By.xpath("//div[@id='content']/form/select[1]//option[33]"));
        click(By.xpath("//div[@id='content']/form/select[1]//option[33]"));
        click(By.xpath("//div[@id='content']/form/select[1]//option[33]"));
        click(By.xpath("//div[@id='content']/form/select[2]//option[1]"));
        click(By.xpath("//div[@id='content']/form/select[2]//option[8]"));
        click(By.xpath("//div[@id='content']/form/select[5]//option[2]"));
    }


    public void submitContactCreation()
    {
       click(By.xpath("//div[@id='content']/form/input[21]"));
    }
}
