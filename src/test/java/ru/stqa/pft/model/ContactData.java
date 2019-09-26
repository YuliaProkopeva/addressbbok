package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String nickname;
    private final String middlename;
    private final String firstname;

    public ContactData(String nickname, String middlename, String firstname) {
        this.nickname = nickname;
        this.middlename = middlename;
        this.firstname = firstname;

    }

    public String getNickname() {
        return nickname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getFirstname() {
        return firstname;
    }


}
