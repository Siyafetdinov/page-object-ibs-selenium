package ru.ibs.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateBusinessTrip extends BasePage {
    @FindBy(xpath = "//h1[@class='user-name']")
    WebElement titlePage;
    @FindBy(xpath = "//select[@data-name='field__business-unit']")
    WebElement businessUnitSelect;
    @FindBy(xpath = "//a[@id='company-selector-show']")
    WebElement companySelectShow;
    @FindBy(xpath = "//span[@class='select2-chosen' and text()='Укажите организацию']")
    WebElement companyChosen;
    @FindBy(xpath = "//input[@data-name='field__company']")
    WebElement companySelect;
    @FindBy(xpath = "//label[text()='Заказ билетов']//..//input")
    WebElement orderTickets;
    @FindBy(xpath = "//input[@data-name='field__departure-city']")
    WebElement departureCity;
    @FindBy(xpath = "//input[@data-name='field__arrival-city']")
    WebElement arrivalCity;
    @FindBy(xpath = "//input[contains(@name, 'date_selector_crm_business_trip_departureDatePlan')]")
    WebElement departureDatePlan;
    @FindBy(xpath = "//input[contains(@name, 'date_selector_crm_business_trip_returnDatePlan')]")
    WebElement returnDatePlan;
    @FindBy(xpath = "//button[@class = 'btn btn-success action-button']")
    WebElement saveAndExitBtn;
    @FindBy(xpath = "//span[@class='validation-failed']")
    List<WebElement> errorsElements;

    public void checkTitle() {
        super.checkTitle(titlePage, "Создать командировку");
    }

    public void selectBusinessUnit(String businessUnit) {
        new Select(businessUnitSelect).selectByVisibleText(businessUnit);
    }

    public void selectCompany(String nameCompany) {
        new Actions(driver)
                .click(companySelectShow)
                .click(companyChosen)
                .sendKeys(nameCompany)
                .perform();

        driver.findElement(By.xpath(
                String.format("//span[@class='select2-match' and text()='%s']", nameCompany))).click();
    }

    public void selectOrderTickets() {
        orderTickets.click();
    }

    public void fieldDepartureCity(String nameCity) {
        departureCity.clear();
        departureCity.sendKeys(nameCity);
    }

    public void fieldArrivalCity(String nameCity) {
        arrivalCity.sendKeys(nameCity);
    }

    public void fieldDepartureDatePlan(LocalDate date) {
        departureDatePlan.sendKeys(date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + Keys.ESCAPE);
    }

    public void fieldReturnDatePlan(LocalDate date) {
        returnDatePlan.sendKeys(date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + Keys.ESCAPE);
    }

    public void clickBtnSaveAndExit() {
        saveAndExitBtn.click();
        super.waitPageLoader();
    }

    public void checkField(String nameField, String value) {
        switch (nameField) {
            case "Подразделение": {
                assertEquals(value, new Select(businessUnitSelect).getFirstSelectedOption().getText(),
                        "Поле подразделение заполнено некорректно");
                break;
            }
            case "Принимающая организация": {
                assertEquals(value, companySelect.getAttribute("value"),
                        "Поле с выбором организации заполнено некорректно");
                break;
            }
            case "Задачи. Заказ билетов": {
                assertEquals(Boolean.parseBoolean(value), orderTickets.isSelected(), "Чекбокс 'Заказ билетов' не поставлен");
                break;
            }
            case "Город выбытия": {
                assertEquals(value, departureCity.getAttribute("value"),
                        "Поле с городом выбытия заполнено некорректно");
                break;

            }
            case "Город прибытия": {
                assertEquals(value, arrivalCity.getAttribute("value"),
                        "Поле с городом прибытия заполнено некорректно");
                break;
            }
            case "Планируемая дата выезда": {
                assertEquals(value, departureDatePlan.getAttribute("value"),
                        "Поле с планируемой датой выезда, заполнено некорректно");
                break;
            }
            case "Планируемая дата возвращения": {
                assertEquals(value, returnDatePlan.getAttribute("value"),
                        "Поле с планируемой датой выезда, заполнено некорректно");
                break;
            }
        }
    }

    public void checkError(String errorText) {
        List<WebElement> elements = errorsElements;
        elements.forEach(element -> Assertions.assertTrue(element.getText().equals(errorText)));
    }

}
