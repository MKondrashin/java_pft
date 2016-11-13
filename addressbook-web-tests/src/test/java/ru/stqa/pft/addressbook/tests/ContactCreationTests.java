package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    

    
    @Test
    public void ContactCreationTests() {

        app.getNavigationHelper().goToContactCreationPage();
        app.getContactHelper().createContact(ContactData.getRandomValidContactData());
        app.getSessionHelper().logout();
    }
    

}
