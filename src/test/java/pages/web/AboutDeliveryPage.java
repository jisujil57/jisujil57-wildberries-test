package pages.web;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$x;

public class AboutDeliveryPage {
    private final SelenideElement productCardButton = $x("//h2[@class='delivery-geo__title']");

    @Step("Проверяем что на странице отображается текст '{expectedText}'")
    public void checkPageText(String expectedText) {
        Assertions.assertEquals(expectedText, productCardButton.getText());
    }
}
