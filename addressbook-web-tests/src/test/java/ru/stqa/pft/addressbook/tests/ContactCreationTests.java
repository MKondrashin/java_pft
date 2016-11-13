package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase {

    

    
    @Test
    public void ContactCreationTests() {

        app.getNavigationHelper().goToHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().goToContactCreationPage();
        ContactData contact  = ContactData.getRandomValidContactData();

        app.getContactHelper().createContact(contact);
        app.getNavigationHelper().goToHomePage();
        List<ContactData> after  = app.getContactHelper().getContactList();

        Assert.assertEquals(before.size(), after.size() - 1);

    }
    

}
