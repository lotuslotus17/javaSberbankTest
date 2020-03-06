import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

public class BaseTest {
    public static WebDriver driver;
    public static Actions actions;


    @Test
    public void firstTest() {
        String testCity = "Нижегородская область";
        driverSetup();
        Assertions.assertEquals(driver.getTitle(), "«Сбербанк» - Частным клиентам", "Ошибка в тайтле частным клиентам");
        page().goToSmallBussinesPage();
        Assertions.assertEquals(driver.getTitle(), "«Сбербанк» - Малый бизнес", "Ошибка в тайтле малый бизнес");
        page().changeCurrentCity(testCity);
        Assertions.assertEquals(page().checkCurrentCity(), testCity, "Ошибка при смене города");
        goToSocialElement();
        for (int i = 1; i <= 6; i++) {
            Assertions.assertTrue(page().getBooleanSizeElementByIndex(i));
        }
        driverEnd();
    }


    private void goToSocialElement() {
        actions.moveToElement(page().getElemenentByIndex(1));
        actions.perform();
    }

    private ChromeDriver createChromeDriver() {
        // SOme details:  https://github.com/bonigarcia/webdrivermanager/
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--start-maximized");
        ops.addArguments("--dns-prefetch-disable");
        ops.addArguments("test-type");
        ops.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
        WebDriverManager.getInstance(CHROME).setup();
        return new ChromeDriver(ops);
    }

    protected <P> P getPage(Class<P> pageClass) {
        return PageFactory.initElements(driver, pageClass);
    }

    private BasePage page() {
        return getPage(BasePage.class);
    }

    private void driverSetup() {
        driver = createChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.sberbank.ru/");
        actions = new Actions(driver);
    }

    private void driverEnd() {
        driver.close();
        driver.quit();
    }
}
