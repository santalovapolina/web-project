package pages;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelfStudyPage {

    private final String SELF_STUDY_HEADER = "Самостоятельные занятия английским";

    public SelfStudyPage openPage() {
        open("/self-study");
        return this;
    }

    public SelfStudyPage verifyHeader() {
        $("h1").shouldHave(text(SELF_STUDY_HEADER));
        return this;
    }

    public SelfStudyPage verifyStudyFormExists() {
        $$x("//div[@class='catalog-teachers-desktop-name']").findBy(text("Тренажёр слов")).should(exist);
        return this;
    }
}
