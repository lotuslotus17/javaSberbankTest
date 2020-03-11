package com.sberbank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SmallBussinesPage extends BasePage {
    @FindBy(xpath = "//*[@class='social__list social__list_corpMode']/*")
    private WebElement baseSocialElement;
    @FindBy(xpath = "//div[@class='hd-ft-region__title js-open-popup-link']")
    private WebElement citySearch;
    @FindBy(xpath = "//div[@class='regions-list__search']/input")
    private WebElement searchBox;
    @FindBy(xpath = "//div[@class='social__wrapper social__wrapper_corpMode']/ul/li/a[@href='http://instagram.com/sberbank']/span")
    private WebElement socialInstagram;
    @FindBy(xpath = "//div[@class='social__wrapper social__wrapper_corpMode']/ul/li/a[@href='https://www.facebook.com/sberbusiness']/span")
    private WebElement socialFacebook;
    public By socialInstagramBy = By.xpath("//div[@class='social__wrapper social__wrapper_corpMode']/ul/li/a[@href='http://instagram.com/sberbank']/span");
    public By socialFacebookBy = By.xpath("//div[@class='social__wrapper social__wrapper_corpMode']/ul/li/a[@href='https://www.facebook.com/sberbusiness']/span");
    public By socialTwitterBy = By.xpath("//div[@class='social__wrapper social__wrapper_corpMode']/ul/li/a[@href='http://twitter.com/sberbank/']/span");
    public By socialOdnoklassnikiBy = By.xpath("//div[@class='social__wrapper social__wrapper_corpMode']/ul/li/a[@href='https://ok.ru/sberbank']/span");
    public By socialVkontakteBy = By.xpath("//div[@class='social__wrapper social__wrapper_corpMode']/ul/li/a[@href='https://www.vk.com/sberbusiness?_smt=public']/span");
    public By socialYoutubeBy = By.xpath("//div[@class='social__wrapper social__wrapper_corpMode']/ul/li/a[@href='http://www.youtube.com/sberbank']/span");

    //метод изменения города
    public void changeCurrentCity(String city, WebDriver driver) {
        citySearch.click();
        typeIn(city, searchBox);
        By cityToSearch = By.xpath(String.format("//div[@class='regions-list__item']/a[@data-name='%s']", city));
        driver.findElement(cityToSearch).click();
    }

    public String getCurrentCity() {
        return citySearch.getText();
    }

    //проверка есть ли элемент на странице
    public boolean isElementPresent(WebDriver driver, By by) {
        return driver.findElements(by).size() != 0;
    }

    public WebElement getCitySearch() {
        return citySearch;
    }

    public WebElement getSocialInstagram() {
        return socialInstagram;
    }

    public WebElement getSocialFacebook() {
        return socialFacebook;
    }

}
