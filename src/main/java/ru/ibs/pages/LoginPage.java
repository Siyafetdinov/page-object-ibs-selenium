package ru.ibs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@name='_username']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@name='_password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@name='_submit']")
    private WebElement submitBtn;

    public void fieldLogin(String login) {
        // loginField.sendKeys(login);
        driver.findElement(By.xpath("//input[@name='_username']")).sendKeys(login);
    }

    public void fieldPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void submitClick() {
        submitBtn.click();
    }
}
