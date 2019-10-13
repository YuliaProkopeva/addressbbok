package ru.model;

public class ContactPhones {
    private final String work;
    private final String mobile;
    private final String home;

    public ContactPhones(String work, String mobile, String home) {
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
