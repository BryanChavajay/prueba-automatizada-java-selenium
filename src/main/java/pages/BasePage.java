package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;
    private static WebDriverWait wait;


    static{
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver,7);
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\ab189\\OneDrive\\Escritorio\\repoAutomatizacion\\chromedriver.exe");
    }

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, 7);
    }

    public static void navigateTo(String url){
        driver.get(url);

    }

    public void cerrarNavegadorclose() {
            if (driver != null) {
                try {
                    Thread.sleep(5000); // Espera 5 segundos antes de cerrar
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            driver.quit();
        }
    }
}
