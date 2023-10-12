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
        slowType(inputField, valueField);
        //inputField.sendKeys(valueField);
    }

    public void seleccionarProducto(String nombreProducto) {
        // Encuentra el producto por su nombre y realiza la selección
        WebElement producto = driver.findElement(By.xpath("//div[contains(text(), '" + nombreProducto + "')]"));
        sleep(3000);
        producto.click();

        // Encuentra el botón "Add to Cart" (el ID puede variar)
        WebElement btnAgregarAlCarrito = driver.findElement(By.id("add-to-cart-" + nombreProducto.toLowerCase().replace(" ", "-")));
        btnAgregarAlCarrito.click();
    }

    public void regresarAProductos() {
        WebElement btnRegresar = driver.findElement(By.id("back-to-products"));
        sleep(3000);
        btnRegresar.click();
    }

    public void irAlCarrito() {
        WebElement carrito = driver.findElement(By.className("shopping_cart_link"));
        WebDriverWait wait = new WebDriverWait(driver, 25); // Espera hasta 10 segundos
        wait.until(ExpectedConditions.elementToBeClickable(carrito));
        carrito.click();
        sleep(3000);
    }

    public  void checkoutCompra() {
        WebElement btnCheckout = driver.findElement(By.id("checkout"));
        WebDriverWait wait = new WebDriverWait(driver, 25); // Espera hasta 10 segundos
        wait.until(ExpectedConditions.elementToBeClickable(btnCheckout));
        sleep(3000);
        btnCheckout.click();
    }

    public void eliminarProductoDelCarrito(String nombreProducto) {
        // Encuentra el botón "Remove" para el producto específico (el ID puede variar)
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement btnEliminar = driver.findElement(By.id("remove-" + nombreProducto.toLowerCase().replace(" ", "-")));
        wait.until(ExpectedConditions.elementToBeClickable(btnEliminar));
        btnEliminar.click();
        sleep(3000);
    }

    public void completarInformacion(String firstName, String lastName, String postalCode) {
        WebElement inputFirstName = driver.findElement(By.id("first-name"));
        WebElement inputLastName = driver.findElement((By.id("last-name")));
        WebElement inputPostalCode = driver.findElement(By.id("postal-code"));
        WebElement btnContinue = driver.findElement(By.id("continue"));

        //inputFirstName.sendKeys(firstName);
        //inputLastName.sendKeys(lastName);
        //inputPostalCode.sendKeys(postalCode);
        slowType(inputFirstName, firstName);
        slowType(inputLastName, lastName);
        slowType(inputPostalCode, postalCode);
        btnContinue.click();
    }

    private void slowType(WebElement element, String text) {
        for (char c : text.toCharArray()) {
            element.sendKeys(String.valueOf(c));
            sleep(90); // Espera 300 milisegundos entre cada carácter (ajusta el tiempo según tu preferencia)
        }
    }

    private void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void finalizarCompra() {
        WebElement btnFinish = driver.findElement(By.id("finish"));
        WebDriverWait wait = new WebDriverWait(driver, 15); // Espera hasta 15segundos
        wait.until(ExpectedConditions.elementToBeClickable(btnFinish));
        btnFinish.click();
        WebElement btnBackToHome = driver.findElement(By.id("back-to-products"));
        sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(btnBackToHome));
        btnBackToHome.click();
    }

    public void finishshop() {
        WebElement btnFinish = driver.findElement(By.id("finish"));
        WebDriverWait wait = new WebDriverWait(driver, 15); // Espera hasta 15segundos
        wait.until(ExpectedConditions.elementToBeClickable(btnFinish));
        btnFinish.click();
    }

    public void compraRealizadoConExito() {
        WebElement h2ConGracias = driver.findElement(By.xpath("//h2[contains(text(), 'Thank you for your order!')]"));
        h2ConGracias.isDisplayed();
    }

    public void logout() {
        // Abre el menú de usuario
        WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
        WebDriverWait wait = new WebDriverWait(driver, 15); // Espera hasta 10 segundos
        wait.until(ExpectedConditions.elementToBeClickable(menuButton));
        menuButton.click();

        WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
        logoutLink.click();
    }

    public boolean isLogoutSuccessful() {
        // Verifica que el logout se haya realizado con éxito
        WebElement loginButton = driver.findElement(By.id("login-button"));
        WebDriverWait wait = new WebDriverWait(driver, 15); // Espera hasta 10 segundos
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        return loginButton.isDisplayed();
    }

    @Override
    public void cerrarNavegadorclose() {
        super.cerrarNavegadorclose();
    }
}
