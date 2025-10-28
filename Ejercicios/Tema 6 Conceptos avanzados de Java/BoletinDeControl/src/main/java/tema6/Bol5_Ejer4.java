package tema6;

import java.util.IllegalFormatException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Bol5_Ejer4 {

    /**
     * Se le pasa un String y devuelve cada uno de sus caracteres en una línea
     * diferente
     * 
     * @param cadena cadena de la que recoge los caracteres
     */
    public static void muestraEnLinea(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            System.out.println(cadena.charAt(i));
        }
    }

    /**
     * Se le pasa una cadena, una posición que usa como referencia para devolver los
     * caracteres de la cadena y un número de caracteres que va a devolver
     * 
     * @param cadena     cadena de la que recoge los caracteres
     * @param posicion   posicion desde la que comienza a devolver caracteres
     * @param caracteres numero de caracteres que devuelve
     * @return si la cadena es nula o los valores están fuera de rango, devuelve
     *         cadena vacía, otro, devuele el numero de caracteres indicado desde la
     *         posición indicada
     */
    public static String subCadena(String cadena, int posicion, int caracteres) {

        String resultado = "";

        if (cadena == null || cadena.equals("") || (posicion < 0 || posicion >= cadena.length())
                || (caracteres < 0 || caracteres + posicion >= cadena.length())) {
            throw new IllegalArgumentException("parámetros erroneos en la funcion");
        } else {
            for (int i = posicion; i < caracteres + posicion; i++) {
                resultado = resultado + cadena.charAt(i);
            }
            return resultado;
        }
    }

    /**
     * Se le pasa una cadena y la devuelve centrada en la consola
     * 
     * @param cadena cadena a devolver centrada
     */
    public static void muestraCentrado(String cadena) {

        if (cadena.length() >= 80) {
            throw new IllegalArgumentException("La cadena es demasiado larga");
        }
        for (int i = 0; i < (40 - cadena.length() / 2); i++) {
            System.out.print(" ");
        }
        System.out.println(cadena);
    }

    /**
     * se le pasa una cadena y devuelve un vector char donde cada caracter de la
     * cadena es un elemento del vector
     * 
     * @param cadena cadena con la que se hace el vector
     * @return vector hecho con los caracteres de la cadena
     */
    public static char[] cadenaAVector(String cadena) {

        char[] vector = new char[cadena.length()];
        for (int i = 0; i < vector.length; i++) {
            vector[i] = cadena.charAt(i);
        }
        return vector;
    }

    /**
     * Se le pasa una cadena y devuelve la misma cadena escrita al reves
     * 
     * @param cadena cadena a invertir
     * @return cadena invertida
     */
    public static String reverso(String cadena) {

        String patras = "";
        for (int i = cadena.length() - 1; i >= 0; i--) {
            patras = (patras + cadena.charAt(i));
        }
        return patras;
    }

    // A = 65
    // a = 97 97 - 65 = 32

    /**
     * Se le pasa un conjunto de Strings y los devuelve concatenados y en mayúsculas
     * 
     * @param cadenas conjunto de Strings que se concatenan y se pasan a mayúsculas
     * @return Strings concatenados y en mayúsculas
     */
    public static String pasoAMayusculas(String... cadenas) {

        String concat = "";
        String palabra = "";
        for (int i = 0; i < cadenas.length; i++) {
            palabra = cadenas[i];
            for (int u = 0; u < palabra.length(); u++) {

                char caracter = palabra.charAt(u);
                if (caracter == '_') {
                    caracter = ' ';
                    concat = (concat + caracter);
                } else {
                    if (caracter >= 'a' && caracter <= 'z') {
                        caracter = (char) (caracter - 32);
                        concat = (concat + caracter);
                    } else {
                        concat = (concat + caracter);
                    }
                }
            }
            concat = (concat + " ");
        }
        return concat;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un texto para comprobar las excepciones de subCadena");
        String cadena = sc.nextLine();
        System.out.println("Ahora una posicion y la cantidad de caracteres par sacar");

        int num1 = 0;
        int num2 = 0;

        try {
            num1 = sc.nextInt();
            num2 = sc.nextInt();
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("Tipo de dato incorrecto");
        }

        System.out.println(subCadena(cadena, num1, num2)); // --> 1

        System.out.println("Introduce otro texto para comprobar las excepciones de muestraCentrado");

        sc.nextLine();
        String texto = sc.nextLine();

        if(texto.length() >= 80){
            throw new InputMismatchException("Numero de caracteres demasiado grande");
        }

        muestraCentrado(texto); // --> 2

        // muestraEnLinea("Alberto y el trujo");

        // System.out.println(cadenaAVector("Alberto Carril"));

        // System.out.println(reverso("Nicolas"));

        // System.out.println(pasoAMayusculas( "El Nicolas", "Pablo_Vaz", "Alberto
        // Carril", "Lucas Gonzalez", "ABC abc_1234_!$(){}][]ñÑ"));

    }
}
