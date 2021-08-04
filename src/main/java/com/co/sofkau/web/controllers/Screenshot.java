package com.co.sofkau.web.controllers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class Screenshot {

    WebDriver driver;

    public Screenshot(WebDriver driver) {
        this.driver = driver;
    }

    UUID uuid = UUID.randomUUID();
    String uuidAsString = uuid.toString();

    public void takeScreenshot() throws IOException {

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("src/test/resources/screenshots/screenshot"+uuidAsString+".png"));
    }
}
