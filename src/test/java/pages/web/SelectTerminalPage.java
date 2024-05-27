package pages.web;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$;

public class SelectTerminalPage {

    private final SelenideElement actualTitle = $("h2[class='geo-block__info-title hide-mobile']");

    @Step("Проверяем что на странице отображается текст '{expectedText}'")
    public void checkPageTitle(String expectedText) {
        Assertions.assertEquals(expectedText, actualTitle.getText());
    }
}
