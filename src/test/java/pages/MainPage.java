package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPage {
    private SelenideElement
            mainLogo = $("a[href='https://www.tutu.ru/']"),
            iconSearch = $("div[class='search-site']"),
            inputSearch = $("input[name='s']"),
            sectionMadeToOrder = $("section[class='made-to-order']"),
            tabInvestors =  $("a[title='Investors']"),
            titlePage =  $("h1[class='page-title']"),
            footer = $("footer[class='footer-wrapper']"),
            loginFooter =  $x("//a[.='Associate Login']");


    @Step("Открытие главной страницы")
    public MainPage openMainPage() {
        open("https://www.tutu.ru/");
//        open(Configuration.baseUrl);
        return this;
    }

    @Step("Проверка отображения логотипа на главной странице")
    public MainPage checkLogoVisible() {
        mainLogo.should(appear);
        return this;
    }


}
