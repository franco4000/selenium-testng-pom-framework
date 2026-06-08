package com.franco.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
 * DriverFactory
 *
 * Esta clase es responsable de crear y configurar el navegador que utilizarán
 * los tests automatizados. Centraliza la creación del WebDriver para evitar
 * repetir código en distintas partes del framework.
 */
public class DriverFactory {

    /*
     * Crea una instancia de ChromeDriver.
     * Configura automáticamente el driver de Chrome utilizando
     * WebDriverManager y maximiza la ventana del navegador.
     */
    public static WebDriver createDriver() {

        // Configura automáticamente la versión correcta del ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Configuración de Chrome para ejecución local y CI/CD
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // Crea una nueva instancia del navegador Chrome
        WebDriver driver = new ChromeDriver(options);

        // Maximiza la ventana para ejecutar las pruebas en pantalla completa
        driver.manage().window().maximize();

        // Devuelve el driver listo para ser utilizado
        return driver;
    }
}