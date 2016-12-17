package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.generators.ContactDataGenerator;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by User on 17.12.2016.
 */
public class RemoveContactFromGroupTests extends TestBase {


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
        if(app.db().groups().stream().filter( g-> g.getContacts()!=null && g.getContacts().size() > 0).collect(Collectors.toSet()).size() ==0)
        {
            app.goTo().homePage();
            app.contact().addContactToGroup(
                    app.db().contacts().iterator().next(),
                    app.db().groups().iterator().next()
            );
        }
        group = app.db().groups().stream().filter(g-> g.getContacts()!=null && g.getContacts().size() > 0).iterator().next();
        contact = group.getContacts().iterator().next();
    }


    @Test(enabled = true)
    public void testRemoveContactFromGroup() {
        app.goTo().homePage();
        app.contact().removeContactFromGroup(contact, group);
        app.goTo().homePage();
        group = app.db().groups().stream().filter(g->g.getId() == group.getId()).iterator().next();
        assertThat(group.getContacts().contains(contact),equalTo(false));
    }

}