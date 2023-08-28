package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class ClubsPage {

    private final SelenideElement showcase = $x("//adults-life-showcase");

    public ClubsPage openPage(String page) {
        open(baseUrl + page);
        return this;
    }

    public ClubsPage verifyFeature(String feature) {
        showcase.$(withText(feature)).shouldBe(visible);
        return this;
    }
}
