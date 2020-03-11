package com.sberbank;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class Hooks {
    public static WebDriver driver;
    public static Actions actions;
    public static WebDriverWait webDriverWait;

    @Before
    public void onSetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        actions = new Actions(driver);
        webDriverWait = new WebDriverWait(driver, 30);
    }

    @After
    public void onTearDown() {
        driver.close();
        driver.quit();
    }
}
