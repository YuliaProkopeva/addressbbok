package ru.stqa.pft.addressbook.model;

public class ContactPhoneData {
    private final String work;
    private final String mobile;
    private final String home;

    public ContactPhoneData(String work, String mobile, String home) {
        this.work = work;
        this.mobile = mobile;
        this.home = home;
    }

    public String getWork() {
        return work;
    }

    public String getMobile() {
        return mobile;
    }

    public String getHome() {
        return home;
    }
}
