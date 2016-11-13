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

    //TODO: actually randmoize contact creation
    public static ContactData getRandomValidContactData()
    {


        ContactData c = new ContactData();
        c.setAddressHome( getRndStringWithTS());
        c.setAddressWork(getRndStringWithTS());
        c.setBirthday(new Date());
        c.setCompany(getRndStringWithTS());
        c.setEmail("NET@RENCREDIT.INVALID");
        c.setFax(getRndAlphaString());
        c.setFirstName(getRndStringWithTS());
        c.setMiddleName(getRndStringWithTS());
        c.setLastName(getRndStringWithTS());
        c.setNickName(getRndStringWithTS());
        c.setPhoneHome(getRndAlphaString());
        c.setPhoneMobile("+7" + getRndAlphaString());
        c.setHomepage("vk.com");
        c.setTitle("Sir");
        c.setPhoneWork(getRndAlphaString());
        c.setHome(getRndStringWithTS());
        c.setGroup("test22");
        c.setNotes(getRndStringWithTS());
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

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
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


}
