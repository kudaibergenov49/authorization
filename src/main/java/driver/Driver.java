package driver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class Driver {
    private final String path = "chrome_driver/chromedriver.exe";//путь к драйверу
    private final String property = "webdriver.chrome.driver";
    private WebDriver driver;

    /**
     *
     * @return Драйвер для работы с браузером GoogleChrome с неявным ожиданием в 30 секунд и полноразмерным окном
     */
    public WebDriver getDriver() {
        System.setProperty(property, path);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    /**
     * Метод для ожидания загрузки страницы
     * @param driver
     */
    public static void waitForLoadPage(WebDriver driver) {
        final JavascriptExecutor jse = (JavascriptExecutor) driver;
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return jse.executeScript("return document.readyState").equals("complete");
            }
        };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
        System.out.println("121212");
    }
}
