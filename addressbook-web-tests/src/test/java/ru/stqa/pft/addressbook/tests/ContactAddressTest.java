package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by User on 13.11.2016.
 */
public class ContactAddressTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions()
    {
        app.goTo().homePage();
        if(app.contact().all().size() == 0)
        {
            app.goTo().contactCreationPage();
            app.contact().createContact(ContactData.getRandomValidContactData());
            app.goTo().homePage();
        }
    }


    @Test(enabled = true)
    public void testContatAddresses()
    {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
        assertThat(contact.getAddress(),  is(not(equalTo(contactInfoFromEditForm.getAddress2())))) ;
    }

}
