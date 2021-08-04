package com.co.sofkau.web.controllers;

import com.co.sofkau.web.pages.*;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.security.SecureRandom;
import java.util.Locale;

public class CompraSouceDemo {
    private WebDriver dirver;

    public static boolean isVisibleButtons(SouceDemoHomePage page) {
        int countButton = 0;
        page.addToListButtons();
        for (int i = 0; i < page.getListButton().size(); i++) {
            if (page.getListButton().get(i).isDisplayed()) {
                Assert.assertTrue(page.getListButton().get(i).isDisplayed());
                countButton++;
            }
            System.out.println(page.getListButton().get(i).getText());
        }
        if (countButton == 6) {
            return true;
        } else {
            return false;
        }
    }



    public static void clickButtonAddToCart(SouceDemoHomePage page, Integer producto) {
        page.addToListButtons();
        page.getListButton().get(producto).click();
    }

    public static String lookingCart(SouceDemoHomePage page) {
        return page.getCart().getText();
    }
    public static void clickCartpage(SouceDemoHomePage page) {
        page.getCartPage().click();
    }
    public static void clickCheckout(SouceDemoYourCartPage yourCartPage) {
        yourCartPage.getCheckoutbutton().click();
    }
    public static String getTittleCheckout(WebDriver driver) {
        CheckOutPage checkOut = new CheckOutPage(driver);
        return checkOut.getTitlePage().getText();
    }
    public static void clickContinue(CheckOutPage checkOutPage) {
        checkOutPage.getButtonContinue().click();
    }
    public static String getTittleCheckoutOverview(SouceDemoCheckOverviewPage checkOverview) {
        return checkOverview.getTitleCheckoutOverview().getText();
    }
    public static  void clickFinish(SouceDemoCheckOverviewPage overviewPage){
        overviewPage.getButtonFinish().click();
    }


    public static void generateFormCheckout(CheckOutPage checkoutPage){
        Faker faker = Faker.instance(new Locale("es", "CO"), new SecureRandom());
        checkoutPage.getFirstName().sendKeys(faker.name().firstName());
        checkoutPage.getLastName().sendKeys(faker.name().lastName());
        checkoutPage.getPostalCode().sendKeys(faker.address().zipCode());
        checkoutPage.getButtonContinue().click();
    }

    public static String getTxtComplete(WebDriver driver){
        SouceDemoCheckCompletePage checkCompletePage = new SouceDemoCheckCompletePage(driver);
        return checkCompletePage.getTxtComplete().getText();

    }

}
