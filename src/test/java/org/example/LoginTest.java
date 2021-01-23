package org.example;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup(){

        System.setProperty("webdriver.chrome.driver","D:\\webdriver\\chromedriver2\\chromedriver.exe");
        // создание экземпляра драйвера
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);

        // окно разворачивается на полный экран
        driver.manage().window().maximize();
        // задержка на выполнение теста = 10 сек
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // получение ссылки на страницу
        driver.get(ConfProperties.getProperty("loginpage"));

    }

    @Test
    public void loginTest(){
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickLoginBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        //получаем отображаемый логин и сравниваем его с логином из файла настроек
        Assert.assertEquals(profilePage.getUserName(), ConfProperties.getProperty("user"));
    }

    // выход из аккаунта с закрытием браузера
    @AfterClass
    public static void tearDown(){
        profilePage.entryMenu();
        profilePage.userLogout();
        driver.quit();
    }

}
