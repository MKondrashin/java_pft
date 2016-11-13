package ru.stqa.pft.addressbook.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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


        Calendar cal = Calendar.getInstance();
        //birthday and group
        select(By.name("bday"), Integer.toString(cal.get(Calendar.DAY_OF_MONTH )));
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

    public void initContactModification(int indexOf)
    {
        wd.findElements(By.name("entry")).get(indexOf).findElements(By.tagName("td")).get(7).findElement(By.tagName("a")).click();
    }

    public void submitContractModification()
    {
        click(By.name("update"));
    }

    public void selectContact(int indexOf)
    {
        wd.findElements(By.name("selected[]")).get(indexOf).click();
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


    public  void createContact(ContactData c) {

        fillContactForm(c, true);
        submitContactCreation();

    }

    public void modifyContact(ContactData c, int indexOf)
    {
        initContactModification(indexOf);
        fillContactForm(c, false);
        submitContractModification();
    }



    public boolean isThereAContact() {
        return isElementPresented(By.name("entry"));

    }

    public void deleteContact(int indexOf) {
        selectContact( indexOf);
        deleteContacts();
        confirmContractsDelition();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements)
        {
            String email = element.findElement(By.tagName("input")).getAttribute("accept");
            String lastName = element.findElements(By.tagName("td")).get(1).getText();
            String firstName = element.findElements(By.tagName("td")).get(2).getText();
            String address = element.findElements(By.tagName("td")).get(3).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData();
            contact.setId(id);
            contact.setLastName(lastName);
            contact.setFirstName(firstName);
            contact.setAddressHome(address);
            contact.setEmail(email);
            contacts.add(contact);
        }

        return contacts;
    }
}
