import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @BeforeEach
    void setUp(){
        baseUrl="https://github.com";
        Configuration.browserSize="1920x1280";
    }

    @Test
    public void selenideTest() {
        //Откройте страницу Selenide в Github
        open("/selenide/selenide");
        //Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();
        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $(byTagAndText("a","Soft assertions")).click();
        //Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        SelenideElement element = $(withTagAndText("h4", "JUnit5")).sibling(0).find("div>pre");
        Assertions.assertFalse(element.is(Condition.empty));
    }
}
