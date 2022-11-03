package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPage {
    private SelenideElement
            mainLogo = $("div.header_logo"),
            openAccountButton =$(byText("Open Account")),
            headerTitle = $("h1[class*='header_title']"),
            sectionMadeToOrder = $("section[class='made-to-order']"),
            tabInvestors =  $("a[title='Investors']"),
            titlePage =  $("h1[class='page-title']"),
            footer = $("footer[class='footer-wrapper']"),
            loginFooter =  $x("//a[.='Associate Login']");


    @Step("Открытие главной страницы")
    public MainPage openMainPage() {
        open(Configuration.baseUrl);
        return this;
    }

    @Step("Проверка отображения логотипа на главной странице")
    public MainPage checkLogoVisible() {
        mainLogo.should(appear);
        return this;
    }

    @Step("Проверка открытия формы логина с главной страницы")
    public MainPage openAnAccount() {
        openAccountButton.should(appear).click();
        headerTitle.shouldHave(text("Open an Account"));
        return this;
    }




}
