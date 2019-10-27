package ru.test;

import org.testng.annotations.Test;


public class ContactTests extends TestBase {

  @Test
  public void testContact()  {
    app.getContactHelper().createContact();
    app.getContactHelper().downloadCard();
    app.getContactHelper().deleteContact();
  }
}
