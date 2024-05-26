package pages.web;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

public class ProductResultsPage {

    private final ElementsCollection productList =
            $$x("//div[@class='product-card__img-wrap img-plug j-thumbnail-wrap']");
    private final SelenideElement searchInfoText = $(".searching-results__count");

    @Step("Проверяем, что количество найденных товаров в списке больше {size}")
    public void checkProductListSize(int size) {
        searchInfoText.shouldBe(visible);
        productList.shouldHave(sizeGreaterThan(size));
    }
}
