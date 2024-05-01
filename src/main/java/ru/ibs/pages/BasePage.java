package ru.ibs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.managers.DriverManager;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class BasePage {
    protected DriverManager driverManager = DriverManager.getDriverManager();
    protected WebDriver driver = driverManager.getDriver();
    private WebDriverWait wait = new WebDriverWait(driver,
            Duration.ofSeconds(20, 1000));

    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    protected void waitPageLoader() {
        waitUntilElementToBeInvisible(driver.findElement(By.xpath("//div[@class='loader-mask shown']")));
    }

    protected Boolean waitUntilElementToBeInvisible(WebElement element) {
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected WebElement waitUntilElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void checkTitle(WebElement element, String expectedTitle) {
        Assertions.assertAll(
                () -> assertTrue(element.isDisplayed(),
                        "Заголовок не отображается"),
                () -> assertEquals(expectedTitle, element.getText(),
                        "Текст заголовка не соответствует ожидаемому")
        );
    }
}
