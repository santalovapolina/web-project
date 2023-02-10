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

    public SelfStudyPage verifyStudyFormExists(String studyFormsTitle, String studyForm ) {
        $x("//h3[@class='catalog-teachers-h3']").shouldHave(text(studyFormsTitle));
        $$x("//div[@class='catalog-teachers-desktop-name']").findBy(text(studyForm)).should(exist);
        return this;
    }
}
