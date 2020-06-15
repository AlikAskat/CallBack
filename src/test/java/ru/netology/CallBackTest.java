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
        SelenideElement form = $("#root");
        form.$("[data-test-id='name']").setValue("Василий");
        form.$("[data-test-id='phone']").setValue("+79270000000");
        form.$("[data-test-id='agreement']").click();
        form.$("button button_view_extra button_size_m button_theme_alfa-on-white").click();
        $("[data-test-id='order-succes']").shouldHave(exactText("Ваша заявка успешно отправлена!"));
    }

}
