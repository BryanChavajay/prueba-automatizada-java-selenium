package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwagLabsPage extends BasePage{
    public SwagLabsPage() {super(driver);}

    public void navigateToSwag(){
        navigateTo("https://www.saucedemo.com/");
    }

    public void clickButtonById(String buttonId) {
        WebElement button = driver.findElement(By.id(buttonId));
        button.click();
    }

    public void enterField(String idField, String valueField){
        WebElement inputField = driver.findElement(By.id(idField));
        inputField.sendKeys(valueField);
    }

    public void seleccionarProducto(String nombreProducto) {
        // Encuentra el producto por su nombre y realiza la selección
        WebElement producto = driver.findElement(By.xpath("//div[contains(text(), '" + nombreProducto + "')]"));
        producto.click();
    }

    public void regresarAProductos() {
        WebElement btnRegresar = driver.findElement(By.id("back-to-products"));
        btnRegresar.click();
    }

    public void irAlCarrito() {
        WebElement carrito = driver.findElement(By.className("shopping_cart_link"));
        carrito.click();
        WebElement btnCheckout = driver.findElement(By.id("checkout"));
        btnCheckout.click();
    }

    public void completarInformacion(String firstName, String lastName, String postalCode) {
        WebElement inputFirstName = driver.findElement(By.id("first-name"));
        WebElement inputLastName = driver.findElement((By.id("last-name")));
        WebElement inputPostalCode = driver.findElement(By.id("postal-code"));
        WebElement btnContinue = driver.findElement(By.id("continue"));

        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        inputPostalCode.sendKeys(postalCode);
        btnContinue.click();
    }

    public void finalizarCompra() {
        WebElement btnFinish = driver.findElement(By.id("finish"));
        btnFinish.click();
    }

    public void compraRealizadoConExito() {
        WebElement h2ConGracias = driver.findElement(By.xpath("//h2[contains(text(), 'Thank you for your order!')]"));
    }

    public void logout() {
        // Abre el menú de usuario
        WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
        menuButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10); // Espera hasta 10 segundos

        WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
        logoutLink.click();
    }

    public boolean isLogoutSuccessful() {
        // Verifica que el logout se haya realizado con éxito
        WebElement loginButton = driver.findElement(By.id("login-button"));
        return loginButton.isDisplayed();
    }

    @Override
    public void cerrarNavegadorclose() {
        super.cerrarNavegadorclose();
    }
}
