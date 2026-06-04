package com.franco.utils;

/*
 * Esta clase almacena los datos de prueba utilizados por los tests.
 * Su objetivo es centralizar la información para evitar valores
 * escritos directamente en los casos de prueba y facilitar
 * el mantenimiento del proyecto.
 */
public class TestData {

    // Credenciales válidas para realizar un login exitoso
    public static final String USUARIO_VALIDO = "student";
    public static final String PASSWORD_VALIDA = "Password123";

    // Credenciales inválidas para probar escenarios negativos
    public static final String USUARIO_INVALIDO = "usuarioMalo";
    public static final String PASSWORD_INVALIDA = "passwordMala";
}
//"esta clase separa los datos de prueba de la lógicade los tests. De esta manera evitorepetir
// información, el código quedamás limpioy si cambian los datos solo debo modificarlos en un único lugar."