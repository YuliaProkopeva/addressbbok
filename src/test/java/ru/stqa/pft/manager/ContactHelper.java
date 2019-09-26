package ru.stqa.pft.addressbook.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.*;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void returnToHome() {
        click(By.linkText("home"));
    }

    public void submitAddContact() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]"));
    }

    public void addGroup() {
        click(By.name("new_group"));
        newObject("test1", By.name("new_group"));
        click(By.name("new_group"));
    }

    public void fillBirthday() {
        click(By.name("bday"));
        newObject("6", By.name("bday"));
        click(By.name("bday"));
        click(By.name("bmonth"));
        newObject("May", By.name("bmonth"));
        click(By.name("bmonth"));
        name(By.name("byear"), "1990");
    }

    public void fillFormInformation() {
      fillContactName(new ContactData("test", "test2", "test1"));
      fillTitle(new ContactTitle("test3"));
      fillCompany(new ContactCompany("test4"));
      fillAddress(new ContactAddress("testtest"));
      fillPhone(new ContactPhoneData("test7", "test6", "test5"));
      fillFax(new ContactFax("test8"));
    }

    public void fillEmail(ContactEmail contactEmail) {
        name(By.name("email"), contactEmail.getEmail());
    }

    private void fillFax(ContactFax contactFax) {
        name(By.name("fax"), contactFax.getFax());
    }

    private void fillPhone(ContactPhoneData contactPhoneData) {
        name(By.name("home"), contactPhoneData.getHome());
        name(By.name("mobile"), contactPhoneData.getMobile());
        name(By.name("work"), contactPhoneData.getWork());
    }

    private void fillAddress(ContactAddress contactAddress) {
        name(By.name("address"), contactAddress.getAddress());
    }

    private void fillCompany(ContactCompany contactCompany) {
        name(By.name("company"), contactCompany.getCompany());
    }

    private void fillTitle(ContactTitle contactTitle) {
        name(By.name("title"), contactTitle.getTitle());
    }

    private void fillContactName(ContactData contactData) {
        name(By.name("firstname"), contactData.getFirstname());
        name(By.name("middlename"), contactData.getMiddlename());
        name(By.name("nickname"), contactData.getNickname());
    }

}
