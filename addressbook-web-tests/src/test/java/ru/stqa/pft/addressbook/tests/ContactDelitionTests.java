package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by User on 31.10.2016.
 */
public class ContactDelitionTests extends TestBase {

    @Test
    public void testContactDelition()
    {
        app.getNavigationHelper().goToHomePage();
        if(! app.getContactHelper().isThereAContact())
        {
            app.getNavigationHelper().goToContactCreationPage();
            app.getContactHelper().createContact(ContactData.getRandomValidContactData());
            app.getNavigationHelper().goToHomePage();
        }

        app.getContactHelper().deleteContact();
        app.getSessionHelper().logout();
    }

}
