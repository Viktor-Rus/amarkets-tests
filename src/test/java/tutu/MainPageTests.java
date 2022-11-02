package tutu;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class MainPageTests extends TestBase {

    @BeforeEach
    public void visitMainPage() {
//        open("/");
//        new MainPage().openMainPage();
    }


    @Test
    @Owner("vaurusov")
    @DisplayName("Проверка отображения логотипа на главной странице")
    void mainLogoVisible() {
//        new MainPage().checkLogoVisible();

    }

}
