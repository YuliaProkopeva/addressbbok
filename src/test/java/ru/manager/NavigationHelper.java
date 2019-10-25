package ru.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends BaseHelper {

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void gotoGroupPage() {
        click(By.linkText("groups"));
    }
    public void goToHomePage() {
        click(By.linkText("home"));
    }
}
