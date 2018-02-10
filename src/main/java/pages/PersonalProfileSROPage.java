package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Личный кабинет СРО
 */
public class PersonalProfileSROPage {
    private final By title = By.className("topbar-title");// Title
    /**
     *
     * @param driverWait
     * @return Текст оглавления(Title text)
     */
    public String getTitleText(WebDriverWait driverWait){
        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }
}
