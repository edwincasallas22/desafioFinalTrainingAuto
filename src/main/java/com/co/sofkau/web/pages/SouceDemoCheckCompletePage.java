package com.co.sofkau.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SouceDemoCheckCompletePage {

    @FindBy(how = How.XPATH, using ="//*[@id=\"checkout_complete_container\"]/div")
    private WebElement txtComplete;


    public SouceDemoCheckCompletePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getTxtComplete() {
        return txtComplete;
    }
}
