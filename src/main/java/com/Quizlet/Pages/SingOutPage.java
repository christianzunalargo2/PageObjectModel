package com.Quizlet.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SingOutPage {

    private final WebDriver driver;
    public By logOutHeader = By.xpath("//div[contains(text(), \"YOU'VE LOGGED OUT SUCCESSFULLY.\")]");

    public SingOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLogOutHeaderText() {
        return driver.findElement(logOutHeader).getText();
    }
}
