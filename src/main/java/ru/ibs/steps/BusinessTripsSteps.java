package ru.ibs.steps;

import ru.ibs.managers.PageManager;
import ru.ibs.pages.BusinessTrips;
import ru.ibs.pages.CreateBusinessTrip;

public class BusinessTripsSteps {

    public CreateBusinessTripSteps moveCreateNewBusinessTrip() {
        // Шаг 4. Нажать на "Создать командировку"
        BusinessTrips businessTrips = PageManager.getPageManager().getPage(BusinessTrips.class);
        businessTrips.clickCreateBusinessTripBtn();


        // Шаг 5. Проверить наличие на странице заголовка "Создать командировку"
        CreateBusinessTrip createBusinessTrip = PageManager.getPageManager().getPage(CreateBusinessTrip.class);
        createBusinessTrip.checkTitle();

        return new CreateBusinessTripSteps();
    }
}
