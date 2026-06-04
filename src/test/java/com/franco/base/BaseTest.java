package com.franco.base;

import com.franco.pages.LoginPage;
import com.franco.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/*
 * Esta clase sirve como base para todos los tests del proyecto.
 * Se encarga de inicializar y cerrar el navegador antes y después
 * de cada ejecución, además de proporcionar métodos comunes
 * que pueden reutilizarse en los distintos casos de prueba.
 */
public class BaseTest {

    // Driver compartido para todos los tests
    protected WebDriver driver;

    // Se ejecuta antes de cada test e inicializa el navegador

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createDriver();
    }

    // Abre la página de login y devuelve su Page Object

    public LoginPage abrirLoginPage() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        return new LoginPage(driver);
    }

    // Se ejecuta después de cada test y cierra el navegador

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}