package ru.test;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.manager.ApplicationManager;

public class TestBase {


    protected final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

    @BeforeClass
    public void setUp() {
        app.init();
    }

    @AfterClass
    public void tearDown() {
        app.stop();
    }

}

