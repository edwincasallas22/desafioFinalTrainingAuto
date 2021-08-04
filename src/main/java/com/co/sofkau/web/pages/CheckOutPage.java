package com.co.sofkau.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    WebElement titlePage;

    @FindBy(id = "first-name")
    private WebElement firstName;
    @FindBy(id = "last-name")
    private WebElement lastName;
    @FindBy(id = "postal-code")
    private WebElement postalCode;
    @FindBy(id = "continue")
    private WebElement buttonContinue;
    @FindBy(xpath = "//*[@id=\"checkout_info_container\"]/div/form")
    WebElement formCheckout;

    public WebElement getTitlePage() {
        return titlePage;
    }

    public CheckOutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getPostalCode() {
        return postalCode;
    }
    public WebElement getButtonContinue() {
        return buttonContinue;
    }


}
