package com.franco.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/*
 * Esta clase representa la página de Login de la aplicación.
 * Contiene los elementos y acciones necesarias para interactuar
 * con la pantalla de autenticación, como ingresar credenciales,
 * iniciar sesión y obtener mensajes de error.
 */
public class LoginPage extends BasePage {

    // Locators de la página de login
    private By usernameInput = By.id("username");
    private By passwordInput = By.id("password");
    private By submitButton = By.id("submit");
    private By errorMessage = By.id("error");

    // Constructor: recibe el driver desde el test
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Ingresa el nombre de usuario en el campo correspondiente
    public void ingresarUsuario(String usuario) {
        driver.findElement(usernameInput).sendKeys(usuario);
    }

    // Ingresa la contraseña en el campo correspondiente
    public void ingresarPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    // Hace click en el botón Login y devuelve la página de usuario logueado
    public LoggedInPage clickLogin() {
        driver.findElement(submitButton).click();
        return new LoggedInPage(driver);
    }

    public String obtenerMensajeError() {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(errorMessage)
        );

        return driver.findElement(errorMessage).getText();
    }
}
//"Es la Page Object que representa la pantalla de login. Contiene los localizadoresy los métodos
// para interactuarcon esa página, como ingresar credenciales, hacer login y validar mensajes de error."