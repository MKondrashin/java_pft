package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.generators.ContactDataGenerator;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by User on 31.10.2016.
 */
public class ContactDelitionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {

        if(app.db().contacts().size() == 0)
        {
            app.goTo().contactCreationPage();
            app.contact().createContact(ContactDataGenerator.getRandomValidContactData());
            app.goTo().homePage();
        }
    }

    @Test(enabled = true)
    public void testContactDelition()
    {
        Contacts before = app.db().contacts();
        ContactData contact =  before.iterator().next();
        app.goTo().homePage();
        app.contact().deleteContact(contact);
        app.goTo().homePage();

        Contacts after = app.db().contacts();

        assertThat(after.size(), equalTo(before.size() - 1));
        assertThat(after, equalTo(before.without(contact)));
    }

}
