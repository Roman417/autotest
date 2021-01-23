package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    // конструктор класса, занимающийся инициализацией полей класса
    public WebDriver driver;
    public ProfilePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //определение локатора меню пользователя
    @FindBy(xpath = "//span[text()=\"r.khvostikov\"]")
    private WebElement userMenu;

    //определние локатора кнопки выхода
    @FindBy(xpath = "//*[contains(@class, 'menu__item menu__item_type_link legouser__menu-item legouser__menu-item_action_exit')]")
    private  WebElement logoutBtn;

    //метод для получения имени пользователя из меню пользователя
    public String getUserName(){
        String userName = userMenu.getText();
        return userName;
    }

    @FindBy (xpath = "//*[contains(text(), 'Почта')]")
    private WebElement mailEnter;

    //метод нажатия кнопки пользователя
    public void entryMenu(){
        userMenu.click();
    }

    //метод нажатия кнопки "почта"
    public void entryMail(){
        mailEnter.click();
    }

    //метод нажатия кнопки выхода из аккаунта
    public void userLogout(){
        logoutBtn.click();
    }
}
