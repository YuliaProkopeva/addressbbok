package ru.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.model.GroupData;
import java.util.Comparator;
import java.util.List;

public class CreateGroupTests extends TestBase {

    @Test
    public void createGroup() {
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        GroupData group = new GroupData("test7", "test2", "test3");
        app.getGroupHelper().createGroup(group);
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        before.add(group);
        Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}



