package tests.demoQA;


import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import pages.RegistrationFormPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import tests.properties.SystemPropertiesTests;

public class TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
        String login = config.login();
        String password = config.password();

        String urlSelenoid = System.getProperty("selenoid", "selenoid.autotests.cloud/wd/hub");
        String browserSize = System.getProperty("resolution","800x600");
        String version = System.getProperty("version","101");
        String browser = System.getProperty("browser","ie");

        Configuration.browser = browser;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = browserSize;
        Configuration.browserVersion = version;
        Configuration.remote = "https://" + login + ":" + password +"@" + urlSelenoid;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;



        //   Configuration.remote = remoteSite;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}