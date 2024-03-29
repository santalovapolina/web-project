package tests.web;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

@Tag("ui")
@Owner(value = "Santalova Polina")
public class WebTests extends TestBase {
    static Stream<List<String>> headerItemsProvider() {
        return Stream.of(List.of("Взрослым", "Репетиторы",
                "Сертификаты", "Подготовиться к ЕГЭ", "Онлайн-тест", "Учителям", "Другие курсы"));
    }
    @Test
    @DisplayName("В верхнем меню 7 разделов")
    @Severity(SeverityLevel.CRITICAL)
    public void checkHeaderMenuSectionsTest() {

        step("Перейти на главную страницу", () ->
                mainPage.openPage());
        step("Проверить, что верхнее меню состоит из 7 разделов", () ->
                mainPage.verifyHeaderMenuSize());
    }

    @ParameterizedTest(name = "В верхнем меню отображаются кнопки {0}")
    @MethodSource("headerItemsProvider")
    @Severity(SeverityLevel.CRITICAL)
    public void checkHeaderMenuButtonsTest(List<String> buttons) {

        step("Перейти на главную страницу", () ->
                mainPage.openPage());
        step("Проверить, что в верхнем меню есть кнопки {0}", () ->
                mainPage.verifyHeaderMenuItems(buttons));
    }

    @ParameterizedTest(name = "В разделе {0} есть формат {1}")
    @CsvSource(value = {"Взрослым, Self-Study"})
    @Severity(SeverityLevel.NORMAL)
    public void checkProductFormForMenuItemTest(String menuItem, String productForm) {

        step("Перейти на главную страницу", () ->
                mainPage.openPage());
        step("Навести курсор на раздел", () ->
                mainPage.hoverMenuItem(menuItem));
        step("Проверить, что в каталоге есть нужный формат", () ->
                mainPage.verifyProduct(productForm));
    }

    @Test
    @Disabled
    @DisplayName("По ссылке Пройти тест осуществляется переход к тесту на подбор курса")
    @Severity(SeverityLevel.CRITICAL)
    public void checkSwitchingToCoursesTestThruLink() {

        step("Перейти на главную страницу", () ->
                mainPage.openPage());
        step("Кликнуть Пройти тест", () ->
                mainPage.clickPassTest());
        step("Проверить, что тест отобразился", () ->
                mainPage.verifyQuizAppears());
        step("Проверить заголовок теста", () ->
                mainPage.verifyQuizTitle());
    }

    @Disabled
    @ParameterizedTest(name = "После выбора цели обучения {0} и уровня языка {1} отображаются подходящие курсы")
    @CsvSource(value = {"Для работы, Средний", "Для заграничных поездок, Начинающий"})
    @Severity(SeverityLevel.NORMAL)
    public void checkCoursesResultDependsOnUserPurposeAndLevel(String purpose, String level) {

        step("Перейти на главную страницу", () ->
                mainPage.openPage());
        step("Выбрать цель обучения и уровень владения языком", () ->
                mainPage.setPurposeAndLevel(purpose, level));
        step("Проверить, что отобразился прогресс бар", () ->
                mainPage.verifyProgressBarAppears());
        step("Проверить, что отобразились подходящие курсы", () ->
                mainPage.verifySuitableCourses());
    }

    @ParameterizedTest(name = "В блоке {0} должен быть формат {1}")
    @CsvSource(value = {"Форматы обучения, Тренажёр слов"})
    @Severity(SeverityLevel.NORMAL)
    public void checkStudyFormExistsOnStudyFormSectionTest(String studyFormsTitle, String studyForm) {

        step("Перейти на страницу Self-Study", () ->
                selfStudyPage.openPage());
        step("Проверить заголовок страницы", () ->
                selfStudyPage.verifyHeader());
        step("Проверить, что в Форматах обучения есть Тренажер слов", () ->
                selfStudyPage.verifyStudyFormExists(studyFormsTitle, studyForm));
    }

    @ParameterizedTest(name = "На странице {0} должно быть {1}")
    @CsvSource(value = {"/clubs, Расписание"})
    @Severity(SeverityLevel.NORMAL)
    public void checkFeatureExistsOnPage(String page, String feature) {

        step("Перейти на страницу {0}", () ->
                clubsPage.openPage(page));
        step("Проверить, что на странице есть {1}", () ->
                clubsPage.verifyFeature(feature));
    }
}
