package ru.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.model.GroupData;
import java.util.Comparator;
import java.util.List;

public class ChangeGroupTests extends TestBase {

    @BeforeClass
    public void setUp() {
        app.init();
        app.getGroupHelper().isThereAGroup();
    }

    @Test
    public void changeGroup() {
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        GroupData group = new GroupData(before.get(before.size() - 1).getId(), "test1", "test8", "test9");
        app.getChangesHelper().changeGroup(group);
        app.getChangesHelper().updateGroup();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
        before.sort(byId);
        after.sort(byId);
        if (!before.get(before.size() - 1).getName().equals(group.getName())) {
            Assert.assertNotEquals(before.get(before.size() - 1), after.get(after.size() - 1));
            before.remove(before.size() - 1);
            after.remove(after.size() - 1);
        }
        Assert.assertEquals(before, after);
    }
}
