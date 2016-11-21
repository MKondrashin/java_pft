package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.generators.ContactDataGenerator;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by User on 13.11.2016.
 */
public class ContactDetailedInformationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions()
    {
        app.goTo().homePage();
        if(app.contact().all().size() == 0)
        {
            app.goTo().contactCreationPage();
            app.contact().createContact(ContactDataGenerator.getRandomValidContactData());
            app.goTo().homePage();
        }
    }

    @Test
    public void testDetailedInformation()
    {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        ContactData contactInfoFromDetailedForm = app.contact().infoFromDetailedInformationForm(contact);
        assertThat(contactInfoFromDetailedForm.getAllData(), equalTo(mergeContactData(contactInfoFromEditForm)));
    }


    private String mergeContactData(ContactData contact) {
        return Arrays.asList( contact.getLastName(),contact.getFirstName() ,
                contact.getAddress(), contact.getEmail(),contact.getEmail2(),contact.getEmail3(),
                contact.getPhoneHome(), contact.getPhoneMobile(),contact.getPhoneWork(), contact.getPhoneHome2())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactDetailedInformationTests::cleaned).sorted()
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone)
    {
        return phone.replaceAll("\\s","").replaceAll("[-()]","");
    }
}
