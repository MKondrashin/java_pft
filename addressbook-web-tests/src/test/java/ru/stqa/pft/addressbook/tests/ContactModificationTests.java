package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by User on 31.10.2016.
 */
public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if(app.contact().all().size() == 0)
        {
            app.goTo().contactCreationPage();
            app.contact().createContact(ContactData.getRandomValidContactData());
            app.goTo().homePage();
        }
    }


    @Test(enabled = true)
    public void testContractModification()
    {
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = ContactData.getRandomValidContactData().withId(modifiedContact.getId());
        app.contact().modifyContact(contact);
        app.goTo().homePage();

        Contacts after = app.contact().all();

        assertThat(after.size(),equalTo(before.size()));
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }




}
