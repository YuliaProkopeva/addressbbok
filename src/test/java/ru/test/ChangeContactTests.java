package ru.test;

import org.testng.annotations.Test;
import ru.model.*;

public class ChangeContactTests extends TestBase {

    @Test
    public void changeContact()  {
        app.getContactHelper().goToHomePage();
        app.getChangesHelper().clickEditContact();
        app.getContactHelper().fillContactName(new ContactUser("test3", "test7", "test8"));
        app.getChangesHelper().pressUpdateButton();
        app.getChangesHelper().clickModifyContact();
        app.getContactHelper().fillPhone(new ContactPhones("test12", "test1", "test4"));
        app.getChangesHelper().pressUpdateButton();
    }

}
