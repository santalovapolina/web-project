package pages;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {


    public MainPage openPage() {
        open("https://skyeng.ru");
        return this;
    }

    public MainPage verifyHeaderMenuItems() {
        $(".navigation").$$(".navigation-item").shouldHave(size(6));
        return this;
    }

    public MainPage hoverMenuItem() {
        $("div.header-menu-toggle-container").$(byText("Взрослым")).hover();
        return this;
    }

    public MainPage verifyProduct() {
        $x("(//div[@class='product-catalog-container'])[2]").shouldHave(text("Self-Study"));
        return this;
    }

    public MainPage clickPassTest() {
        $x("//div[@class='note-item -desktop']/span[@class='note-link']").click();
        return this;
    }

    public MainPage verifyQuizAppears() {
        $x("//div[@class='quiz-body']").should(appear);
        return this;
    }

    public MainPage verifyQuizTitle() {
        $x("//h3[@class='quiz-title']").shouldHave(text("Узнайте, какой курс вам подходит"));
        return this;
    }

    public MainPage setLearningPurpose() {
        $$x("//home-quiz-selection-item").findBy(text("Для работы")).click();
        return this;
    }

    public MainPage setEnglishLevel() {
        $$x("//home-quiz-selection-item").findBy(text("Средний")).click();
        return this;
    }

    public MainPage verifyProgressBarAppears() {
        $x("//home-quiz-progress-circle[@class='loader']").should(appear);
        return this;
    }

    public MainPage verifySuitableCourses() {
        $x("//div[@class='courses-list']").should(exist);
        return this;
    }
}
