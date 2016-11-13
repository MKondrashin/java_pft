package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
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

        Comparator<? super ContactData> byId = (c1, c2)  -> Integer.compare(c1.getId(),c2.getId());

        contact.setId(after.stream().max(byId).get().getId());
        before.add(contact);

        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before,after);

    }
    

}
