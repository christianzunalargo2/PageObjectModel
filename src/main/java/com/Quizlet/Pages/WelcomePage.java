package com.Quizlet.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage {

    private final WebDriver driver;

    By siteAvatar = By.xpath("//div[@class='SiteAvatar TopNavigationItem']");
    By avatarDropDown = By.xpath("//div[@class='SiteAvatar TopNavigationItem']/child::div");
//    private By logOutBtn = By.xpath("//span[contains(text(), 'Log out')]");
private By logOutBtn = By.linkText("Log out");

    private SingOutPage singOutPage;

    public WelcomePage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickAvatarDropDown() {
        driver.findElement(avatarDropDown).click();
    }

    public SingOutPage clickLogOut() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(logOutBtn));
        driver.findElement(logOutBtn).click();

        singOutPage = new SingOutPage(driver);
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(singOutPage.logOutHeader));
        return singOutPage;
    }

}
