package pages.web;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ProductResultsByImagePage {

    private final ElementsCollection productList =
            $$(".product-card__top-wrap");
    private final SelenideElement pageTitleText = $x("//h1[@class='catalog-page__title'] ");

    @Step("Проверяем, что количество найденных товаров в списке больше {size}")
    public void checkProductListSize(int size) {
        pageTitleText.shouldBe(visible);
        productList.shouldHave(sizeGreaterThan(size));
    }

    @Step("Проверяем текст заголовка страницы результатов по картинке")
    public ProductResultsByImagePage checkPageTitle() {
        Assertions.assertEquals("Поиск по фото", pageTitleText.getText());
        return this;
    }
}
