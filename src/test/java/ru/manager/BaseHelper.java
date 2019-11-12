package ru.manager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;


public class BaseHelper {
    protected WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void name(By locator, String text) {
        click(locator);
        if (text != null) {
            String existingText = driver.findElement(locator).getAttribute("value");
            if (!text.equals(existingText)) {
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(text);
            }
        }
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    protected void accept() {
        driver.switchTo().alert().accept();
    }

    protected void selectFromListOfValue(String text, By locator) {
        new Select(driver.findElement(locator)).selectByVisibleText(text);
    }

}


