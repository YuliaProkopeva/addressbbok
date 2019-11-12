package ru.test;

import org.testng.annotations.Test;
import ru.model.GroupData;

public class CreateGroupTests extends TestBase {

    @Test
    public void createGroup() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
        app.getGroupHelper().returnToGroupPage();
    }

}



