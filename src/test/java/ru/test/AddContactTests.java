package ru.test;

import org.testng.annotations.Test;
import ru.model.*;

public class AddContactTests extends TestBase {

  @Test
  public void addContact()  {
    ContactData contactData = new ContactData("test@test.test", "testtest", "test4", "test3", "test8");
    app.getNavigationHelper().gotoAddContact();
    app.getContactHelper().fillEmail(contactData);
    app.getContactHelper().fillContactName(new ContactUser("test", "test2", "test1"));
    app.getContactHelper().fillTitle(contactData);
    app.getContactHelper().fillCompany(contactData);
    app.getContactHelper().fillAddress(contactData);
    app.getContactHelper().fillPhone(new ContactPhones("test7", "test6", "test5"));
    app.getContactHelper().fillFax(contactData);
    app.getContactHelper().fillBirthday();
    app.getContactHelper().addGroup();
    app.getContactHelper().submitAddContact();
    app.getContactHelper().returnToHome();
    app.getChangesHelper().clickEditContact();
    app.getContactHelper().fillContactName(new ContactUser("test3", "test7", "test8"));
    app.getChangesHelper().pressUpdateButton();
    app.getChangesHelper().clickModifyContact();
    app.getContactHelper().fillPhone(new ContactPhones("test12", "test1", "test4"));
    app.getChangesHelper().pressUpdateButton();
    app.getContactHelper().downloadCard();
    app.getContactHelper().deleteContact();
  }

}
