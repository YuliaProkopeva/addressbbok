package ru.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.model.ContactUser;

import java.util.List;

public class DeleteContactTests extends TestBase {


    @BeforeClass
    public void setUp() {
        app.init();
        app.getContactHelper().isThereAContact();
    }

    @Test
    public void deleteContact() {
        app.getNavigationHelper().goToHomePage();
        List<ContactUser> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().goToHomePage();
        List<ContactUser> after = app.getContactHelper().getContactList();
        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }

}

