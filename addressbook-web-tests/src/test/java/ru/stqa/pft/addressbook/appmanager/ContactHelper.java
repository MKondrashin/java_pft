package ru.stqa.pft.addressbook.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

import java.text.DateFormatSymbols;

/**
 * Created by User on 31.10.2016.
 */
public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData c, boolean creation) {
        type(By.name("firstname"), c.getFirstName());
        type(By.name("middlename"), c.getMiddleName());
        type(By.name("lastname"), c.getLastName());
        type(By.name("nickname"), c.getNickName());
        type(By.name("title"), c.getTitle());
        type(By.name("company"), c.getCompany());
        type(By.name("address"), c.getAddressWork());
        type(By.name("home"), c.getPhoneHome());
        type(By.name("mobile"), c.getPhoneMobile());
        type(By.name("work"), c.getPhoneWork());
        type(By.name("fax"), c.getFax());
        type(By.name("email"), c.getEmail());
        type(By.name("homepage"), c.getHomepage());
        type(By.name("byear"), Integer.toString(c.getBirthday().getYear()));
        type(By.name("address2"), c.getAddressHome());
        type(By.name("phone2"), c.getHome());
        type(By.name("notes"), c.getNotes());

        //birthday and group
        select(By.name("bday"), Integer.toString(c.getBirthday().getDay()));
        select(By.name("bmonth"), getMonthForInt(c.getBirthday().getMonth()));
        type(By.name("byear"), Integer.toString(c.getBirthday().getYear()));
        if (creation)
        {
            if(isElementPresented(By.xpath("//div[@id='content']/form/select[@name='new_group']/option[text()='" + c.getGroup() + "']")))
            {
                select(By.name("new_group"), c.getGroup());
            }
            else
            {
                select(By.name("new_group"), "[none]");
            }

        }
        else
        {
            Assert.assertFalse(isElementPresented(By.name("new_group")));
        }
    }

    public void fillContactModification()
    {
        type(By.name("firstname"),"FNAME MODIFIED");
        type(By.name("middlename"),"MNAME MODIFIED");
        type(By.name("lastname"),"LNM MODIFIED");
    }


    public void submitContactCreation()
    {
       click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void initContactModification()
    {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void submitContractModification()
    {
        click(By.name("update"));
    }

    public void selectContact()
    {
        click(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[1]/input"));
    }

    public void deleteContacts()
    {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void confirmContractsDelition()
    {
        wd.switchTo().alert().accept();
    }

    private  String getMonthForInt(int month) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return monthNames[month];
    }
    
    public void createContract(ContactData c)
    {
       fillContactForm(ContactData.getRandomValidContactData(), true);
       submitContactCreation();
    }


    public boolean isThereAContact() {
        return isElementPresented(By.name("entry"));

    }
}
