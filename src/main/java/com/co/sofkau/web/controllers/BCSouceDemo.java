package com.co.sofkau.web.controllers;

import com.co.sofkau.web.datos.DatosBase;
import com.co.sofkau.web.pages.SouceDemoHomePage;
import com.co.sofkau.web.pages.SouceDemoLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLException;

public class BCSouceDemo {

    public static void startApp(WebDriver driver, String url) {

        driver.get(url);
    }
    public static String getTitleInput(WebDriver driver){
        SouceDemoLoginPage loginPage = new SouceDemoLoginPage(driver);
        return loginPage.getInputUser().getText();

    }
    public static String getTitlePassword(WebDriver driver){
        SouceDemoLoginPage loginPage = new SouceDemoLoginPage(driver);
        return loginPage.getInputPassword().getText();
    }
    public static String getTitleButton(WebDriver driver){
        SouceDemoLoginPage loginPage = new SouceDemoLoginPage(driver);
        return loginPage.getButtonLogin().getText();
    }
    public static String getErrorMsg(WebDriver driver){
        SouceDemoLoginPage loginPage = new SouceDemoLoginPage(driver);
        return loginPage.getErrorText().getText();
    }

    public static void loginUser(WebDriver driver, String username, String password ){
        SouceDemoLoginPage loginPage = new SouceDemoLoginPage(driver);
        loginPage.getInputUser().sendKeys(username);
        loginPage.getInputPassword().sendKeys(password);
        loginPage.getButtonLogin().click();
    }
    public static String getTitleHome(WebDriver driver) {
        SouceDemoHomePage homePage = new SouceDemoHomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(homePage.getTitleHome()));
        return homePage.getTitleHome().getText();
    }

    public static void consultDatabase(WebDriver driver, DatosBase datosBase) throws SQLException {
        ConexionBD conexion = new ConexionBD();
        String consulta = "";
        String nombreTabla = "USUARIO";
        String nombreColumnaId = "ID";
        String nombreColumnaUsuario = "USERNAME";
        String nombreConsultaContra = "PSSWRD";

        consulta = "SELECT * FROM " +nombreTabla+ " WHERE " +nombreColumnaId+ " = " +generateId();

        conexion.establecerConexionBD();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        conexion.ejecutarConsulta(consulta, nombreColumnaUsuario, nombreConsultaContra, datosBase);

    }

    public static int generateId(){
        int idGenerado = (int) (Math.random()*(3-1+1)+1);
        return idGenerado;
    }

    public static void clickOptions(WebDriver driver){
        SouceDemoHomePage homePage = new SouceDemoHomePage(driver);
        homePage.getOptions().click();

    }

    public static void clickLogOut(WebDriver driver){
        SouceDemoHomePage homePage = new SouceDemoHomePage(driver);
        homePage.getLogOut().click();
    }
    public static String getTxtLogin(WebDriver driver){
        SouceDemoLoginPage loginPage = new SouceDemoLoginPage(driver);
        return loginPage.getButtonLogin().getText();
    }





}
