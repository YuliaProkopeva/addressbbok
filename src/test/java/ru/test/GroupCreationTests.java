package ru.test;

import org.testng.annotations.Test;
import ru.model.GroupData;

public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation()  {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.getGroupHelper().submitGroupCreation();
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().changeGroup(new GroupData("test4", "test2", "test3"));
    app.getGroupHelper().updateGroup();
    app.getGroupHelper().returnToGroupPage();
    app.getGroupHelper().deleteGroup();
  }

}



