package tema6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio3 {

    public static void comprobacion(String cadena, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        boolean error;

        if (max - 2 <= min || cadena.equals("")) {
            throw new IllegalArgumentException("parámetros erroneos en la funcion");
        } else {
            System.out.println(cadena);
            do {
                error = false;
                try {
                    System.out.println("Introduce un número entero entre " + min + " y " + max);
                    num = sc.nextInt();
                    if (num <= min || num >= max) {
                        error = true;
                        System.out.println("Numero fuera de rango");
                    }
                } catch (NumberFormatException | InputMismatchException e) {
                    System.out.println("Tipo de dato incorrecto");
                    error = true;
                }
                sc.nextLine();
            } while (error);
            System.out.println("Todo correcto");
        }
    }

    public static void main(String[] args) {

        int min = 5;
        int max = 8;
        String cadena = "El rango de los parametros es adecuado";

        comprobacion(cadena, min, max);
    }
}
