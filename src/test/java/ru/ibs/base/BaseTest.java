package ru.ibs.base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import ru.ibs.managers.DriverManager;
import ru.ibs.managers.TestPropManager;

public class BaseTest {
    protected static WebDriver driver = DriverManager.getDriverManager().getDriver();
    protected static final TestPropManager testPropManager = TestPropManager.getPropertyManager();

    @BeforeAll
    public static void setUp() {
        driver.get(testPropManager.getProperty("url.home"));
    }

    @AfterAll()
    public static void tearDown() {
        driver.quit();
        driver = null;
    }
}
