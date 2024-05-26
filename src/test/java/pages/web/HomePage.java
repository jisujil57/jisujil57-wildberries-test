package pages.web;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

public class HomePage {

    private final SelenideElement banner = $(".main-page__banner");
    private final ElementsCollection productResultsList = $$x("//div[@class='product-card__top-wrap']");

    @Step("Открываем главную страницу")
    public HomePage openHomePage() {
        Selenide.open("/");
        checkBannerVisible();
        return this;
    }

    @Step("Проверяем, что главный баннер виден")
    public HomePage checkBannerVisible() {
        banner.shouldBe(visible);
        return this;
    }

    @Step("Проверяем, что количество товаров в списке больше {size}")
    public void checkProductResultsListSize(int size) {
        productResultsList.shouldHave(sizeGreaterThan(size));
    }
}
