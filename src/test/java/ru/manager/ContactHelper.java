package ru.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.model.*;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }
    public void submitAddContact() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]"));
    }

    public void addGroup() {
        click(By.name("new_group"));
        selectFromListOfValue("test1", By.name("new_group"));
        click(By.name("new_group"));
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
        name(By.name("nickname"), contactUser.getNickName());
    }
    public void downloadCard() {
        click(By.xpath("((//tr[@name=\"entry\"]//input[@type=\"checkbox\"])[last()])/following::img[3]"));
    }

    public void deleteContact() {
        click(By.xpath("(//tr[@name=\"entry\"]//input[@type=\"checkbox\"])[last()]"));
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select all'])[1]/following::input[2]"));
        accept();
    }

}
