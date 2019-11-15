package ru.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.model.*;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void submitAddContact() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]"));
    }

    public void gotoAddContact() {
        click(By.linkText("add new"));
    }


    public void fillBirthday() {
        click(By.name("bday"));
        selectFromListOfValue("6", By.name("bday"));
        click(By.name("bmonth"));
        selectFromListOfValue("May", By.name("bmonth"));
        name(By.name("byear"), "1990");
    }


    public void fillEmail(ContactData contactEmail) {
        name(By.name("email"), contactEmail.getEmail());
    }

    public void fillFax(ContactData contactFax) {
        name(By.name("fax"), contactFax.getFax());
    }

    public void fillPhone(ContactPhones contactPhoneData) {
        name(By.name("home"), contactPhoneData.getHome());
        name(By.name("mobile"), contactPhoneData.getMobile());
        name(By.name("work"), contactPhoneData.getWork());
    }

    public void fillAddress(ContactData contactAddress) {
        name(By.name("address"), contactAddress.getAddress());
    }

    public void fillCompany(ContactData contactCompany) {
        name(By.name("company"), contactCompany.getCompany());
    }

    public void fillTitle(ContactData contactTitle) {
        name(By.name("title"), contactTitle.getTitle());
    }

    public void fillContactName(ContactUser contactUser) {
        name(By.name("firstname"), contactUser.getFirstName());
        name(By.name("middlename"), contactUser.getMiddleName());
        name(By.name("lastname"), contactUser.getLastName());
    }

    public void returnToContactPage() {
        click(By.linkText("home page"));
    }

    public void selectContact(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteContact() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select all'])[1]/following::input[2]"));
        accept();
    }

    public void fillContactForm() {
        ContactData contactData = new ContactData("test@test.test", "test5", "test4", "test3", "test8");
        fillTitle(contactData);
        fillCompany(contactData);
        fillAddress(contactData);
        fillPhone(new ContactPhones("test7", "test6", "test5"));
        fillFax(contactData);
        fillEmail(contactData);
        fillBirthday();
    }

    public void isThereAContact() {
        NavigationHelper navigationHelper = new NavigationHelper(driver);
        navigationHelper.goToHomePage();
        if (!isElementPresent(By.xpath("(//input[@name=\"selected[]\"])[last()]"))) {
            gotoAddContact();
            fillContactName( new ContactUser ( "test3", "test7", "test8"));
            fillContactForm();
            submitAddContact();
        }

    }

    public List<ContactUser> getContactList() {
        List<ContactUser> contacts = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.xpath("(.//tr[@name=\"entry\"])"));
        if(elements.size() != 0) {
            for (WebElement element : elements) {
                int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
                String lastname = element.findElement(By.xpath("(.//td[2])")).getText();
                String firstname = element.findElement(By.xpath("(.//td[3])")).getText();
                ContactUser users = new ContactUser(id, lastname, null, firstname);
                contacts.add(users);
            }
        }
        return contacts;
    }

}
