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
        app.getContactHelper().initContactModification();
        ContactData c = ContactData.getRandomValidContactData();
        c.setNickName("MODIFIED");
        c.setHome("MODIFIED");
        app.getContactHelper().fillContactModification();
        app.getContactHelper().submitContractModification();
        app.getSessionHelper().logout();
    }


}
