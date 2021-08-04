package com.co.sofkau.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SouceDemoYourCartPage {

    @FindBy(how = How.XPATH, using = "//*[@id=\"header_container\"]/div[2]/span")
    private WebElement titleYourCart;

    @FindBy(how = How.XPATH, using = "//*[@id=\"checkout\"]")
    private WebElement checkoutbutton;

    public SouceDemoYourCartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    public WebElement getTitleYourCart() {
        return titleYourCart;
    }
    public WebElement getCheckoutbutton(){ return checkoutbutton;}
}
