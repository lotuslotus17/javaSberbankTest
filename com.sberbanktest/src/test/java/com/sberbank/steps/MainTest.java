package com.sberbank.steps;

import com.sberbank.MainPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainTest extends BaseTest {

    private String mainPageTitle = "«Сбербанк» - Частным клиентам";

    @Given("юзер открывает главную страницу")
    public void openMainPage() {
      driver.get("https://www.sberbank.ru/");
    }

    @Then("открылась страница «Сбербанк» - Частным клиентам")
    public void verifyMainPageIsOpened() {
        verifyTitleOnPageIsRight(mainPageTitle);
    }

    @When("юзер переходит на страницу Малый бизнес")
    public void goToSmallBussines() {
        wait.until(ExpectedConditions.visibilityOf(page().getSmallBussines()));
        page().goToSmallBussinesPage();
    }

    private MainPage page() {
        return getPage(MainPage.class);
    }
}
