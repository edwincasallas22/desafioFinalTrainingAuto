package com.co.sofkau.web.controllers;


import com.mysql.cj.log.Log;
import com.mysql.cj.log.LogFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.logging.log4j.Logger;

public class DriverController {

    public static WebDriver getDriver() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--lang=es");
        options.addArguments("--incognito");
        options.addArguments("--ignore-certificate-errors");
        return new ChromeDriver(options);

    }
}
