package com.franco.tests;

import com.franco.base.BaseTest;
import com.franco.pages.LoggedInPage;
import com.franco.pages.LoginPage;
import com.franco.utils.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void abrirPaginaLogin() {

        driver.get("https://practicetestautomation.com/practice-test-login/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.ingresarUsuario(TestData.USUARIO_VALIDO);

        loginPage.ingresarPassword(TestData.PASSWORD_VALIDA);
        loginPage.clickLogin();

        LoggedInPage loggedInPage = new LoggedInPage(driver);

        Assert.assertTrue(loggedInPage.estaVisibleLogout());

    }

    @Test
    public void loginIncorrecto() {

        driver.get("https://practicetestautomation.com/practice-test-login/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.ingresarUsuario(TestData.USUARIO_INVALIDO);
        loginPage.ingresarPassword(TestData.PASSWORD_INVALIDA);
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.obtenerMensajeError().contains("Your username is invalid!"));
    }

    @Test
    public void passwordIncorrecta() {
        LoginPage loginPage = abrirLoginPage();

        loginPage.ingresarUsuario(TestData.USUARIO_VALIDO);
        loginPage.ingresarPassword(TestData.PASSWORD_INVALIDA);
        loginPage.clickLogin();

        Assert.assertTrue(
                loginPage.obtenerMensajeError()
                        .contains("Your password is invalid!")
        );
    }

    @Test
    public void usuarioIncorrectoPasswordValida() {
        LoginPage loginPage = abrirLoginPage();

        loginPage.ingresarUsuario(TestData.USUARIO_INVALIDO);
        loginPage.ingresarPassword(TestData.PASSWORD_VALIDA);
        loginPage.clickLogin();

        Assert.assertTrue(
                loginPage.obtenerMensajeError()
                        .contains("Your username is invalid!")
        );
    }

    @Test
    public void usuarioVacio() {
        LoginPage loginPage = abrirLoginPage();

        loginPage.ingresarPassword(TestData.PASSWORD_VALIDA);
        loginPage.clickLogin();
        Assert.assertTrue(
                loginPage.obtenerMensajeError()
                        .contains("Your username is invalid!")
        );
    }

    @Test
    public void passwordVacia() {
        LoginPage loginPage = abrirLoginPage();

        loginPage.ingresarUsuario(TestData.USUARIO_VALIDO);
        loginPage.clickLogin();

        Assert.assertTrue(
                loginPage.obtenerMensajeError()
                        .contains("Your password is invalid!")
        );
    }

    @Test
    public void validarUrlLoginExitoso() {

        LoginPage loginPage = abrirLoginPage();


        loginPage.ingresarUsuario(TestData.USUARIO_VALIDO);
        loginPage.ingresarPassword(TestData.PASSWORD_VALIDA);
        loginPage.clickLogin();

        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://practicetestautomation.com/logged-in-successfully/"
        );

    }

    @Test
    public void validarMensajeBienvenida() {

        LoginPage loginPage = abrirLoginPage();

        loginPage.ingresarUsuario(TestData.USUARIO_VALIDO);
        loginPage.ingresarPassword(TestData.PASSWORD_VALIDA);
        loginPage.clickLogin();

        LoggedInPage loggedInPage = new LoggedInPage(driver);

        Assert.assertEquals(
                loggedInPage.obtenerMensajeBienvenida(),
                "Logged In Successfully"
        );
    }

    @Test
    public void hacerLogout() {

        LoginPage loginPage = abrirLoginPage();

        // Login con credenciales válidas
        loginPage.ingresarUsuario(TestData.USUARIO_VALIDO);
        loginPage.ingresarPassword(TestData.PASSWORD_VALIDA);
        loginPage.clickLogin();

        // Crea la página luego del login exitoso
        LoggedInPage loggedInPage = new LoggedInPage(driver);

        // Hace click en Log out
        loggedInPage.hacerLogout();

        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://practicetestautomation.com/practice-test-login/"
        );

    }
}
//"Es la clase padre de los tests. Se encarga de abrir y cerrar el navegador automáticamente y
// contiene funcionalidades comunes que pueden reutilizar todos los casos de prueba."