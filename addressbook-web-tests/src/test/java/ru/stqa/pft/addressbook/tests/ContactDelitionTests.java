package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by User on 31.10.2016.
 */
public class ContactDelitionTests extends TestBase {

    @Test(enabled = false)
    public void testContactDelition()
    {
        app.goTo().goToHomePage();
        if(! app.getContactHelper().isThereAContact())
        {
            app.goTo().goToContactCreationPage();
            app.getContactHelper().createContact(ContactData.getRandomValidContactData());
            app.goTo().goToHomePage();
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().deleteContact(before.size() - 1);
        app.goTo().goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);

        Assert.assertEquals(before, after);
    }

}
