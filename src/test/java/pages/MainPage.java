package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

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

    private ElementsCollection headerTabs = $(".navigation").$$(".navigation-item"),
            headerTabsTitles = $$x("//div[@class='header-menu-item']"),
            purposeAndLevel = $$x("//home-quiz-selection-item"),
            productForms = $$x("//div[@class='product-catalog-title']");

    private final SelenideElement headerToggleMenu = $("div.header-menu-toggle-container"),
            quiz = $x("//div[@class='quiz-body']"),
            quizTitle = $x("//h3[@class='quiz-title']"),
            progressBar = $x("//home-quiz-progress-circle[@class='loader']"),
            coursesList = $x("//div[@class='courses-list']");

    public MainPage verifyHeaderMenuSize() {
        headerTabs.shouldHave(size(7));
        return this;
    }

    public MainPage verifyHeaderMenuItems(List<String> buttons) {
        headerTabsTitles.filter(visible).shouldHave(texts(buttons));
        return this;
    }

    public MainPage hoverMenuItem(String menuItem) {
        headerToggleMenu.$(byText(menuItem)).hover();
        return this;
    }

    public MainPage verifyProduct(String productForm) {
        productForms.findBy(text(productForm)).shouldBe(visible);
        return this;
    }

    public MainPage clickPassTest() {
        $x("//div[@class='note-item -desktop']/span[@class='note-link']").click(); // ссылка отсутствует
        return this;
    }

    public MainPage verifyQuizAppears() {
        quiz.should(appear);
        return this;
    }

    public MainPage verifyQuizTitle() {
        quizTitle.shouldHave(text(QUIZ_TITLE));
        return this;
    }

    public MainPage setPurposeAndLevel(String purpose, String level) {
        purposeAndLevel.findBy(text(purpose))
                .shouldBe(visible, Duration.ofSeconds(10)).click();
        purposeAndLevel.findBy(text(level))
                .shouldBe(visible, Duration.ofSeconds(10)).click();
        return this;
    }

    public MainPage verifyProgressBarAppears() {
        progressBar.should(appear);
        return this;
    }

    public MainPage verifySuitableCourses() {
        coursesList.should(exist);
        return this;
    }
}
