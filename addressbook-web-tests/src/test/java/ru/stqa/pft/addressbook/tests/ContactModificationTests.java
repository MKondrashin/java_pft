package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by User on 31.10.2016.
 */
public class ContactModificationTests extends TestBase {

    @Test(enabled = false)
    public void testContractModification()
    {
        app.goTo().goToHomePage();
        if(! app.getContactHelper().isThereAContact())
        {
            app.goTo().goToContactCreationPage();
            app.getContactHelper().createContact(ContactData.getRandomValidContactData());
            app.goTo().goToHomePage();
        }

        List<ContactData> before = app.getContactHelper().getContactList();

        ContactData contact = ContactData.getRandomValidContactData();
        app.getContactHelper().modifyContact(contact, before.size() - 1);
        app.goTo().goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();

        Assert.assertEquals(before.size(), after.size());

        Comparator<? super ContactData> byId = (c1, c2)  -> Integer.compare(c1.getId(),c2.getId());

        contact.setId(before.get(before.size()-1).getId());
        before.remove(before.size() - 1);
        before.add(contact);


        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(after,before);

    }




}
