package com.franco.pages;

import org.openqa.selenium.WebDriver;

/*
 * Esta clase es la base de todas las páginas del proyecto.
 * Su función es almacenar el WebDriver compartido para que
 * las demás Page Objects puedan interactuar con el navegador
 * sin necesidad de declarar el driver en cada clase.
 */
public class BasePage {

    // Driver compartido por todas las páginas
    protected WebDriver driver;

    // Constructor que recibe el driver y lo comparte con las clases hijas
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
//"BasePage es la clase padre de todas las páginas del proyecto. Se encarga de compartir el
// WebDriver para que las demás Page Objects puedan utilizar el navegador sin repetir código."