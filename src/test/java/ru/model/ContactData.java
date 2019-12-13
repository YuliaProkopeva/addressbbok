package ru.model;

import java.util.Objects;

public class ContactData {
    private int id = Integer.MAX_VALUE;
    private String lastname;
    private String middlename;
    private String firstname;
    private String email;
    private String email2;
    private String email3;
    private String address;
    private String workPhone;
    private String mobilePhone;
    private String homePhone;
    private String allPhones;
    private String allEmail;

    public int getId() {
        return id;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public String getAllEmail() {
        return allEmail;
    }

    public String getLastName() {
        return lastname;
    }

    public String getMiddleName() {
        return middlename;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getAddress() {
        return address;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }


    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withAllEmail(String allEmail) {
        this.allEmail = allEmail;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public ContactData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public ContactData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(email, that.email) &&
                Objects.equals(email2, that.email2) &&
                Objects.equals(email3, that.email3) &&
                Objects.equals(address, that.address) &&
                Objects.equals(workPhone, that.workPhone) &&
                Objects.equals(mobilePhone, that.mobilePhone) &&
                Objects.equals(homePhone, that.homePhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastname, firstname, email, email2, email3, address, workPhone, mobilePhone, homePhone);
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", email='" + email + '\'' +
                ", email2='" + email2 + '\'' +
                ", email3='" + email3 + '\'' +
                ", address='" + address + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", homePhone='" + homePhone + '\'' +
                '}';
    }

}

