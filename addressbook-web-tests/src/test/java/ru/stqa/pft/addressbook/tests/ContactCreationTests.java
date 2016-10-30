package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    

    
    @Test
    public void ContactCreationTests() {

        app.getNavigationHelper().goToContactCreationPage();
        app.getContactHelper().fillContactCreationForm(ContactData.getRandomValidContactData());
        app.getContactHelper().submitContactCreation();
        app.getSessionHelper().logout();
    }
    

}
