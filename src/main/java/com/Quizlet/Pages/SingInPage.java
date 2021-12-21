package com.Quizlet.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingInPage {
    private final WebDriver driver;
    private WelcomePage welcomePage;

    By loginForm = By.xpath("//form[@class='LoginPromptModal-form']");
    By username = By.xpath("//input[@name='username']");
    By password = By.xpath("//input[@name='password']");
    By loginBtn = By.xpath("//button[@class='UIButton UIButton--fill UIButton--hero']");

    public SingInPage(WebDriver driver) {
        this.driver = driver;
    }

    public WelcomePage login(String username, String password) {
        driver.findElement(this.username).sendKeys(username);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(loginBtn).click();
        welcomePage = new WelcomePage(driver);
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(welcomePage.siteAvatar));
        return welcomePage;
    }
}
