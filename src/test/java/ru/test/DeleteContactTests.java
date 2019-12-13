package ru.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.model.ContactData;
import ru.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteContactTests extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().contactPage();
        if (app.contact().all().size() == 0) {
            app.contact().addContact();
            ContactData contact = new ContactData().withFirstname("test3").withLastname("test7").withAddress("test5")
                    .withEmail("test3@test.test").withHomePhone("test7").withMobilePhone("test8").withWorkPhone("test9")
                    .withEmail2("test4@test.test").withEmail3("test8@test.test");
            app.contact().fillName(contact);
            app.contact().fillContactForm(contact);
            app.contact().submit();
            app.contact().returnPage();
        }
    }

    @Test
    public void deleteContact() {
        app.goTo().contactPage();
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        app.goTo().contactPage();
        assertThat(app.contact().count(), equalTo(before.size() - 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.without(deletedContact)));
    }

}

