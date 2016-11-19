package ru.stqa.pft.addressbook.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.tests.ContactDetailedInformationTests;
import ru.stqa.pft.addressbook.tests.ContactPhoneTests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

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
        type(By.name("address"), c.getAddress2());
        type(By.name("home"), c.getPhoneHome());
        type(By.name("mobile"), c.getPhoneMobile());
        type(By.name("work"), c.getPhoneWork());
        type(By.name("fax"), c.getFax());
        type(By.name("email"), c.getEmail());
        type(By.name("email2"), c.getEmail2());
        type(By.name("email3"), c.getEmail3());
        type(By.name("homepage"), c.getHomepage());
        type(By.name("byear"), Integer.toString(c.getBirthday().getYear()));
        type(By.name("address2"), c.getAddress());
        type(By.name("phone2"), c.getPhoneHome2());
        type(By.name("notes"), c.getNotes());
        attach(By.name("photo"),c.getPhoto());

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

    public void submitContactCreation()
    {
       click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void initContactModificationById(int id)
    {
        wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
    }

    public void openDetails(int id)
    {
        wd.findElement(By.cssSelector("a[href='view.php?id=" + id + "']")).click();
    }

    public void submitContractModification()
    {
        click(By.name("update"));
    }

    public void selectContact(int indexOf)
    {
        wd.findElements(By.name("selected[]")).get(indexOf).click();
    }

    public void selectContactById(int id)
    {
        wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
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
        contactsCache = null;
        submitContactCreation();

    }





    public boolean isThereAContact() {
        return isElementPresented(By.name("entry"));

    }

    public void deleteContact(int indexOf) {
        selectContact( indexOf);
        deleteContacts();
        confirmContractsDelition();
    }

    private Contacts contactsCache = null;

      public Contacts all() {
        if(contactsCache != null)
        {
            return new Contacts(contactsCache);
        }
        contactsCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements)
        {
            String email = element.findElement(By.tagName("input")).getAttribute("accept");
            String lastName = element.findElements(By.tagName("td")).get(1).getText();
            String firstName = element.findElements(By.tagName("td")).get(2).getText();
            String address = element.findElements(By.tagName("td")).get(3).getText();
            String allPhones = element.findElements(By.tagName("td")).get(5).getText();
            String allEmails = element.findElements(By.tagName("td")).get(4).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData().withId(id).withLastName(lastName)
                    .withFirstName(firstName).withAddress(address)
                    .withAllPhones(allPhones).withAllEmails(allEmails);
            contactsCache.add(contact);
        }

        return new Contacts(contactsCache);
    }


    public void deleteContact(ContactData contact) {
        selectContactById(contact.getId());
        deleteContacts();
        contactsCache = null;
        confirmContractsDelition();
    }

    public void modifyContact(ContactData contact) {
        initContactModificationById(contact.getId());
        fillContactForm(contact, false);
        contactsCache = null;
        submitContractModification();

    }

    public ContactData infoFromEditForm(ContactData contact) {
        String url = wd.getCurrentUrl();

        initContactModificationById(contact.getId());
        int id = Integer.parseInt(wd.findElement(By.name("id")).getAttribute("value"));
        String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
        String middleName = wd.findElement(By.name("middlename")).getAttribute("value");
        String homePhone = wd.findElement(By.name("home")).getAttribute("value");
        String homePhone2 = wd.findElement(By.name("phone2")).getAttribute("value");
        String workPhone = wd.findElement(By.name("work")).getAttribute("value");
        String mobilePhone = wd.findElement(By.name("mobile")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String address2 = wd.findElement(By.name("address2")).getAttribute("value");
        wd.get(url);
        return new ContactData()
                .withId(id)
                .withFirstName(firstName)
                .withLastName(lastName)
                .withMiddleName(middleName)
                .withPhoneHome(homePhone)
                .withPhoneMobile(mobilePhone)
                .withPhoneWork(workPhone)
                .withEmail(email)
                .withEmail2(email2)
                .withEmail3(email3)
                .withAddress(address)
                .withAddress2(address2)
                .withPhoneHome2(homePhone2);
    }

    public ContactData infoFromDetailedInformationForm(ContactData contact) {
        String url = wd.getCurrentUrl();
        ContactData c = new ContactData();
        openDetails(contact.getId());
        //gettting emails
        List<WebElement> elements = wd.findElements(By.cssSelector("a[href^='mailto'"));
        List<String> emails = new ArrayList<String>();
        for(WebElement element : elements)
        {
            emails.add(element.getText());
        }
        String allText = wd.findElement(By.xpath("//*[@id='content']")).getText();
        String fullName = wd.findElement(By.xpath("//*[@id=\"content\"]/b")).getText();
        allText = allText.replaceAll("P: |H: |M: |W: ","").replaceAll("\n{2,}","\n").replaceAll(" ","\n");
        allText = Arrays.asList(allText.split("\n")).stream().filter((s) -> ! s.equals(""))
                .map(ContactDetailedInformationTests::cleaned).sorted()
                .collect(Collectors.joining("\n"));

        wd.get(url);
        return c.withAllData(allText);

    }


}
