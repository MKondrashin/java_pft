package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTests extends TestBase {

    

    
    @Test(enabled = true)
    public void ContactCreationTests() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        app.goTo().contactCreationPage();
        ContactData contact  = ContactData.getRandomValidContactData();
        app.contact().createContact(contact);
        app.goTo().homePage();
        Contacts after  = app.contact().all();

        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after,equalTo(before.withAdded(contact.
                withId(after.stream().mapToInt((c)-> c.getId()).max().getAsInt()))));
    }
    

}
