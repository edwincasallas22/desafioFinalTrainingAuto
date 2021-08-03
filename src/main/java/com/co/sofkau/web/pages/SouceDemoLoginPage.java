package com.co.sofkau.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SouceDemoLoginPage {
    @FindBy(how = How.ID, using = "user-name")
    private WebElement inputUser;

    @FindBy(how = How.ID, using = "password")
    private WebElement inputPassword;

    @FindBy(how = How.ID, using = "login-button")
    private WebElement buttonLogin;

    @FindBy(how = How.XPATH, using = "//*[@id=\"login_button_container\"]/div/form/div[3]")
    private WebElement errorText;



    public SouceDemoLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getInputUser() {
        return inputUser;
    }

    public WebElement getInputPassword() {
        return inputPassword;
    }

    public WebElement getButtonLogin() {
        return buttonLogin;
    }

    public WebElement getErrorText() {
        return errorText;
    }


}
