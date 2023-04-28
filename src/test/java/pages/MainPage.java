package pages;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private static final String QUIZ_TITLE = "Узнайте, какой курс вам подходит";

    public MainPage openPage() {
        open(baseUrl);
        return this;
    }

    public MainPage verifyHeaderMenuSize() {
        $(".navigation").$$(".navigation-item").shouldHave(size(6));
        return this;
    }

    public MainPage verifyHeaderMenuItems(List<String> buttons) {
        $$(".header-menu-item").filter(visible).shouldHave(texts(buttons));
        return this;
    }

    public MainPage hoverMenuItem(String menuItem) {
        $("div.header-menu-toggle-container").$(byText(menuItem)).hover();
        return this;
    }

    public MainPage verifyProduct(String productForm) {
        $x("(//div[@class='product-catalog-container'])[2]").shouldHave(text(productForm));
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
        $x("//h3[@class='quiz-title']").shouldHave(text(QUIZ_TITLE));
        return this;
    }

    public MainPage setPurposeAndLevel(String purpose, String level) {
        $$x("//home-quiz-selection-item").findBy(text(purpose))
                .shouldBe(visible, Duration.ofSeconds(10)).click();
        $$x("//home-quiz-selection-item").findBy(text(level))
                .shouldBe(visible, Duration.ofSeconds(10)).click();
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
