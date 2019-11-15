package ru.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.model.GroupData;

public class ChangesHelper extends BaseHelper {

    public ChangesHelper(WebDriver driver) {
        super(driver);
    }

    public void clickEditContact() {
        click(By.xpath("((//tr[@name=\"entry\"]//input[@type=\"checkbox\"])[last()])/following::img[2]"));
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Edit / add address book entry'])[1]/following::form[1]"));
    }

    public void clickModifyContact() {
        click(By.xpath("((//tr[@name=\"entry\"]//input[@type=\"checkbox\"])[last()])/following::img[1]"));
        click(By.name("modifiy"));
    }

    public void pressUpdateButton() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]"));
    }

    public void changeGroup(GroupData groupData) {
        click(By.name("edit"));
        name(By.name("group_name"), groupData.getName());
        name(By.name("group_header"), groupData.getHeader());
        name(By.name("group_footer"), groupData.getFooter());
    }

    public void updateGroup() {
        click(By.name("update"));
    }
}

