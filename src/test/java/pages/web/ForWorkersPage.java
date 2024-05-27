package pages.web;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ForWorkersPage {


    private final SelenideElement pageTitleText = $x("//h2[@class='employment__header pickup-point__header']");

    @Step("Проверяем что на странице отображается текст '{expectedText}'")
    public void checkPageText(String expectedText) {
        Selenide.webdriver().driver().switchTo().frame("pageInfoIfr");
        pageTitleText.shouldBe(visible);
        Assertions.assertEquals(expectedText, pageTitleText.getText());
    }
}
