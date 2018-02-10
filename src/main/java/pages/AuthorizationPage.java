package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * URL - https://test2.skdo.ru/#/
 * Страница авторизации
 */
public class AuthorizationPage {
    private final By loginInputLocator = By.id("add_user_login");// Текстовое поле для ввода логина
    private final By passwordInputLocator = By.id("add_user_password");// Текстовое поле для ввода пароля
    private final By entryButtonLocator = By.id("login_next");// кнопка Вход
    private final By confirmCodeInputLocator = By.id("confirmation_code");// Текстовое поле для ввода кода из присланного смс
    private final By continueButtonLocator = By.id("send_message_next");// Кнопка Продолжить

    /**
     * Метод для авторизации(логин,пароль,кнопка вход)
     * @param driver
     * @param login
     * @param password
     */
    public void entry(WebDriver driver,String login,String password){
        driver.findElement(loginInputLocator).sendKeys(login);
        driver.findElement(passwordInputLocator).sendKeys(password);
        driver.findElement(entryButtonLocator).click();
    }

    /**
     * Подтверждение кодом из присланного смс
     * @param driver
     * @param smsCode
     */
    public void smsConfirmation(WebDriver driver, String smsCode){
        driver.findElement(confirmCodeInputLocator).sendKeys(smsCode);
        driver.findElement(continueButtonLocator).click();
    }
}
