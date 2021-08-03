package steps;

import com.co.sofkau.web.controllers.BCSouceDemo;
import com.co.sofkau.web.controllers.DriverController;
import com.co.sofkau.web.controllers.CargaSouceDemo;
import com.co.sofkau.web.datos.DatosBase;
import com.co.sofkau.web.pages.SouceDemoHomePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.sql.SQLException;

public class CargaSteps {

    WebDriver driver;
    @Before
    public void setUp(){

        driver = DriverController.getDriver();
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
