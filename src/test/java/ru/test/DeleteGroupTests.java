package ru.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.model.GroupData;
import java.util.List;


public class DeleteGroupTests extends TestBase {

    @BeforeClass
    public void setUp() {
        app.init();
        app.getGroupHelper().isThereAGroup();
    }

    @Test
    public void deleteGroup() {
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}
