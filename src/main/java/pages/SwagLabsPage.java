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
