package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.generators.ContactDataGenerator;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by User on 31.10.2016.
 */
public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {

        if(app.db().contacts().size() == 0)
        {
            app.goTo().homePage();
            app.goTo().contactCreationPage();
            app.contact().createContact(ContactDataGenerator.getRandomValidContactData());
            app.goTo().homePage();
        }
    }


    @Test(enabled = true)
    public void testContractModification()
    {

        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = ContactDataGenerator.getRandomValidContactData().withId(modifiedContact.getId());
        app.goTo().homePage();
        app.contact().modifyContact(contact);
        app.goTo().homePage();

        Contacts after = app.db().contacts();

        assertThat(after.size(),equalTo(before.size()));
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }




}
