package ru.ibs.steps;

import ru.ibs.managers.PageManager;
import ru.ibs.pages.BusinessTrips;
import ru.ibs.pages.MainPage;

public class MainPageSteps {
    public BusinessTripsSteps moveBusinessTrips(){
        // Шаг 3. В выплывающем окне раздела Расходы нажать на Командировки
        MainPage mainPage = PageManager.getPageManager().getPage(MainPage.class);
        mainPage.clickBusinessTripsButton();

        // Проверяем, что мы успешно перешли на страницу "Все Командировки"
        BusinessTrips businessTrips = PageManager.getPageManager().getPage(BusinessTrips.class);
        businessTrips.checkTitle();

        return new BusinessTripsSteps();
    }
}
