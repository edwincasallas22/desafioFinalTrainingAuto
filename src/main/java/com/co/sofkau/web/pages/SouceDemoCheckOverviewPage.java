package com.co.sofkau.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SouceDemoCheckOverviewPage {

    @FindBy(how = How.XPATH, using = "//*[@id=\"header_container\"]/div[2]/span")
    private WebElement titleCheckoutOverview;
    @FindBy(how = How.XPATH, using = "//*[@id=\"finish\"]")
    private WebElement buttonFinish;

    public SouceDemoCheckOverviewPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getTitleCheckoutOverview() {
        return titleCheckoutOverview;
    }

    public WebElement getButtonFinish() {
        return buttonFinish;
    }
}
