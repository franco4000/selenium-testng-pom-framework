package com.franco.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.franco.base.BaseTest;
import org.testng.ITestListener;
import org.testng.ITestResult;

/*
 * TestListener
 *
 * Listener de TestNG que intercepta la ejecución de los tests.
 * Permite ejecutar acciones automáticas como:
 * - Crear reportes en ExtentReports
 * - Capturar screenshots en caso de fallo
 */
public class TestListener extends BaseTest implements ITestListener {

    private static ExtentReports extent = ReportManager.getInstance();

    /*
     * Se ejecuta cuando un test comienza
     */
    @Override
    public void onTestStart(ITestResult result) {
        extent.createTest(result.getName());
    }

    /*
     * Se ejecuta cuando un test pasa correctamente
     */
    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentTest test = extent.createTest(result.getName());
        test.pass("Test ejecutado correctamente");
    }

    /*
     * Se ejecuta cuando un test falla
     */
    @Override
    public void onTestFailure(ITestResult result) {

        // captura screenshot del error
        ScreenshotUtils.takeScreenshot(driver, result.getName());

        ExtentTest test = extent.createTest(result.getName());
        test.fail(result.getThrowable());
    }

    /*
     * Se ejecuta al finalizar toda la suite
     */
    @Override
    public void onFinish(org.testng.ITestContext context) {
        extent.flush();
    }
}