package ru.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class DeleteGroupTests extends TestBase {

    @BeforeClass
    public void setUp() {
        app.init();
        app.getGroupHelper().isThereAGroup();
    }

    @Test
    public void deleteGroup() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returnToGroupPage();
    }
}
