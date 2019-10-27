package ru.model;

public class ContactData {
    private final String email;
    private final String address;
    private final String company;
    private final String title;
    private final String fax;


    public ContactData(String email, String address, String company, String title, String fax) {
        this.email = email;
        this.address = address;
        this.company = company;
        this.title = title;
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getCompany() {
        return company;
    }

    public String getTitle() {
        return title;
    }

    public String getFax() {
        return fax;
    }

}
