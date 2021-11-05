package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideSoftAssertions {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "Firefox";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void selenideSoftAssertionsFindJunit5() {
        //открыть github.com и в поиске найти selenide
        open("https://github.com/");
        $("[data-test-selector = nav-search-input]").setValue("selenide").pressEnter();

        //выбрать первую ссылку и открыть репозиторий
        $(".repo-list").$("a").click();
        $("h1").shouldHave(text("selenide / selenide"));

        //перейти на вкладку wiki и перейти на вкладку SoftAssertions
        $("#wiki-tab").click();
        $(".Layout-sidebar").find(byText("Show 2 more pages…")).scrollTo().click();
        $(byText("SoftAssertions")).click();
        $("#wiki-wrapper").shouldHave(text("SoftAssertions"));

        //проверить что внутри есть пример кода JUnit5
        $(".markdown-body").shouldHave(text("JUnit5 extension - com.codeborne.selenide.junit5.SoftAssertsExtension"));
    }
}
