package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class MainPageTests extends TestBase {
    @Test
    @Owner("OIzibekova")
    @Feature("Main page")
    //@Story("Main page content")
    @DisplayName("Successful Main page loading")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("ui")
    void loginTest() {
        step("Открываем главную страницу", () -> {
            open("https://selecty.ru/");
        });

        step("Проверяем наличие заголовка", () -> {
            $("#rec246587380 h3").shouldHave(text("IT АГЕНТСТВО"));
        });


    }

    @Test
    @Owner("OIzibekova")
    @Feature("Page header")
    //@Story("Main page content")
    @DisplayName("Check main page headers")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("ui")
    void checkMainPageHeader() {
        step("Открываем главную страницу", () -> {
            open("https://selecty.ru/");
            $("#rec246587380 h3").shouldHave(text("IT АГЕНТСТВО"));
        });
        step("Проверяем отображение разделов на главном экране", () -> {
            $(".t228__maincontainer .t228__centerside a").isDisplayed();
            $(".t228__centercontainer a[data-menu-item-number='2']").isDisplayed();
            $(".t228__centercontainer a[data-menu-item-number='3']").isDisplayed();
            $(".t228__centercontainer a[data-menu-item-number='4']").isDisplayed();
            $(".t228__centercontainer a[data-menu-item-number='5']").isDisplayed();
            $(".t228__centercontainer a[data-menu-item-number='6']").isDisplayed();
            $(".t228__centercontainer a[data-menu-item-number='7']").isDisplayed();
            $(".t228__centercontainer a[data-menu-item-number='8']").isDisplayed();
        });
    }

    @Test
    @Owner("OIzibekova")
    @Feature("Page footer")
    //@Story("Main page content")
    @DisplayName("Check main page social media icons")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("ui")
    void checkMenuNames() {
        step("Открываем главную страницу", () -> {
            open("https://selecty.ru/");
            $("#rec246587380 h3").shouldHave(text("IT АГЕНТСТВО"));
        });
        step("Проверяем наличие иконок на главной странице", () -> {
            $(".t-sociallinks__wrapper > div:first-child").isDisplayed();
            $(".t-sociallinks__wrapper > div:nth-child(2)").isDisplayed();
            $(".t-sociallinks__wrapper > div:last-child").isDisplayed();
        });
    }

    @Test
    @Owner("OIzibekova")
    @Feature("Page footer")
    //@Story("Main page content")
    @DisplayName("Check main page social media icons attributes")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("ui")
    void checkMenuIconsHaveAttributes() {
        step("Открываем главную страницу", () -> {
            open("https://selecty.ru/");
            $("#rec246587380 h3").shouldHave(text("IT АГЕНТСТВО"));
        });
        step("Проверяем наличие атрибутов у иконок соц.сетей", () -> {
            $(".t-sociallinks__wrapper > div:first-child").$("a").getAttribute("href").equals("https://www.facebook.com/selecty1/");
            $(".t-sociallinks__wrapper > div:nth-child(2)").$("a").getAttribute("href").equals("https://vk.com/selecty1");
            $(".t-sociallinks__wrapper > div:last-child").$("a").getAttribute("href").equals("https://www.instagram.com/selecty_hr/");
        });
    }


    @Test
    @Owner("OIzibekova")
    @Feature("Write Us")
    //@Story("Main page content")
    @DisplayName("Check main page social media icons attributes")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("ui")
    void checkNotSuccessWriteUs() {
        step("Открываем главную страницу", () -> {
            open("https://selecty.ru/");
            $("#rec246587380 h3").shouldHave(text("IT АГЕНТСТВО"));
        });
        step("Кликаем на иконку чата", () -> {
            $(".t708__btn").click();
        });
        step("Заполняем поля формы", () -> {
            $(".t-input-block > input").setValue("test@mail.ru");
            $("input[autocomplete='name']").setValue("Test Name");
            $("textarea[name='Textarea']").setValue("Test message");
            $("button[type='submit']").click();
            Selenide.sleep(5);
        });
        step("Проверяем отображение сообщения об успешной отправке", () -> {
            $(".t708__popup-container .js-successbox").shouldHave(text("Thank you! Your data has been submitted."));
        });
    }
}
