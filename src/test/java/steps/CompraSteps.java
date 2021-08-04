package steps;

import com.co.sofkau.web.controllers.*;
import com.co.sofkau.web.datos.DatosBase;
import com.co.sofkau.web.pages.CheckOutPage;
import com.co.sofkau.web.pages.SouceDemoCheckOverviewPage;
import com.co.sofkau.web.pages.SouceDemoHomePage;


import com.co.sofkau.web.pages.SouceDemoYourCartPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.sql.SQLException;

public class CompraSteps {

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

    @Given("^un comprador entro a la url de la aplicacion web$")
    public void unCompradorEntroALaUrlDeLaAplicacionWeb() {
        BCSouceDemo.startApp(driver, "https://www.saucedemo.com/");
    }

    @When("^un comprador ingresa datos validos para loguearse$")
    public void unCompradorIngresaDatosValidosParaLoguearse() throws SQLException {
        DatosBase datosBase = new DatosBase();
        BCSouceDemo.consultDatabase(driver, datosBase);
        BCSouceDemo.loginUser(driver, datosBase.getUsuario(), datosBase.getContrasena());
    }

    @Then("^podra acceder al home principal de la app llamado productos$")
    public void podraAccederAlHomePrincipalDeLaAppLlamadoProductos() {
        Assert.assertEquals(BCSouceDemo.getTitleHome(driver), "PRODUCTS");
    }


    @Given("^que un usuario se encuentre Autenticado$")
    public void queUnUsuarioSeEncuentreAutenticado() {
        BCSouceDemo.startApp(driver, "https://www.saucedemo.com/");
        BCSouceDemo.loginUser(driver, "standard_user", "secret_sauce");
    }

    @When("^un usuario ingresa a la pagina home del sitio Sauce demo$")
    public void unUsuarioIngresaALaPaginaHomeDelSitioSauceDemo() {
        Assert.assertEquals(BCSouceDemo.getTitleHome(driver), "PRODUCTS");
    }

    @Then("^visualizara los botones para anadir al carro de compras ADD TO CART en los productos$")
    public void visualizaraLosBotonesParaAnadirAlCarroDeComprasADDTOCARTEnLosProductos() {
        SouceDemoHomePage page = new SouceDemoHomePage(driver);
        CompraSouceDemo.isVisibleButtons(page);

    }

    @And("^da click en el boton ADD TO CART de cualquier \"([^\"]*)\"$")
    public void daClickEnElBotonADDTOCARTDeCualquier(Integer producto)  {
        SouceDemoHomePage page = new SouceDemoHomePage(driver);
        CompraSouceDemo.clickButtonAddToCart(page, producto);
    }

    @Then("^el producto se agrega a la lista de ADD TO CART$")
    public void elProductoSeAgregaALaListaDeADDTOCART() {
        SouceDemoHomePage page = new SouceDemoHomePage(driver);
        Assert.assertEquals(CompraSouceDemo.lookingCart(page), "1");

    }


    @Given("que un usuario autenticado con usuario y password validos")
    public void queUnUsuarioAutenticadoConUsuarioYPasswordValidos()  {
        BCSouceDemo.startApp(driver, "https://www.saucedemo.com/");
        BCSouceDemo.loginUser(driver, "standard_user", "secret_sauce");
    }


    @And("haya agregado un producto al carro de compras")
    public void hayaAgregadoUnProductoAlCarroDeCompras() {
        SouceDemoHomePage page = new SouceDemoHomePage(driver);
        CompraSouceDemo.clickButtonAddToCart(page,1);
    }

    @When("el usuario ingresa en la pagina CHECKOUT: YOUR INFORMATION")
    public void elUsuarioIngresaEnLaPaginaCHECKOUTYOURINFORMATION() {
        SouceDemoHomePage page = new SouceDemoHomePage(driver);
        CompraSouceDemo.clickCartpage(page);
        SouceDemoYourCartPage yourCartPage = new SouceDemoYourCartPage(driver);
        CompraSouceDemo.clickCheckout(yourCartPage);
        Assert.assertEquals(CompraSouceDemo.getTittleCheckout(driver), "CHECKOUT: YOUR INFORMATION");
    }

    @Then("Se podra ingresar informacion personal en los respectivos campos")
    public void sePodraIngresarInformacionPersonalEnLosRespectivosCampos() {

        CheckOutPage checkOut = new CheckOutPage(driver);
        SouceDemoCheckOverviewPage checkOverview = new SouceDemoCheckOverviewPage(driver);
        CompraSouceDemo.generateFormCheckout(checkOut);
        Assert.assertEquals(CompraSouceDemo.getTittleCheckoutOverview(checkOverview), "CHECKOUT: OVERVIEW");

    }
    @Given("un usuario entro a la zona de checkOutOverView")
    public void unUsuarioEntroALaZonaDeCheckOutOverView() {
        BCSouceDemo.startApp(driver, "https://www.saucedemo.com/");
        BCSouceDemo.loginUser(driver, "standard_user", "secret_sauce");
        SouceDemoHomePage page = new SouceDemoHomePage(driver);
        CompraSouceDemo.clickButtonAddToCart(page,1);
        CompraSouceDemo.clickCartpage(page);
        SouceDemoYourCartPage yourCartPage = new SouceDemoYourCartPage(driver);
        CompraSouceDemo.clickCheckout(yourCartPage);
        CheckOutPage checkOut = new CheckOutPage(driver);
        CompraSouceDemo.generateFormCheckout(checkOut);
    }

    @When("el usuario presiona el boton de finish")
    public void elUsuarioPresionaElBotonDeFinish() {
        SouceDemoCheckOverviewPage checkOverview = new SouceDemoCheckOverviewPage(driver);
        CompraSouceDemo.clickFinish(checkOverview);

    }

    @Then("podra acceder a la zona de complete y ver el mensaje de envio exitoso con su respectiva imagen")
    public void podraAccederALaZonaDeCompleteYVerElMensajeDeEnvioExitosoConSuRespectivaImagen() {

                Assert.assertEquals(CompraSouceDemo.getTxtComplete(driver), "Your order has been dispatched, and will arrive just as fast as the pony can get there!");

    }


    @After
    public void tearDown(){
        driver.quit();
    }



}
