package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactEmail;

public class AddContactTests extends TestBase {

  @Test
  public void addContact()  {
    app.gotoAddContact();
    app.getContactHelper().fillFormInformation();
    app.getContactHelper().fillEmail(new ContactEmail("test@test.test"));
    app.getContactHelper().fillBirthday();
    app.getContactHelper().addGroup();
    app.getContactHelper().submitAddContact();
    app.getContactHelper().returnToHome();
  }

}
