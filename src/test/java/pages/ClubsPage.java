package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class ClubsPage {

    public ClubsPage openPage() {
        open("/clubs");
        return this;
    }

    public ClubsPage verifySchedule() {
        $x("//adults-life-showcase").$(withText("Расписание")).shouldBe(visible);
        return this;
    }
}
