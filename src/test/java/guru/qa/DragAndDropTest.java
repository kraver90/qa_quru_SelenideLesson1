package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @BeforeAll
    static void beforeAll(){
        Configuration.browser = "Firefox";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void dragAndDopTest(){
        //открыть сайт https://the-internet.herokuapp.com/drag_and_drop и проверить расположение элементов
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));

        //перенести квадрат A в квадрат В и проверить расположение элементов
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

    }
}
