package tests.web;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.web.*;
import pages.web.components.NavigationMenuComponent;

@Tag("web_test")
@Epic("Навигация по сайту")
@Feature("Навигационное меню")
@DisplayName("Проверка навигационного меню")
public class NavigationMenuTest extends BaseWebTest{

    HomePage homePage = new HomePage();
    NavigationMenuComponent navigationMenuComponent = new NavigationMenuComponent();
    SelectTerminalPage selectTerminalPage = new SelectTerminalPage();
    ForSellersPage forSellersPage = new ForSellersPage();
    ForWorkersPage forWorkersPage = new ForWorkersPage();
    AboutDeliveryPage aboutDeliveryPage = new AboutDeliveryPage();
    LoginPage loginPage = new LoginPage();
    ProductCardPage productCardPage = new ProductCardPage();

    @Test
    @Story("Переход на страницу выбора города")
    @DisplayName("Переход на страницу выбора города")
    void testNavigationToSelectTerminalPage() {
        homePage.openHomePage();
        navigationMenuComponent.goToSelectTerminalPage();
        selectTerminalPage.checkPageTitle("Выберите способ доставки");
    }

    @Test
    @Story("Переход на страницу для продавцов")
    @DisplayName("Переход на страницу для продавцов")
    void testNavigationToForSellersPage() {
        homePage.openHomePage();
        navigationMenuComponent.goToForSellersPage();
        Selenide.webdriver().driver().switchTo().window(1);
        forSellersPage.checkPageText("Торговать может\n" + "каждый");
    }

    @Test
    @Story("Переход на страницу вакансий в Wildberries")
    @DisplayName("Переход на страницу вакансий в Wildberries")
    void testNavigationToJobInWildberriesPage() {
        homePage.openHomePage();
        navigationMenuComponent.goToJobInWildberriesPage();
        forWorkersPage.checkPageText("Работа в пункте выдачи");
    }

    @Test
    @Story("Переход на страницу информации о доставке")
    @DisplayName("Переход на страницу информации о доставке")
    void testNavigationToPickUpPointsPage() {
        homePage.openHomePage();
        navigationMenuComponent.goToPickUpPointsPage();
        aboutDeliveryPage.checkPageText("Информация о доставке и пунктах выдачи");
    }

    @Test
    @Story("Переход на страницу входа")
    @DisplayName("Переход на страницу входа")
    void testNavigationToLoginPage() {
        homePage.openHomePage();
        navigationMenuComponent.goToLoginPage();
        loginPage.checkPageText("Войти или создать профиль");
    }

    @Test
    @Story("Переход на страницу корзины")
    @DisplayName("Переход на страницу корзины")
    void testNavigationToCartPage() {
        homePage.openHomePage();
        navigationMenuComponent.goToCartPage();
        productCardPage.checkPageText("В корзине пока пусто");
    }
}
