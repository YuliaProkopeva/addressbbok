package ru.stqa.pft.addressbook.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver driver;
    private SessionHelper sessionHelper;
    private ContactHelper contactHelper;

    public void init() {
        driver = new FirefoxDriver();
        driver.get("http://localhost/addressbook/group.php");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        contactHelper = new ContactHelper(driver);
        sessionHelper = new SessionHelper(driver);
        sessionHelper.login("admin", "secret");
    }

       public void stop() {
        driver.quit();
    }

    public void gotoAddContact() {
      driver.findElement(By.linkText("add new")).click();
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

}
