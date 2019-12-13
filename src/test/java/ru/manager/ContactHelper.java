package ru.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.model.ContactData;
import ru.model.Contacts;

import java.util.Arrays;
import java.util.List;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void submit() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]"));
    }

    public void addContact() {
        click(By.linkText("add new"));
    }


    public void fillBirthday() {
        click(By.name("bday"));
        selectFromListOfValue("6", By.name("bday"));
        click(By.name("bmonth"));
        selectFromListOfValue("May", By.name("bmonth"));
        name(By.name("byear"), "1990");
    }

    public void fillContact(ContactData contactData) {
        name(By.name("address"), contactData.getAddress());
        name(By.name("home"), contactData.getHomePhone());
        name(By.name("mobile"), contactData.getMobilePhone());
        name(By.name("work"), contactData.getWorkPhone());
        name(By.name("email"), contactData.getEmail());
        name(By.name("email2"), contactData.getEmail2());
        name(By.name("email3"), contactData.getEmail3());

    }


    public void fillName(ContactData contactData) {
        name(By.name("firstname"), contactData.getFirstName());
        name(By.name("middlename"), contactData.getMiddleName());
        name(By.name("lastname"), contactData.getLastName());
    }

    public void returnPage() {
        click(By.linkText("home page"));
    }

    public void selectContactById(int id) {
        driver.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void deleteContact() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select all'])[1]/following::input[2]"));
        accept();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteContact();
        contactCache = null;
    }

    public void fillContactForm(ContactData contactData) {
        fillContact(contactData);
        fillBirthday();
    }

    public void edit() {
        click(By.xpath("((//tr[@name=\"entry\"]//input[@type=\"checkbox\"])[last()])/following::img[2]"));
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Edit / add address book entry'])[1]/following::form[1]"));
    }

    public void modifyContact() {
        click(By.xpath("((//tr[@name=\"entry\"]//input[@type=\"checkbox\"])[last()])/following::img[1]"));
        click(By.name("modifiy"));
    }

    public void update() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]"));
    }

    public void modify(ContactData contact) {
        selectContactById(contact.getId());
        edit();
        fillName(contact);
        update();
        returnPage();
        modifyContact();
        fillContact(contact);
        update();
        contactCache = null;
        returnPage();
    }

    public void create(ContactData contactData) {
        addContact();
        fillName(contactData);
        fillContactForm(contactData);
        submit();
        contactCache = null;
        returnPage();
    }

    public int count() {
        return driver.findElements(By.name("selected[]")).size();
    }

    private Contacts contactCache = null;


    public Contacts all() {
        contactCache = new Contacts();
        List<WebElement> elements = driver.findElements(By.name("entry"));
        if (elements.size() != 0) {
            for (WebElement element : elements) {
                List<WebElement> cells = element.findElements(By.tagName("td"));
                int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
                String lastname = cells.get(1).getText();
                String firstname = cells.get(2).getText();
                String address = cells.get(3).getText();
                String email = cells.get(4).findElement(By.xpath("./a[1]")).getText();
                String email2 = cells.get(4).findElement(By.xpath("./a[2]")).getText();
                String email3 = cells.get(4).findElement(By.xpath("./a[3]")).getText();
                String allEmail = cells.get(4).getText();
                String allPhones = cells.get(5).getText();
                List<String> phones = Arrays.asList(allPhones.split("\n"));
                String home = phones.get(0);
                String mobile = phones.get(1);
                String work = phones.get(2);
                contactCache.add(new ContactData().withId(id).withLastname(lastname).withFirstname(firstname)
                        .withAddress(address).withEmail(email).withEmail2(email2).withEmail3(email3)
                        .withAllEmail(allEmail).withHomePhone(home).withMobilePhone(mobile)
                        .withWorkPhone(work).withAllPhones(allPhones));
            }
        }
        return new Contacts(contactCache);
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = driver.findElement(By.name("firstname")).getAttribute("value");
        String lastname = driver.findElement(By.name("lastname")).getAttribute("value");
        String address = driver.findElement(By.name("address")).getAttribute("value");
        String email = driver.findElement(By.name("email")).getAttribute("value");
        String email2 = driver.findElement(By.name("email2")).getAttribute("value");
        String email3 = driver.findElement(By.name("email3")).getAttribute("value");
        String home = driver.findElement(By.name("home")).getAttribute("value");
        String work = driver.findElement(By.name("work")).getAttribute("value");
        String mobile = driver.findElement(By.name("mobile")).getAttribute("value");
        driver.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withAddress(address).withEmail(email).withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work)
                .withEmail2(email2).withEmail3(email3);
    }

    private void initContactModificationById(int id) {
        WebElement checkbox = driver.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();
    }
}
