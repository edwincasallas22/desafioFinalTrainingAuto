package steps;

import com.co.sofkau.web.controllers.BCSouceDemo;
import com.co.sofkau.web.controllers.DriverController;
import com.co.sofkau.web.controllers.Screenshot;
import com.co.sofkau.web.datos.DatosBase;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {
    private static final Logger Logger = LogManager.getLogger(LoginSteps.class);
    WebDriver driver;
    @Before
    public void setUp(){

        driver = DriverController.getDriver();
        driver = DriverController.getDriverFireFox();
    }

    @AfterStep
    public void callScreenshot() throws IOException {
        Screenshot screenshot = new Screenshot(driver);
        screenshot.takeScreenshot();

    }

    @Dado("^un usuario entro a la url de la aplicacion$")
    public void unUsuarioEntroALaUrlDeLaAplicacion() {
        BCSouceDemo.startApp(driver, "https://www.saucedemo.com/");

    }

    @Cuando("^el usuario desea visualizar los campos para loguearse$")
    public void elUsuarioDeseaVisualizarLosCamposParaLoguearse() {
        BCSouceDemo.getTitleInput(driver);
        BCSouceDemo.getTitlePassword(driver);
        BCSouceDemo.getTitleButton(driver);
        System.out.println(BCSouceDemo.getTitleInput(driver));
    }

    @Entonces("^podra ver los elementos para loguearse username, password y el boton de Login$")
    public void podraVerLosElementosParaLoguearseUsernamePasswordYElBotonDeLogin() {
        Assert.assertEquals(BCSouceDemo.getTitleInput(driver),"");
        Assert.assertEquals(BCSouceDemo.getTitlePassword(driver),"");
        Assert.assertEquals(BCSouceDemo.getTitleButton(driver),"");
    }

    @Cuando("^el usuario ingresa un usuario y clave validos$")
    public void elUsuarioIngresaUnYValidos() throws SQLException {

        DatosBase datosBase = new DatosBase();
        BCSouceDemo.consultDatabase(driver, datosBase);
        BCSouceDemo.loginUser(driver, datosBase.getUsuario(), datosBase.getContrasena());
    }

    @Entonces("^podra autenticarse correctamente y acceder a la zona de productos$")
    public void podraAutenticarseCorrectamenteYAccederALaZonaDeProductos() {
        Assert.assertEquals(BCSouceDemo.getTitleHome(driver), "PRODUCTS");
    }

   @Cuando("^el usuario ingresa \"([^\"]*)\" y \"([^\"]*)\" invalidos$")
    public void elUsuarioIngresaYInvalidos(String username, String password)  {
        BCSouceDemo.loginUser(driver, username, password);
    }

    @Entonces("^se mostrara el mensaje de  autentificacion fallida$")
    public void seMostraraElDeAutentificacionFallida()  {
        assertTrue(BCSouceDemo.getErrorMsg(driver).contains("Epic sadface: Username is required")||
                BCSouceDemo.getErrorMsg(driver).contains("Epic sadface: Username and password do not match any user in this service") ||
                BCSouceDemo.getErrorMsg(driver).contains("Epic sadface: Password is required"),"Error message");
    }


    @Dado("^un usuario entro a la pagina principal de souce demo con usuario y clave validos$")
    public void unUsuarioEntroALaPaginaPrincipalDeSouceDemoConUsuarioYClaveValidos()throws SQLException {
        BCSouceDemo.startApp(driver, "https://www.saucedemo.com/");
        DatosBase datosBase = new DatosBase();
        BCSouceDemo.consultDatabase(driver, datosBase);
        BCSouceDemo.loginUser(driver, datosBase.getUsuario(), datosBase.getContrasena());
    }

    @Cuando("^el comprador desea salir del home principal de la aplicacion$")
    public void elCompradorDeseaSalirDelHomePrincipalDeLaAplicacion() {
        BCSouceDemo.clickOptions(driver);
        BCSouceDemo.clickLogOut(driver);
    }

    @Entonces("^podra salir por medio del boton Logout$")
    public void podraSalirPorMedioDelBotonLogout() {
        Assert.assertEquals(BCSouceDemo.getTxtLogin(driver),"");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
