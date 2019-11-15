package ru.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.model.ContactUser;
import java.util.Comparator;
import java.util.List;


public class CreateContactTests extends TestBase {

    @Test
    public void createContact() {
        app.getNavigationHelper().goToHomePage();
        List<ContactUser> before = app.getContactHelper().getContactList();
        ContactUser user = new ContactUser("test3", "test7", "test8");
        app.getContactHelper().gotoAddContact();
        app.getContactHelper().fillContactName(user);
        app.getContactHelper().fillContactForm();
        app.getContactHelper().submitAddContact();
        app.getContactHelper().returnToContactPage();
        List<ContactUser> after = app.getContactHelper().getContactList();
        before.add(user);
        Comparator<? super ContactUser> byId = Comparator.comparingInt(ContactUser::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);


    }
}
