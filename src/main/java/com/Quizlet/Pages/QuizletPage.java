package com.Quizlet.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QuizletPage {

    WebDriver driver;
    SingInPage singInPage;
    private By loginBtn = By.xpath("//button[@aria-label='Log in']");

    public QuizletPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getQuizletTitle() {
        String title = driver.getTitle();
        return title;
    }

    public SingInPage clickLogIn() {
        driver.findElement(loginBtn).click();
        singInPage = new SingInPage(driver);
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(singInPage.loginForm));
        return singInPage;
    }
}
