package ru.ibs.steps;

import ru.ibs.managers.PageManager;
import ru.ibs.pages.LoginPage;
import ru.ibs.pages.MainPage;

public class LoginSteps {
    public MainPageSteps authorization(String login, String password){
        // Производим авторизацию
        LoginPage loginPage = PageManager.getPageManager().getPage(LoginPage.class);
        loginPage.fieldLogin(login);
        loginPage.fieldPassword(password);
        loginPage.submitClick();

        // Шаг 2. Проверяем что заголовок "Панель быстрого запуска" есть на странице
        MainPage mainPage = PageManager.getPageManager().getPage(MainPage.class);
        mainPage.checkTitle();
        return new MainPageSteps();
    }
}
