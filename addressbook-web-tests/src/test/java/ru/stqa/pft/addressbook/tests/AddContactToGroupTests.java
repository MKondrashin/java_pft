package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.generators.ContactDataGenerator;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by User on 17.12.2016.
 */
public class AddContactToGroupTests extends TestBase {


    private ContactData contact;
    private GroupData group;

    @BeforeMethod
    public void ensurePreconditions()
    {
        if(app.db().contacts().size() ==0)
        {
            app.goTo().contactCreationPage();
            app.contact().createContact(ContactDataGenerator.getRandomValidContactData());
            app.goTo().homePage();
        }
        if(app.db().groups().size()==0)
        {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName(ContactDataGenerator.getRndStringWithTS()).withFooter(ContactDataGenerator.getRndStringWithTS()).withHeader(ContactDataGenerator.getRndStringWithTS()));
            app.goTo().homePage();
        }
        contact = app.db().contacts().iterator().next();
        group = app.db().groups().iterator().next();
        if(group.getContacts().contains(contact))
        {
            app.contact().removeContactFromGroup(contact, group);
            app.goTo().homePage();
            app.contact().selectAllGroups();
        }

    }


    @Test(enabled = true)
    public void testAddContactToGroup()
    {
        app.goTo().homePage();
        app.contact().addContactToGroup(contact,group);
        app.goTo().homePage();
        contact = app.db().contacts().stream().filter(c-> c.getId()==contact.getId()).iterator().next();
        assertThat(contact.getGroups().contains(group), equalTo(true));
    }

}