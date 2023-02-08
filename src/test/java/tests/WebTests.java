package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class WebTests extends TestBase {

    @Tag("ui")
    @DisplayName("В верхнем меню отображается 6 разделов")
    @Test
    public void positiveTest1() {
        mainPage.openPage();
        mainPage.verifyHeaderMenuItems();
    }


    @Tag("ui")
    @DisplayName("В разделе Взрослым есть формат Self-Study")
    @Test
    public void positiveTest2() {
        mainPage.openPage();
        mainPage.hoverMenuItem();
        mainPage.verifyProduct();
    }

    @Tag("ui")
    @DisplayName("По ссылке Пройти тест осуществляется переход к тесту на подбор курса")
    @Test
    public void positiveTest3() {
        mainPage.openPage();
        mainPage.clickPassTest();
        mainPage.verifyQuizAppears();
        mainPage.verifyQuizTitle();
    }

    @Tag("ui")
    @DisplayName("В форматах обучения должен быть Тренажёр слов")
    @Test
    public void positiveTest4() {
        selfStudyPage.openPage();
        selfStudyPage.verifyHeader();
        selfStudyPage.verifyStudyFormExists();
    }

    @Tag("ui")
    @DisplayName("В разделе Клубы должно быть расписание")
    @Test
    public void positiveTest5() {
        clubsPage.openPage();
        clubsPage.verifySchedule();
    }

    @Tag("ui")
    @DisplayName("При выборе цели обучения и уровня владения языком предлагаются подходящие курсы")
    @Test
    public void positiveTest6() {
        mainPage.openPage();
        mainPage.setLearningPurpose();
        mainPage.setEnglishLevel();
        mainPage.verifyProgressBarAppears();
        mainPage.verifySuitableCourses();
    }

}
