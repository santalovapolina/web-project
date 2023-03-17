package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

public class WebTests extends TestBase {
    static Stream<List<String>> headerItemsProvider() {
        return Stream.of(List.of("Взрослым", "Репетиторы",
                "Подарочные сертификаты", "Онлайн-тест", "Учителям", "Другие курсы"));
    }

    @Tag("ui")
    @DisplayName("В верхнем меню 6 разделов")
    @Test
    public void positiveTest1() {

        step("Перейти на главную страницу", () ->
                mainPage.openPage());
        step("Проверить, что верхнее меню состоит из 6 разделов", () ->
                mainPage.verifyHeaderMenuSize());
    }

    @Tag("ui")
    @MethodSource("headerItemsProvider")
    @ParameterizedTest(name = "В верхнем меню отображаются кнопки {0}")
    void parameterizedTest1(List<String> buttons) {

        step("Перейти на главную страницу", () ->
                mainPage.openPage());
        step("Проверить, что в верхнем меню есть кнопки {0}", () ->
                mainPage.verifyHeaderMenuItems(buttons));
    }

    @Tag("ui")
    @CsvSource(value = {"Взрослым, Self-Study"})
    @ParameterizedTest(name = "В разделе {0} есть формат {1}")
    public void positiveTest2(String menuItem, String productForm) {

        step("Перейти на главную страницу", () ->
                mainPage.openPage());
        step("Навести курсор на раздел {0}", () ->
                mainPage.hoverMenuItem(menuItem));
        step("Проверить, что в каталоге есть формат {1}", () ->
                mainPage.verifyProduct(productForm));
    }

    @Tag("ui")
    @DisplayName("По ссылке Пройти тест осуществляется переход к тесту на подбор курса")
    @Test
    public void positiveTest3() {

        step("Перейти на главную страницу", () ->
                mainPage.openPage());
        step("Кликнуть Пройти тест", () ->
                mainPage.clickPassTest());
        step("Проверить, что тест отобразился", () ->
                mainPage.verifyQuizAppears());
        step("Проверить заголовок теста", () ->
                mainPage.verifyQuizTitle());
    }

    @Tag("ui")
    @CsvSource(value = {"Для работы, Средний", "Для заграничных поездок, Начинающий"})
    @ParameterizedTest(name = "После выбора цели обучения {0} и уровня языка {1} отображаются подходящие курсы")
    public void positiveTest4(String purpose, String level) {

        step("Перейти на главную страницу", () ->
                mainPage.openPage());
        step("Выбрать цель обучения и уровень владения языком", () ->
                mainPage.setPurposeAndLevel(purpose, level));
        step("Проверить, что отобразился прогресс бар", () ->
                mainPage.verifyProgressBarAppears());
        step("Проверить, что отобразились подходящие курсы", () ->
                mainPage.verifySuitableCourses());
    }

    @Tag("ui")
    @CsvSource(value = {"Форматы обучения, Тренажёр слов"})
    @ParameterizedTest(name = "В блоке {0} должен быть формат {1}")
    public void positiveTest5(String studyFormsTitle, String studyForm) {

        step("Перейти на страницу Self-Study", () ->
                selfStudyPage.openPage());
        step("Проверить заголовок страницы", () ->
                selfStudyPage.verifyHeader());
        step("Проверить, что в {0} есть {1}", () ->
                selfStudyPage.verifyStudyFormExists(studyFormsTitle, studyForm));
    }

    @Tag("ui")
    @CsvSource(value = {"/clubs, Расписание"})
    @ParameterizedTest(name = "На странице {0} должно быть {1}")
    public void positiveTest6(String page, String feature) {

        step("Перейти на страницу {0}", () ->
                clubsPage.openPage(page));
        step("Проверить, что на странице есть {1}", () ->
                clubsPage.verifyFeature(feature));
    }
}
