package ru.test;

import org.testng.annotations.Test;


public class CreateContactTests extends TestBase {

    @Test
    public void createContact() {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().gotoAddContact();
        app.getContactHelper().createContact();
        app.getContactHelper().returnToContactPage();
    }
}
