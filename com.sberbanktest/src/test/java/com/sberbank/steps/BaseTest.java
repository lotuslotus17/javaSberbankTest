package com.sberbank.steps;

import com.sberbank.Hooks;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

public class BaseTest {

    protected WebDriver driver = Hooks.driver;
    protected Actions actions = Hooks.actions;
    protected WebDriverWait wait = Hooks.webDriverWait;

    //иницилизация пейджы
    protected <P> P getPage(Class<P> pageClass) {
        return PageFactory.initElements(driver, pageClass);
    }

    //проверка тайтла на соответствие
    protected void verifyTitleOnPageIsRight(String s) {
        assertEquals(driver.getTitle(), s, "Ошибка в тайтле на странице - " + s);
    }
}
