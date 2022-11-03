package tutu;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;


public class MainPageTests extends TestBase {

    @BeforeEach
    @DisplayName("Открытие главной страницы")
    public void visitMainPage() {
        new MainPage().openMainPage();
    }


    @Test
    @Owner("vaurusov")
    @DisplayName("Проверка отображения логотипа на главной странице")
    void mainLogoVisible() {
        new MainPage().checkLogoVisible();

    }

    @Test
    @Owner("vaurusov")
    @DisplayName("Проверка открытия формы 'Open an Account' ")
    void openAccountForm() {
        new MainPage().openAnAccount();

    }

    @Test
    @Owner("vaurusov")
    @DisplayName("Проверка переключателя языка")
    void changeLanguage() {
        new MainPage().choiceLanguage("Українська");

    }

}
