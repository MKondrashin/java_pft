package ru.stqa.pft.addressbook.model;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.annotations.Table;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.File;
import java.util.Date;
import java.util.Random;

/**
 * Created by User on 31.10.2016.
 */
@XStreamAlias("contact")
@Entity
@javax.persistence.Table(name="addressbook")
public class ContactData {


    @XStreamOmitField
    @Id
    @Column(name="id")
    private int id;

    @Column(name="firstname")
    private String firstName;

    private String middleName;
    @Column(name="lastname")
    private String lastName;

    @Transient
    private String nickName;

    @Transient
    private String title;

    @Transient
    private String company;

    @Transient
    private String address2;

    @Column(name="home")
    @Type(type="text")
    private String phoneHome;

    @Transient
    private String phoneHome2;

    @Column(name="work")
    @Type(type="text")
    private String phoneWork;
    @Column(name="mobile")
    @Type(type="text")
    private String phoneMobile;

    @Column(name="email")
    @Type(type="text")
    private String email;

    @Transient
    private String fax;

    @Transient
    private String homepage;

    @Transient
    private String address;

    @Transient
    private String notes;

    @Transient
    private Date birthday;

    @Transient
    private String home;

    @Transient
    private String group;

    @Transient
    private String allPhones;

    @Column(name="email2")
    @Type(type="text")
    private String email2;

    @Column(name="email3")
    @Type(type="text")
    private String email3;

    @Transient
    private String allEmails;

    @Column(name="photo")
    @Type(type="text")
    private String   photo;

    @Transient
    private String allData;

    @Transient
    private String fullName;


    public String getPhoto() {
        return photo;
    }

    public ContactData withPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public String getAllData() {
        return allData;
    }

    public ContactData withAllData(String allData) {
        this.allData = allData;
        return this;
    }


    public String getFullName() {
        return fullName;
    }

    public ContactData withFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }



    public String getAllEmails() {
        return allEmails;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public String getEmail2() {
        return email2;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public String getEmail3() {
        return email3;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }



    public String getAllPhones() {
        return allPhones;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public String getPhoneHome2() {
        return phoneHome2;
    }

    public ContactData withPhoneHome2(String phoneHome2) {
        this.phoneHome2 = phoneHome2;
        return this;
    }

    public ContactData()
    {
        this.birthday = new Date();
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

    public String getAddress2() {
        return address2;
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

    public String getAddress() {
        return address;
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

    public ContactData withAddress2(String address2)
    {
        this.address2 = address2;
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


    public ContactData withAddress(String address)
    {
        this.address = address;
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
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (phoneHome != null ? !phoneHome.equals(that.phoneHome) : that.phoneHome != null) return false;
        if (phoneWork != null ? !phoneWork.equals(that.phoneWork) : that.phoneWork != null) return false;
        if (phoneMobile != null ? !phoneMobile.equals(that.phoneMobile) : that.phoneMobile != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (email2 != null ? !email2.equals(that.email2) : that.email2 != null) return false;
        return email3 != null ? email3.equals(that.email3) : that.email3 == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (phoneHome != null ? phoneHome.hashCode() : 0);
        result = 31 * result + (phoneWork != null ? phoneWork.hashCode() : 0);
        result = 31 * result + (phoneMobile != null ? phoneMobile.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (email2 != null ? email2.hashCode() : 0);
        result = 31 * result + (email3 != null ? email3.hashCode() : 0);
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
                ", address='" + address + '\'' +
                ", group='" + group + '\'' +
                '}';
    }

}
