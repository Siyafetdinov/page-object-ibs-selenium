package ru.ibs.test;

import org.junit.jupiter.api.*;
import ru.ibs.base.BaseTest;
import ru.ibs.steps.LoginSteps;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@DisplayName("Задание 2")
public class TaskTest extends BaseTest {
    private final LocalDate date = LocalDate.now();
    private final LoginSteps loginSteps = new LoginSteps();

    @DisplayName("Задание 2")
    @Tag("Test_3")
    @Test
    public void taskTest() {
        // Производим авторизацию
        loginSteps
                .authorization(testPropManager.getProperty("login"), testPropManager.getProperty("password"))
                .moveBusinessTrips()
                .moveCreateNewBusinessTrip()

                // Заполняем поля
                .selectBusinessUnit("Отдел внутренней разработки")
                .selectCompany("Союз тестировщиков")
                .selectOrderTickets()
                .fieldDepartureCity("Россия, Саратов")
                .fieldArrivalCity("Россия, Калининград")
                .fieldDepartureDatePlan(date)
                .fieldReturnDatePlan(date.plusDays(10))

                // Проверяем поля
                .checkField("Подразделение", "Отдел внутренней разработки")
                .checkField("Принимающая организация", "Союз тестировщиков")
                .checkField("Задачи. Заказ билетов", "TRUE")
                .checkField("Город выбытия", "Россия, Саратов")
                .checkField("Город прибытия", "Россия, Калининград")
                .checkField("Планируемая дата выезда", date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")))
                .checkField("Планируемая дата возвращения", date.plusDays(10).format(DateTimeFormatter.ofPattern("dd.MM.yyyy")))

                .clickSaveBtn()
                .checkErrorMessage("Список командируемых сотрудников не может быть пустым");
    }
}
