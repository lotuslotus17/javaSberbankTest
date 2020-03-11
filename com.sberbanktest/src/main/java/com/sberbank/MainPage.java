package com.sberbank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    @FindBy(xpath = "//ul[@class='segments__list']/li/a[@href='/ru/s_m_business']")
    protected WebElement smallBussines;

    //переход на страницу малого бизнеса
    public SmallBussinesPage goToSmallBussinesPage() {
        smallBussines.click();
        return new SmallBussinesPage();
    }

    public WebElement getSmallBussines() {
        return smallBussines;
    }
}
