package com.franco.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/*
 * ScreenshotUtils
 *
 * Utilidad para capturar screenshots cuando un test falla.
 * Guarda la imagen en la carpeta /screenshots con el nombre del test.
 */
public class ScreenshotUtils {

    /*
     * Toma una captura de pantalla del navegador
     * y la guarda en disco.
     */
    public static void takeScreenshot(WebDriver driver, String testName) {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            Files.copy(
                    src.toPath(),
                    new File("screenshots/" + testName + ".png").toPath()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}