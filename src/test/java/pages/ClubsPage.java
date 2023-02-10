package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class ClubsPage {

    public ClubsPage openPage(String page) {
        open("http://skyeng.ru" + page);
        return this;
    }

    public ClubsPage verifyFeature(String feature) {
        $x("//adults-life-showcase").$(withText(feature)).shouldBe(visible);
        return this;
    }
}
