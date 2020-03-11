package com.sberbank;

import org.openqa.selenium.WebElement;

public abstract class BasePage {
    //метод печатанья в вебэлемент
    protected void typeIn(String value, WebElement targetElement) {
        targetElement.clear();
        targetElement.sendKeys(value);
    }
}
