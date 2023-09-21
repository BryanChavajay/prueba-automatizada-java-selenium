package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.SwagLabsPage;

public class SwagStepDefinition {
    SwagLabsPage swagPage = new SwagLabsPage();

    @Given("^Se abre swag$")
    public void navigateToSwag() {
        swagPage.navigateToSwag();
    }

    @When("^Se ingresen las credenciales$")
    public void enterUsername() {
        swagPage.enterField("user-name", "standard_user");
        swagPage.enterField("password", "secret_sauce");
    }

    @Then("^Se presiona el boton login$")
    public void clickLogin(){
        swagPage.clickButtonById("login-button");
    }

    @When("^El usuario selecciona un producto")
    public void selectedProduct() {
        swagPage.seleccionarProducto("Sauce Labs Backpack");
        swagPage.regresarAProductos();
        swagPage.seleccionarProducto("Sauce Labs Bike Light");
        swagPage.regresarAProductos();
        swagPage.seleccionarProducto("Sauce Labs Fleece Jacket");
    }

    @And("^El usuario agrega el producto al carrito")
    public void irAlCarrito() {
        swagPage.irAlCarrito();
    }

    @And("^Completa los datos para la compra")
    public void completarInfoCliente() {
        swagPage.completarInformacion("Victor", "Samines", "0701");
    }
    @And("^Finalizar compra")
    public void finalizarCompra() {
        swagPage.finalizarCompra();
    }

    @And("^Verificar la compra con exito")
    public void compraConExito() {
        swagPage.compraRealizadoConExito();
    }
    @When("^Se cierra la sesion$")
    public void performLogout() {
        swagPage.logout();
    }
    @Then("^Se ha cerrado la sesión correctamente$")
    public void verifyLogoutSuccess() {
        // Agrega las verificaciones necesarias para confirmar que la sesión se cerró con éxito.
        assert swagPage.isLogoutSuccessful();
    }

    @And("^Se cierra el navegador$")
    public void closeChrome() {
        swagPage.cerrarNavegadorclose();
    }
}