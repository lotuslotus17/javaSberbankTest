import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {
    @FindBy(xpath = "//*[@class='hd-ft-region__title js-open-popup-link']")
    protected WebElement citySearch;
    @FindBy(xpath = "//*[@class='regions-list__search']/*[@type = 'text']")
    protected WebElement searchBox;
    @FindBy(xpath = "/*")
    protected WebElement parentElement;
    @FindBy(xpath = "//*/ul[@class='segments__list']/li[3]")
    protected WebElement smallBussines;
    @FindBy(xpath = "//*[@class='social__list social__list_corpMode']/*")
    protected WebElement baseSocialElement;
    @FindBy(xpath = "/html/head/title")
    private WebElement title;

    protected WebElement cityElement;

    protected void changeCurrentCity(String city) {
        citySearch.click();
        searchBox.sendKeys(city);
        cityElement = getCityElement(city);
        cityElement.click();
    }

    protected String titleCheck()
    {
        return title.getText();
    }
    protected String checkCurrentCity() {
        return citySearch.getText();
    }

    private WebElement getCityElement(String city) {
        return parentElement.findElement(By.xpath("//*[@class = 'regions-list__item']/*[@data-name = '" + city + "']"));
    }

    protected boolean getBooleanSizeElementByIndex(int i) {
        return baseSocialElement.findElements(By.xpath("//*[@class='social__list social__list_corpMode']/li[" + i + "]/a")).size() != 0;
    }

    protected WebElement getElemenentByIndex(int i)
    {
        return baseSocialElement.findElement(By.xpath("//*[@class='social__list social__list_corpMode']/li[" + i + "]/a"));
    }

    protected void typeIn(String value, WebElement targetElement) {
        targetElement.clear();
        targetElement.sendKeys(value);
    }

    public BasePage goToSmallBussinesPage() {
        smallBussines.click();
        return new BasePage();
    }
}
