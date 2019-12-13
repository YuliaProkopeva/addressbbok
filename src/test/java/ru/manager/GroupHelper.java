package ru.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.model.GroupData;
import ru.model.Groups;

import java.util.List;


public class GroupHelper extends BaseHelper {

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void deleteGroup() {
        click(By.name("delete"));
    }

    public void selectGroupById(int id) {
        driver.findElement(By.cssSelector("input[value='" + id + "']")).click();
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

    public void returnPage() {
        click(By.linkText("group page"));
    }

    public void create(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        groupCache = null;
        returnPage();
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

    public void modify(GroupData group) {
        selectGroupById(group.getId());
        changeGroup(group);
        updateGroup();
        groupCache = null;
        returnPage();
    }

    public void delete(GroupData group) {
        selectGroupById(group.getId());
        deleteGroup();
        groupCache = null;
        returnPage();
    }

    public int count() {
        return driver.findElements(By.name("selected[]")).size();
    }

    private Groups groupCache = null;

    public Groups all() {
        if (groupCache != null) {
            return new Groups(groupCache);
        }
        groupCache = new Groups();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        if (elements.size() != 0) {
            for (WebElement element : elements) {
                String name = element.getText();
                int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
                groupCache.add(new GroupData().withId(id).withName(name));
            }
        }
        return new Groups(groupCache);
    }

}
