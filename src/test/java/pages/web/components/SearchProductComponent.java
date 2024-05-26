package pages.web.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SearchProductComponent {

    private final SelenideElement searchInput = $("#searchInput");
    private final SelenideElement suggestionsModal = $(".autocomplete__content");
    private final SelenideElement searchByImageInput = $x("//form[@id='searchByImageForm']//input");

    private final ElementsCollection searchSuggestionsCollection =
            $$x("//p[@class='autocomplete__text']");

    @Step("Вводим запрос поиска: {productName}")
    public SearchProductComponent setSearchQuery(String productName) {
        searchInput.setValue(productName);
        return this;
    }

    @Step("Вводим запрос поиска и нажимаем Enter: {productName}")
    public void setSearchQueryAndPressEnter(String productName) {
        searchInput.setValue(productName).pressEnter();
    }

    @Step("Проверяем текст подсказок для поиска")
    public SearchProductComponent checkSearchSuggestions(String[] expectedValues) {
        suggestionsModal.shouldBe(visible);
        searchSuggestionsCollection.shouldHave(texts(expectedValues));
        return this;
    }

    @Step("Поиск товаров по картинке")
    public void searchProductByImage(File file) {
        searchByImageInput.uploadFile(file);
    }
}
