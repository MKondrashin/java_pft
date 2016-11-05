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
            app.getContactHelper().createContract(ContactData.getRandomValidContactData());
            app.getNavigationHelper().goToHomePage();
        }

        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContacts();
        app.getContactHelper().confirmContractsDelition();
        app.getSessionHelper().logout();
    }

}
