package ru.model;

public class ContactUser {
    private final String nickname;
    private final String middlename;
    private final String firstname;


    public ContactUser(String nickname, String middlename, String firstname) {
        this.nickname = nickname;
        this.middlename = middlename;
        this.firstname = firstname;

    }

    public String getNickName() {
        return nickname;
    }

    public String getMiddleName() {
        return middlename;
    }

    public String getFirstName() {
        return firstname;
    }
}