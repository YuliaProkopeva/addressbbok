package ru.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.model.GroupData;

public class GroupHelper extends BaseHelper {

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void deleteGroup() {
        click(By.name("selected[]"));
        click(By.name("delete"));
    }

    public void updateGroup() {
        click(By.name("update"));
    }

    public void changeGroup(GroupData groupData) {
        click(By.name("selected[]"));
        click(By.name("edit"));
        name(By.name("group_name"), groupData.getName());
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        name(By.name("group_name"), groupData.getName());
        name(By.name("group_header"), groupData.getHeader());
        name(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }
}
