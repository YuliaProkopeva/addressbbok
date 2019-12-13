package ru.test;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.*;
import ru.manager.ApplicationManager;

public class TestBase {


    protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}

