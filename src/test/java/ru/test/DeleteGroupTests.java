package ru.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.model.GroupData;
import ru.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class DeleteGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("test2"));
        }
    }

    @Test
    public void deleteGroup() {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        assertThat(app.group().count(), equalTo(before.size() - 1));
        Groups after = app.group().all();
        assertThat(after, equalTo(before.without(deletedGroup)));
    }

}
