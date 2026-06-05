package com.franco.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/*
 * ReportManager
 *
 * Esta clase se encarga de crear y configurar el reporte ExtentReports.
 * Es un singleton para asegurar que exista una sola instancia del reporte
 * durante toda la ejecución de los tests.
 */
public class ReportManager {

    private static ExtentReports extent;

    /*
     * Retorna la instancia única del reporte.
     * Si no existe, la crea y la configura.
     */
    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter spark = new ExtentSparkReporter("reportes/reporte.html");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Proyecto", "Automation Framework");
            extent.setSystemInfo("Tester", "Franco");
        }

        return extent;
    }
}