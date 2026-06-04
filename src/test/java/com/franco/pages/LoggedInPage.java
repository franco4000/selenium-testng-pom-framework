package com.franco.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
 * Esta clase representa la página que se muestra luego de un login exitoso.
 * Contiene los elementos y acciones disponibles para un usuario autenticado,
 * como validar el mensaje de bienvenida, verificar el botón de logout
 * y cerrar la sesión de la aplicación.
 */
public class LoggedInPage extends BasePage {

    // Espera explícita para sincronizar elementos de la página
    private WebDriverWait wait;

    // Locator del enlace Log out
    private By logoutLink = By.linkText("Log out");

    // Constructor: recibe el driver desde el test
    public LoggedInPage(WebDriver driver) {
        super(driver);

        // Inicializa una espera explícita de hasta 10 segundos
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Verifica que el enlace Log out esté visible en la página
    public boolean estaVisibleLogout() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink));

        return driver.findElement(logoutLink).isDisplayed();
    }

    // Obtiene el mensaje de bienvenida mostrado luego del login exitoso
    public String obtenerMensajeBienvenida() {
        return driver.findElement(By.tagName("h1")).getText();
    }

    // Hace click en el enlace Log out para cerrar la sesión
    public void hacerLogout() {
        driver.findElement(logoutLink).click();
    }
}
//"Representa la página a la que accede el usuario después de autenticarse. Contiene las validaciones y
// accionesdisponibles una vez iniciada la sesión,como verificar el mensajede bienvenida o
// realizar el logout."