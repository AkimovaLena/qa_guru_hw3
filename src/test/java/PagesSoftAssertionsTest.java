import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
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
        // Откройте страницу SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("#wiki-pages-box").find(byText("SoftAssertions")).click();
        //проверьте что внутри есть пример кода для JUnit5
        $$("div.markdown-body div.markdown-heading").findBy(text("JUnit5")).sibling(0)
                .shouldHave(text("""
                        @ExtendWith({SoftAssertsExtension.class})
                        class Tests {
                          @Test
                          void test() {
                            Configuration.assertionMode = SOFT;
                            open("page.html");
                                                
                            $("#first").should(visible).click();
                            $("#second").should(visible).click();
                          }
                        }
                        """));
    }
}

