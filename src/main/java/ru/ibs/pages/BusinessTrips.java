package ru.ibs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BusinessTrips extends BasePage {
    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    WebElement titlePage;

    @FindBy(xpath = "//a[@title='Создать командировку']")
    WebElement createBusinessTripBtn;

    public void checkTitle() {
        super.checkTitle(titlePage, "Все Командировки");
    }

    public void clickCreateBusinessTripBtn() {
        createBusinessTripBtn.click();
        waitPageLoader();
    }
}
