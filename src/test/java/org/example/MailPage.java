package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MailPage {
    // конструктор класса, занимающийся инициализацией полей класса
    public WebDriver driver;
    public MailPage (WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


}
