package ru.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.model.GroupData;

public class ChangeGroupTests extends TestBase {

    @BeforeClass
    public void setUp() {
        app.init();
        app.getGroupHelper().isThereAGroup();
    }

    @Test
    public void changeGroup() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().changeGroup(new GroupData("test7", "test8", "test9"));
        app.getGroupHelper().updateGroup();
        app.getGroupHelper().returnToGroupPage();
    }
}
