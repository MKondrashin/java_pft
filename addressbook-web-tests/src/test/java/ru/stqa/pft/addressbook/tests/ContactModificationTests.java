package ru.stqa.pft.addressbook.tests;

import org.apache.http.ContentTooLongException;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

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
            app.getContactHelper().createContract(ContactData.getRandomValidContactData());
            app.getNavigationHelper().goToHomePage();
        }
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(ContactData.getRandomValidContactData(), false);
        app.getContactHelper().submitContractModification();
        app.getSessionHelper().logout();
    }


}
