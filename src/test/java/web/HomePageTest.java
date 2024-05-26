package web;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.web.HomePage;
import pages.web.ProductResultsByImagePage;
import pages.web.ProductResultsPage;
import pages.web.components.SearchProductComponent;

import java.io.File;
import java.util.stream.Stream;


@Tag("web_test")
@DisplayName("Главная страница")
public class HomePageTest extends BaseWebTest {
    HomePage homePage = new HomePage();
    SearchProductComponent searchProductComponent = new SearchProductComponent();
    ProductResultsPage productResultsPage = new ProductResultsPage();
    ProductResultsByImagePage productResultsByImagePage = new ProductResultsByImagePage();

    @Test
    @Feature("Поиск товаров")
    @Story("Успешный поиск товаров на главной странице")
    @DisplayName("Успешный поиск товаров на главной странице")
    void successfulSearchTest() {
        homePage.openHomePage();
        searchProductComponent.setSearchQueryAndPressEnter("Полка");
        productResultsPage.checkProductListSize(15);
    }

    @ParameterizedTest
    @Feature("Поиск товаров")
    @Story("Успешное отображение подсказок при поиске товаров")
    @DisplayName("Успешное отображение подсказок при поиске товаров")
    @MethodSource("searchQueryAndExpectedStrings")
    void successfulSearchSuggestionsTest(String searchQuery, String[] expectedStrings) {
        homePage.openHomePage()
                .checkBannerVisible();
        searchProductComponent.setSearchQuery(searchQuery)
                .checkSearchSuggestions(expectedStrings);
    }

    private static Stream<Arguments> searchQueryAndExpectedStrings() {
        return Stream.of(
                Arguments.of("роьа", new String[]{"ротанг для плетения", "ротанг", "роба", "роьаксы", "ротанг полутрубка", "ротанг полумесяц", "ротанг для плетения 7 мм"}),
                Arguments.of("тряпка", new String[]{"тряпка для машины", "тряпка для швабры", "тряпка для пола", "тряпка для стекол", "тряпка для кухни", "тряпка для стекол без разводов", "тряпка для швабры на липучке"}),
                Arguments.of("магнитики", new String[]{"магнитики на холодильник", "магнитики", "магнитики на доску", "магнитики на холодильник для детей", "магнитики маленькие", "магнитики на холодильник прикольные", "магнитики для холодильника"})
        );
    }

    @Test
    @Feature("Рекламный баннер")
    @Story("Отображение рекламного баннера")
    @DisplayName("Отображение рекламного баннера")
    void advertisementBannerDisplayTest() {
        homePage.openHomePage()
                .checkBannerVisible();
    }

    @Test
    @Feature("Рекомендуемые товары")
    @Story("Отображение рекомендуемых товаров")
    @DisplayName("Отображение рекомендуемых товаров")
    void recommendedProductsDisplayTest() {
        homePage.openHomePage();
        homePage.checkProductResultsListSize(15);
    }

    @Test
    @Feature("Поиск товаров")
    @Story("Поиск товаров по картинке")
    @DisplayName("Успешный поиск товара по картинке")
    void successfulSearchProductByImage() {
        File imageFile = new File("src/test/resources/files/images/enkpkwp24jvbf4cf20quu2d609ry3see.jpg");

        homePage.openHomePage();
        searchProductComponent.searchProductByImage(imageFile);
        productResultsByImagePage.checkPageTitle()
                .checkProductListSize(15);
    }
}
