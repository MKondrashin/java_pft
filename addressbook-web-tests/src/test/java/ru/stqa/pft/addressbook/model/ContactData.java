package ru.stqa.pft.addressbook.model;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.By;

import java.util.Date;
import java.util.Random;

/**
 * Created by User on 31.10.2016.
 */
public class ContactData {



    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String nickName;
    private String title;
    private String company;
    private String addressWork;
    private String phoneHome;
    private String phoneWork;
    private String phoneMobile;
    private String email;
    private String fax;
    private String homepage;
    private String addressHome;
    private String notes;
    private Date birthday;
    private String home;
    private String group;


    public ContactData()
    {

    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddressWork() {
        return addressWork;
    }

    public String getPhoneHome() {
        return phoneHome;
    }

    public String getPhoneWork() {
        return phoneWork;
    }

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public String getEmail() {
        return email;
    }

    public String getFax() {
        return fax;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getAddressHome() {
        return addressHome;
    }

    public String getNotes() {
        return notes;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getHome() {
        return home;
    }

    public String getGroup() {
        return group;
    }

    public int getId() {
        return id;
    }

    public ContactData withId(int id)
    {
        this.id=id;
        return this;
    }

    public ContactData withFirstName(String firstName)
    {
        this.firstName = firstName;
        return  this;
    }

    public ContactData withMiddleName(String middleName)
    {
        this.middleName = middleName;
        return  this;
    }

    public ContactData withLastName(String lastName)
    {
        this.lastName = lastName;
        return  this;
    }

    public ContactData withNickName(String nickName)
    {
        this.nickName = nickName;
        return  this;
    }

    public ContactData withTitle(String title)
    {
        this.title = title;
        return  this;
    }

    public ContactData withCompany(String company)
    {
        this.company = company;
        return  this;
    }

    public ContactData withAddressWork(String addressWork)
    {
        this.addressWork = addressWork;
        return  this;
    }

    public ContactData withPhoneHome(String phoneHome)
    {
        this.phoneHome = phoneHome;
        return  this;
    }

    public ContactData withPhoneWork(String phoneWork)
    {
        this.phoneWork = phoneWork;
        return  this;
    }

    public ContactData withPhoneMobile(String phoneMobile)
    {
        this.phoneMobile = phoneMobile;
        return  this;
    }

    public ContactData withEmail(String email)
    {
        this.email = email;
        return  this;
    }

    public ContactData withFax(String fax)
    {
        this.fax = fax;
        return  this;
    }

    public ContactData withHomePage(String homepage)
    {
        this.homepage = homepage;
        return  this;
    }


    public ContactData withAddressHome(String addressHome)
    {
        this.addressHome = addressHome;
        return  this;
    }

    public ContactData withNotes(String notes)
    {
        this.notes = notes;
        return  this;
    }

    public ContactData withHome(String home)
    {
        this.home = home;
        return  this;
    }

    public ContactData withGroup(String group)
    {
        this.group = group;
        return  this;
    }

    public ContactData withBirthday(Date birthday)
    {
        this.birthday = birthday;
        return  this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneHome='" + phoneHome + '\'' +
                ", email='" + email + '\'' +
                ", addressHome='" + addressHome + '\'' +
                ", group='" + group + '\'' +
                '}';
    }

    private static String getRndStringWithTS()
    {
        return RandomStringUtils.randomAlphabetic(5) + Long.toString(System.currentTimeMillis());
    }

    private static String getRndAlphaString()
    {
        Random rnd = new Random();
        return String.format("%010d",Math.abs(rnd.nextInt()) );
    }

    //TODO: actually randmoize contact creation
    public static ContactData getRandomValidContactData()
    {


        ContactData c = new ContactData()
                .withId(Integer.MAX_VALUE)
                .withAddressHome(getRndStringWithTS())
                .withAddressWork(getRndStringWithTS())
                .withBirthday(new Date())
                .withCompany(getRndStringWithTS())
                .withEmail(getRndAlphaString() + "NET@RENCREDIT.INVALID")
                .withFax(getRndStringWithTS())
                .withFirstName(getRndStringWithTS())
                .withMiddleName(getRndStringWithTS())
                .withLastName(getRndStringWithTS())
                .withNickName(getRndStringWithTS())
                .withPhoneHome(getRndStringWithTS())
                .withPhoneMobile("+7" + getRndAlphaString())
                .withHomePage("vk.com")
                .withTitle("Sir")
                .withPhoneWork(getRndAlphaString())
                .withHome(getRndStringWithTS())
                .withGroup("test22")
                .withNotes(getRndStringWithTS());

        return c;
    }

}
