package steps;

import com.co.sofkau.web.controllers.BCSouceDemo;
import com.co.sofkau.web.controllers.DriverController;
import com.co.sofkau.web.controllers.CargaSouceDemo;
import com.co.sofkau.web.controllers.Screenshot;
import com.co.sofkau.web.datos.DatosBase;
import com.co.sofkau.web.pages.SouceDemoHomePage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.sql.SQLException;

public class CargaSteps {

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

    @Given("^un usuario entro a la url de la aplicacion web$")
    public void unUsuarioEntroALaUrlDeLaAplicacionWeb() {
        BCSouceDemo.startApp(driver, "https://www.saucedemo.com/");
    }

    @When("^un usuario ingresa datos validos para loguearse$")
    public void unUsuarioIngresaDatosValidosParaLoguearse() throws SQLException {
        DatosBase datosBase = new DatosBase();
        BCSouceDemo.consultDatabase(driver, datosBase);
        BCSouceDemo.loginUser(driver, datosBase.getUsuario(), datosBase.getContrasena());
    }

    @Then("^podra acceder al home princiapl de la app llamado productos$")
    public void podraAccederAlHomePrinciaplDeLaAppLlamadoProductos() {
        Assert.assertEquals(BCSouceDemo.getTitleHome(driver), "PRODUCTS");
    }

    @Given("^un comprador entro al home de la aplicacion Sauce demo$")
    public void unCompradorEntroAlHomeDeLaAplicacionSauceDemo() throws SQLException {
        BCSouceDemo.startApp(driver, "https://www.saucedemo.com/");
        DatosBase datosBase = new DatosBase();
        BCSouceDemo.consultDatabase(driver, datosBase);
        BCSouceDemo.loginUser(driver, datosBase.getUsuario(), datosBase.getContrasena());

    }

    @When("^el usuario desea visualizar todos los productos que existen en la la zona de productos$")
    public void elUsuarioDeseaVisualizarTodosLosProductosQueExistenEnLaLaZonaDeProductos() {
        Assert.assertEquals(BCSouceDemo.getTitleHome(driver), "PRODUCTS");
    }

    @Then("^podra ver cada uno de los articulos puestos en venta$")
    public void podraVerCadaUnoDeLosArticulosPuestosEnVenta() {
        SouceDemoHomePage page = new SouceDemoHomePage(driver);
        CargaSouceDemo.isVisibleProducts(page);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
