package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

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
            searchTitleFaq = $("h4[class='faq__search-title']"),
            navMenuHeader = $("ul[class='ubermenu-nav']");



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

    @Step("Скролл главной страницы до футера")
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


    @Step("Ховер на пункте меню главной страницы")
    public MainPage hoverMenuNav(String menuItem) {
        $x("//ul[@class='ubermenu-nav']//span[text()='"+menuItem+"']").hover();
        return this;
    }
    @Step("Клик по выбранному тексту")
    public MainPage clickByText(String textClick) {
        $(byText(textClick)).click();
        return this;
    }


    @Step("Проверка текста хедара страницы FAQ")
    public MainPage  checkSearchHeaderText(String textHeader) {
        assertEquals(this.getSearchTitleFaq().getText(), textHeader);
        return this;
    }

    public SelenideElement getSearchTitleFaq(){
        return searchTitleFaq;
    }






}
