import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class PagesSoftAssertionsTest {


    @Test
    void shouldFindSelenideRepositoryAtTheTop() {

        // Откройте страницу Selenide в Github
        open("https://github.com/");
        $(".header-search-button").click();
        $("input#query-builder-test").setValue("selenide").pressEnter();
        $("div[data-testid=results-list]").$("a").click();
        // Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();
        // Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $$(".markdown-body ul li").find(text("Soft assertions")).shouldBe(visible);

        // Откройте страницу SoftAssertions
        $(byText("Soft assertions")).click();
        $("div.gh-header").$("h1").shouldHave(text("SoftAssertions")).click();
        //проверьте что внутри есть пример кода для JUnit5
        $$("div.markdown-body div.markdown-heading").findBy(text("JUnit5")).sibling(0).shouldHave(text("class Tests"));
        //!!! Изначально написала  с parent() (строчка ниже) и долго не могла понять почему не работает, опытным путем добилась результата выше, но нет понимания почему так работает, а так нет..
        //$$("div.markdown-body div.markdown-heading").findBy(text("JUnit5")).parent().sibling(0).shouldHave(text("class Tests"));

    }
}

