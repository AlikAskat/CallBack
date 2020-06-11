package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

class CallBackTest {


    @Test
     public void shouldSubmitRequest() {
        Selenide.open("http://localhost:9999");
        SelenideElement form = Selenide.$(getCssSelector());
        getForm(form).$("[data-test-id=name] input").setValue("Василий");
        getForm(form).$("[data-test-id=phone] input").setValue("+79270000000");
        getForm(form).$("[data-test-id=agreement]").click();
        getForm(form).$("[data-test-id=submit]").click();
        Selenide.$(".alert-success").shouldHave(Condition.exactText("Ваша заявка успешно отправлена!"));
    }

    private String getCssSelector() {
        return "[data-test-id=callback-form]";
    }

    private SelenideElement getForm(SelenideElement form) {
        return form;
    }

}
