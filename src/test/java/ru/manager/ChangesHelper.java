package ru.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.model.ContactEdit;
import ru.model.ContactModify;

public class ChangesHelper extends BaseHelper {

    public ChangesHelper(WebDriver driver) {
        super(driver);
    }

    public void clickEditContact() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='test5test6test7'])[9]/following::img[2]"));
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Edit / add address book entry'])[1]/following::form[1]"));
    }

    public void clickModifyContact() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='test5test6test7'])[9]/following::img[1]"));
        click(By.name("modifiy"));
    }

    public void pressUpdateButton() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]"));
    }
}
