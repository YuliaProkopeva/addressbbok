package ru.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase {


    @BeforeClass
    public void setUp() {
        app.init();
        app.getContactHelper().isThereAContact();
    }

    @Test
    public void deleteContact() {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().goToHomePage();
    }

}
