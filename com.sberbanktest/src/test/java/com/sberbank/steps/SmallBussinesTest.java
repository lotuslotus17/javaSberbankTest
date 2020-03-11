package com.sberbank.steps;

import com.sberbank.SmallBussinesPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.*;

public class SmallBussinesTest extends BaseTest {

    private String testCity = "Новгородская область";
    private String maliiBussinesTitle = "«Сбербанк» - Малый бизнес";

    @When("юзер меняет город на другой")
    public void userChangeCity() {
        wait.until(ExpectedConditions.visibilityOf(page().getCitySearch()));
        page().changeCurrentCity(testCity, driver);
    }

    @Then("город изменился на другой")
    public void verifyCityHasChanged() {
        wait.until(ExpectedConditions.visibilityOf(page().getCitySearch()));
        assertEquals(testCity, page().getCurrentCity(), "wrong city");
    }

    @When("юзер скролит в самый низ страницы")
    public void scrollToTheFooter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    @Then("все иконки социальных сетей видны юзеру")
    public void verifyAllSocialIconsArePresent() {
        wait.until(ExpectedConditions.visibilityOf(page().getSocialFacebook()));
        wait.until(ExpectedConditions.visibilityOf(page().getSocialInstagram()));
        assertAll(
                () -> assertTrue(page().isElementPresent(driver, page().socialInstagramBy)),
                () -> assertTrue(page().isElementPresent(driver, page().socialFacebookBy)),
                () -> assertTrue(page().isElementPresent(driver, page().socialTwitterBy)),
                () -> assertTrue(page().isElementPresent(driver, page().socialYoutubeBy)),
                () -> assertTrue(page().isElementPresent(driver, page().socialOdnoklassnikiBy)),
                () -> assertTrue(page().isElementPresent(driver, page().socialVkontakteBy)));
    }

    @Then("открылась страница «Сбербанк» - Малый бизнес")
    public void verifySmallBussinesPageIsOpened() {
        verifyTitleOnPageIsRight(maliiBussinesTitle);
    }

    private SmallBussinesPage page() {
        return getPage(SmallBussinesPage.class);
    }
}
