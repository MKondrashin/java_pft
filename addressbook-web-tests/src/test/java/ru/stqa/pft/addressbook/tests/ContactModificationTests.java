package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by User on 31.10.2016.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testContractModification()
    {
        app.getNavigationHelper().goToHomePage();
        if(! app.getContactHelper().isThereAContact())
        {
            app.getNavigationHelper().goToContactCreationPage();
            app.getContactHelper().createContact(ContactData.getRandomValidContactData());
            app.getNavigationHelper().goToHomePage();
        }

        List<ContactData> before = app.getContactHelper().getContactList();

        ContactData contact = ContactData.getRandomValidContactData();
        app.getContactHelper().modifyContact(contact, before.size() - 1);
        app.getNavigationHelper().goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();

        Assert.assertEquals(before.size(), after.size());

        Comparator<? super ContactData> byId = (c1, c2)  -> Integer.compare(c1.getId(),c2.getId());
        before.remove(before.size() - 1);
        contact.setId(after.stream().max(byId).get().getId());
        before.add(contact);


        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(after,before);

    }




}
