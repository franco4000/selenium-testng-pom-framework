package com.franco.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

        // Crea una nueva instancia del navegador Chrome
        WebDriver driver = new ChromeDriver();

        // Maximiza la ventana para ejecutar las pruebas en pantalla completa
        driver.manage().window().maximize();

        // Devuelve el driver listo para ser utilizado
        return driver;
    }
}

