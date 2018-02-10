package tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.AuthorizationPage;
import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.PersonalProfileSROPage;
import java.io.IOException;
import static driver.Driver.waitForLoadPage;

/**
 * @author Kudaibergen Kuanysh
 *
 * Тестовое задание СКДО
 */
public class SKDOTest {
    private WebDriver driver;
    private WebDriverWait driverWait;

    static class Pages{
       static AuthorizationPage authorizationPage = new AuthorizationPage();
       static PersonalProfileSROPage personalProfileSROPage = new PersonalProfileSROPage();
    }

    @BeforeTest// Предустановка
    public void openTestBrowser(){
       driver = new Driver().getDriver();
       driverWait = new WebDriverWait(driver,30);
    }

    @Test(dataProvider = "testData")
    public void authorization(String URL,String login,String password,String smsCode,String titleText){
        driver.get(URL);
        Pages.authorizationPage.entry(driver,login,password);
        Pages.authorizationPage.smsConfirmation(driver,smsCode);
        waitForLoadPage(driver);
        String title = Pages.personalProfileSROPage.getTitleText(driverWait);
        System.out.println(title);
        Assert.assertEquals(title, titleText);
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }

    @DataProvider
    private Object[][] testData(){
        return new Object[][]{
                {"https://test2.skdo.ru","1087799035840","Barsik22","9","Личный кабинет СРО"}
        };
    }
}