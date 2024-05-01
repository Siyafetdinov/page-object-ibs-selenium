package ru.ibs.steps;

import ru.ibs.managers.PageManager;
import ru.ibs.pages.CreateBusinessTrip;
import java.time.LocalDate;

public class CreateBusinessTripSteps {

    /**
     * Заполняем поле подразделение
     * @param businessUnit подразделение
     */
    public CreateBusinessTripSteps selectBusinessUnit(String businessUnit) {
        CreateBusinessTrip createBusinessTrip = PageManager.getPageManager().getPage(CreateBusinessTrip.class);
        createBusinessTrip.selectBusinessUnit(businessUnit);
        return this;
    }

    /**
     * Заполняем поле принимающая организация
     * @param nameCompany название компании
     */
    public CreateBusinessTripSteps selectCompany(String nameCompany){
        CreateBusinessTrip createBusinessTrip = PageManager.getPageManager().getPage(CreateBusinessTrip.class);
        createBusinessTrip.selectCompany(nameCompany);
        return this;
    }

    /**
     * Проставляем чекбокс заказа билетов
     */
    public CreateBusinessTripSteps selectOrderTickets(){
        CreateBusinessTrip createBusinessTrip = PageManager.getPageManager().getPage(CreateBusinessTrip.class);
        createBusinessTrip.selectOrderTickets();
        return this;
    }

    /**
     * Заполняем поле город выбытия
     * @param nameCity Город
     */
    public CreateBusinessTripSteps fieldDepartureCity(String nameCity){
        CreateBusinessTrip createBusinessTrip = PageManager.getPageManager().getPage(CreateBusinessTrip.class);
        createBusinessTrip.fieldDepartureCity(nameCity);
        return this;
    }

    /**
     * Заполняем поле город прибытия
     * @param nameCity Город
     */
    public CreateBusinessTripSteps fieldArrivalCity(String nameCity){
        CreateBusinessTrip createBusinessTrip = PageManager.getPageManager().getPage(CreateBusinessTrip.class);
        createBusinessTrip.fieldArrivalCity(nameCity);
        return this;
    }

    /**
     * Заполняем поле планируемая дата выезда
     * @param date Дата
     */
    public CreateBusinessTripSteps fieldDepartureDatePlan(LocalDate date){
        CreateBusinessTrip createBusinessTrip = PageManager.getPageManager().getPage(CreateBusinessTrip.class);
        createBusinessTrip.fieldDepartureDatePlan(date);
        return this;
    }

    /**
     * Заполняем поле планируемая дата возвращения
     * @param date Дата
     */
    public CreateBusinessTripSteps fieldReturnDatePlan(LocalDate date){
        CreateBusinessTrip createBusinessTrip = PageManager.getPageManager().getPage(CreateBusinessTrip.class);
        createBusinessTrip.fieldReturnDatePlan(date);
        return this;
    }

    /**
     * Нажимаем на кнопку сохранения
     */
    public CreateBusinessTripSteps clickSaveBtn(){
        CreateBusinessTrip createBusinessTrip = PageManager.getPageManager().getPage(CreateBusinessTrip.class);
        createBusinessTrip.clickBtnSaveAndExit();
        return this;
    }


    /**
     * Проверяем заполненные поля в форме
     * @param nameField наименование поля
     * @param value ожидаемое значение
     */
    public CreateBusinessTripSteps checkField(String nameField, String value){
        CreateBusinessTrip createBusinessTrip = PageManager.getPageManager().getPage(CreateBusinessTrip.class);
        createBusinessTrip.checkField(nameField, value);
        return this;
    }

    /**
     * Проверяем что ошибки есть на странице
     * @param errorText текст ошибки
     */
    public CreateBusinessTripSteps checkErrorMessage(String errorText){
        CreateBusinessTrip createBusinessTrip = PageManager.getPageManager().getPage(CreateBusinessTrip.class);
        createBusinessTrip.checkError(errorText);
        return this;
    }
}
