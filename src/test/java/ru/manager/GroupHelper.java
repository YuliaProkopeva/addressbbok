package ru.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.model.GroupData;

import java.util.ArrayList;
import java.util.List;


public class GroupHelper extends BaseHelper {

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void deleteGroup() {
        click(By.name("delete"));
    }

    public void selectGroup(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
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

    public void createGroup(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
    }

    public void isThereAGroup() {
        NavigationHelper navigationHelper = new NavigationHelper(driver);
        navigationHelper.gotoGroupPage();
        if (!isElementPresent(By.name("selected[]"))) {
            createGroup(new GroupData("test1", "test2", "test3"));
        }
    }

    public List<GroupData> getGroupList() {
        List<GroupData>  groups = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        if(elements.size() != 0) {
            for (WebElement element : elements) {
                String name = element.getText();
                int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
                GroupData group = new GroupData(id, name, null, null);
                groups.add(group);
            }
        }
        return  groups;
    }

}
