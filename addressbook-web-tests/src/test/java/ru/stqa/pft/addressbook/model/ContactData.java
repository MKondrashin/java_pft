package ru.stqa.pft.addressbook.model;

import org.openqa.selenium.By;

import java.util.Date;

/**
 * Created by User on 31.10.2016.
 */
public class ContactData {

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

    public ContactData()
    {

    }

    //TODO: actually randmoize contact creation
    public static ContactData getRandomValidContactData()
    {
        ContactData c = new ContactData();
        c.setAddressHome("Penza");
        c.setAddressWork("BRC");
        c.setBirthday(new Date());
        c.setCompany("RENCREDIT");
        c.setEmail("NET@RENCREDIT.INVALID");
        c.setFax("36485");
        c.setFirstName("MAXIM");
        c.setMiddleName("VIK");
        c.setLastName("KONDRASHIN");
        c.setNickName("THE GREATE");
        c.setPhoneHome("311111");
        c.setPhoneMobile("+79600000000");
        c.setHomepage("vk.com");
        c.setTitle("Sir");
        c.setPhoneWork("364842");

        return c;
    }




    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddressWork() {
        return addressWork;
    }

    public void setAddressWork(String addressWork) {
        this.addressWork = addressWork;
    }

    public String getPhoneHome() {
        return phoneHome;
    }

    public void setPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
    }

    public String getPhoneWork() {
        return phoneWork;
    }

    public void setPhoneWork(String phoneWork) {
        this.phoneWork = phoneWork;
    }

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getAddressHome() {
        return addressHome;
    }

    public void setAddressHome(String addressHome) {
        this.addressHome = addressHome;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
