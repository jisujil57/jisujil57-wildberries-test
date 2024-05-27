package pages.web.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class NavigationMenuComponent {

    private final SelenideElement geoCityButton = $("li[class='simple-menu__item j-geocity-wrap']");
    private final SelenideElement forSellersButton = $("a[data-wba-header-name='Seller']");
    private final SelenideElement jobInWildberriesButton = $("a[data-wba-header-name='Job']");
    private final SelenideElement pickUpPointsButton = $("span[class='navbar-pc__icon navbar-pc__icon--address']");
    private final SelenideElement loginButton = $("span[class='navbar-pc__icon navbar-pc__icon--profile']");
    private final SelenideElement productCardButton = $("a[data-wba-header-name='Cart']");

    @Step("Переход на страницу выбора города")
    public NavigationMenuComponent goToSelectTerminalPage() {
        geoCityButton.click();
        return this;
    }

    @Step("Переход на страницу для продавцов")
    public NavigationMenuComponent goToForSellersPage() {
        forSellersButton.click();
        return this;
    }

    @Step("Переход на страницу вакансий в Wildberries")
    public NavigationMenuComponent goToJobInWildberriesPage() {
        jobInWildberriesButton.click();
        return this;
    }

    @Step("Переход на страницу пунктов выдачи")
    public NavigationMenuComponent goToPickUpPointsPage() {
        pickUpPointsButton.click();
        return this;
    }

    @Step("Переход на страницу входа")
    public NavigationMenuComponent goToLoginPage() {
        loginButton.click();
        return this;
    }

    @Step("Переход на страницу корзины")
    public NavigationMenuComponent goToCartPage() {
        productCardButton.click();
        return this;
    }
}
