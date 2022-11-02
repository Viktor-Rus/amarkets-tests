package tutu;

import com.browserup.bup.BrowserUpProxy;
import com.browserup.bup.proxy.CaptureType;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    @BeforeAll
    static void configure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "https://www.tutu.ru";
        Configuration.browserSize = System.getProperty("browser_size");
        Configuration.browser = System.getProperty("browser_name");
        Configuration.browserVersion = System.getProperty("browser_version");
        Configuration.remote = System.getProperty("remote_selenide");

//        Configuration.proxyEnabled = true;
//        Configuration.proxyHost = "92.101.95.210";
//        Configuration.proxyPort = 1080;
        Configuration.holdBrowserOpen = true;
        Configuration.proxyEnabled = true;

        WebDriverRunner.getAndCheckWebDriver(); // otherwise WebDriverRunner.getSelenideProxy() returns null

        BrowserUpProxy proxy = WebDriverRunner.getSelenideProxy().getProxy();
        proxy.setHarCaptureTypes(CaptureType.getAllContentCaptureTypes());
        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
        proxy.newHar("pofig");
        open("https://google.com");
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}