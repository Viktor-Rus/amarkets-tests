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
            switcherLanguage = $("a[href='#pll_switcher']"),
            languagesMenuFooter =  $("ul[id*='languages-menu']"),
            navTrading =  $("nav a[href='https://www.amarkets.com/trading/']");


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


    public MainPage scrollToFooter() {
        languagesMenuFooter.scrollTo().click();
        return this;
    }

    @Step("Изменить язык главной страницы")
    public MainPage choiceLanguageInFooter(String language) {
        languagesMenuFooter.$(byText(language)).click();
        switcherLanguage.$("img[alt="+language +"]").should(appear);
        return this;
    }

    public MainPage focusHeaderNavItem(String language) {
        $x("//ul[@class=\"ubermenu-nav\"]//span[text()=\"TRADING\"]").hover();
        $(byText("FAQ")).click();
        assertEquals($("h4[class='faq__search-title']").getText(), "We've got answers to all of your questions");
        return this;
    }






}
