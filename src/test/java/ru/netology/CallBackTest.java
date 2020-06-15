package ru.netology;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class CallBackTest {


    @Test
     public void shouldSubmitRequest() {
        open("http://localhost:9999");
        SelenideElement form = $("[class='App_appContainer__3jRx1']");
        form.$("[name='name']").setValue("Василий");
        form.$("[name='phone']").setValue("+79270000000");
        form.$("[class='checkbox__box']").click();
        form.$("[class='button button_view_extra button_size_m button_theme_alfa-on-white']").click();
        $("[data-test-id='order-success']").shouldHave(exactText("Ваша заявка успешно отправлена!"));
    }

}
