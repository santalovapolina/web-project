package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class SelfStudyPage {

    private final String SELF_STUDY_HEADER = "Самостоятельные занятия английским";

    private final SelenideElement pageHeader = $("h1"),
    studyFormats = $x("//h3[@class='catalog-teachers-h3']");

    private final ElementsCollection formatsForStudy = $$x("//div[@class='catalog-teachers-desktop-name']");


    public SelfStudyPage openPage() {
        open(baseUrl + "/self-study");
        return this;
    }

    public SelfStudyPage verifyHeader() {
        pageHeader.shouldHave(text(SELF_STUDY_HEADER));
        return this;
    }

    public SelfStudyPage verifyStudyFormExists(String studyFormsTitle, String studyForm ) {
        studyFormats.shouldHave(text(studyFormsTitle));
        formatsForStudy.findBy(text(studyForm))
                .should(exist);
        return this;
    }
}
