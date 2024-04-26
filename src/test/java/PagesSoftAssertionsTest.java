import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
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
        sleep(6000);
        $(byText("Soft assertions")).click();
        // Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        sleep(6000);
    }
}

