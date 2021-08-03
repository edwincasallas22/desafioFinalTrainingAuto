package com.co.sofkau.web.controllers;

import com.co.sofkau.web.pages.SouceDemoHomePage;
import org.junit.Assert;

public class CargaSouceDemo {
    public static void isVisibleProducts(SouceDemoHomePage page) {
        page.addToListButtons();
        for (int i = 0; i < page.getListNameProducts().size(); i++) {
            Assert.assertTrue(page.getListNameProducts().get(i).isDisplayed());

            System.out.println(page.getListButton().get(i).getText());
        }

    }
}
