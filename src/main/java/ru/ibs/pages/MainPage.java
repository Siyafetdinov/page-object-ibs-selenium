package ru.ibs.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPage extends BasePage {
    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    WebElement titlePage;

    @FindBy(xpath = "//ul[contains(@class,'main-menu')]/li/a/span[@class='title' and text()='Расходы']")
    WebElement costList;

    @FindBy(xpath = "//ul[contains(@class,'main-menu')]/li/a/span[@class='title' and text()='Расходы']" +
            "/ancestor::li//ul[@class='dropdown-menu menu_level_1']")
    WebElement businessTripsButton;

    public void checkTitle() {
        super.checkTitle(titlePage, "Панель быстрого запуска");
    }

    public void clickBusinessTripsButton() {
        new Actions(driver)
                .moveToElement(costList)
                .click(businessTripsButton)
                .perform();

        waitPageLoader();
    }
}
