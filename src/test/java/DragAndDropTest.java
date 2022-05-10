import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTest {

    @BeforeEach
    public void setUp(){
        Configuration.browserSize="1920x1280";
    }

    @Test
    public void dragAndDropTest(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement a = $("#column-a");
        SelenideElement b = $("#column-b");
        a.dragAndDropTo(b);
        Assertions.assertTrue(a.is(text("B")) & b.is(text("A")));
    }

    @Test
    void test(){
        //поиск ребенка (div) любого уровня. Поиск удовлетворяющий 2 условиям сразу
        $("h1 div");
        /*поиск 1-го ребенка. Поиск сначала h1, после 1-го div-потомка h1 (поиск дольше).
        Если в дереве несколько элементов h1, но в 1-м по дереву нет div-потомка, то с таким селектором второй не будет найден*/
        $("h1").$("div");
    }
}
