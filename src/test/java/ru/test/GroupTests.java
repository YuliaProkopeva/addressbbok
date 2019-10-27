package ru.test;

import org.testng.annotations.Test;
import ru.model.GroupData;

public class GroupTests extends TestBase {


    @Test
    public void testGroup() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        app.getGroupHelper().changeGroup(new GroupData("test1", "test2", "test3"));
        app.getGroupHelper().updateGroup();
        app.getGroupHelper().returnToGroupPage();
        app.getGroupHelper().deleteGroup();
    }

}



