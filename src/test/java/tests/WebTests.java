package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class WebTests extends TestBase {

    @Tag("ui")
    @DisplayName("В верхнем меню 6 разделов")
    @Test
    public void positiveTest1() {
        step("Перейти на главную страницу", () -> {
            mainPage.openPage();
        });
        step("Проверить, что верхнее меню состоит из 6 разделов", () -> {
            mainPage.verifyHeaderMenuItems();
        });
    }


    @Tag("ui")
    @DisplayName("В разделе Взрослым есть формат Self-Study")
    @Test
    public void positiveTest2() {
        step("Перейти на главную страницу", () -> {
            mainPage.openPage();
        });
        step("Навести курсор на раздел Взрослым", () -> {
            mainPage.hoverMenuItem();
        });
        step("Проверить, что в каталоге есть формат Self-Study", () -> {
            mainPage.verifyProduct();
        });
    }

    @Tag("ui")
    @DisplayName("По ссылке Пройти тест осуществляется переход к тесту на подбор курса")
    @Test
    public void positiveTest3() {
        step("Перейти на главную страницу", () -> {
            mainPage.openPage();
        });
        step("Кликнуть Пройти тест", () -> {
            mainPage.clickPassTest();
        });
        step("Проверить, что тест отобразился", () -> {
            mainPage.verifyQuizAppears();
        });
        step("Проверить заголовок теста", () -> {
            mainPage.verifyQuizTitle();
        });

    }

    @Tag("ui")
    @DisplayName("После прохождения теста предлагаются подходящие курсы")
    @Test
    public void positiveTest4() {
        step("Перейти на главную страницу", () -> {
            mainPage.openPage();
        });
        step("Выбрать цель обучения", () -> {
            mainPage.setLearningPurpose();
        });
        step("Выбрать уровень владения языком", () -> {
            mainPage.setEnglishLevel();
        });
        step("Проверить, что отобразился прогресс бар", () -> {
            mainPage.verifyProgressBarAppears();
        });
        step("Проверить, что отобразились подходящие курсы", () -> {
            mainPage.verifySuitableCourses();
        });
    }

    @Tag("ui")
    @DisplayName("В форматах обучения должен быть Тренажёр слов")
    @Test
    public void positiveTest5() {
        step("Перейти на страницу Self-Study", () -> {
            selfStudyPage.openPage();
        });
        step("Проверить заголовок страницы", () -> {
            selfStudyPage.verifyHeader();
        });
        step("Проверить, что в форматах обучения есть Тренажёр слов", () -> {
            selfStudyPage.verifyStudyFormExists();
        });
    }

    @Tag("ui")
    @DisplayName("В разделе Клубы должно быть расписание")
    @Test
    public void positiveTest6() {
        step("Перейти на страницу Разговорные клубы", () -> {
            clubsPage.openPage();
        });
        step("Проверить, что на странице есть расписание", () -> {
            clubsPage.verifySchedule();
        });

    }

}
