package ru.test;

import org.testng.annotations.Test;
import ru.model.ContactData;
import ru.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class CreateContactTests extends TestBase {

    @Test
    public void createContact() {
        app.goTo().contactPage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withFirstname("test3").withLastname("test7").withAddress("test5")
                .withEmail("test3@test.test").withHomePhone("test7").withMobilePhone("test8").withWorkPhone("test9")
                .withEmail2("test4@test.test").withEmail3("test8@test.test");
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt(ContactData::getId).max().getAsInt()))));


    }

}
