package ru.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.model.ContactData;
import ru.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ChangeContactTests extends TestBase {

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
    public void changeContact() {
        app.goTo().contactPage();
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData user = new ContactData().withId(modifiedContact.getId()).withLastname("test9").withFirstname("test8")
                .withHomePhone("test5").withMobilePhone("test7").withWorkPhone("test8")
                .withEmail("test4@test.ru").withEmail2("test9@test.ru").withEmail3("test6@test.ru").withAddress("test8");
        app.contact().modify(user);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(user)));
    }
}
