package ru.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.manager.ApplicationManager;

public class TestBase {


    protected final ApplicationManager app = new ApplicationManager();
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        app.init();
    }

       @AfterClass
    public void tearDown(){
        app.stop();
    }

    }

