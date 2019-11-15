package ru.model;

import java.util.Objects;

public class ContactUser {
    private int id;
    private final String lastname;
    private final String middlename;
    private final String firstname;


    public ContactUser(int id, String lastname, String middlename, String firstname) {
        this.id = id;
        this.lastname = lastname;
        this.middlename = middlename;
        this.firstname = firstname;

    }

    public ContactUser(String lastname, String middlename, String firstname) {
        this.id = Integer.MAX_VALUE;
        this.lastname = lastname;
        this.middlename = middlename;
        this.firstname = firstname;

    }


    public int getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactUser that = (ContactUser) o;
        return Objects.equals(lastname, that.lastname) &&
                Objects.equals(firstname, that.firstname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastname, firstname);
    }

    @Override
    public String toString() {
        return "ContactUser{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                '}';
    }

}