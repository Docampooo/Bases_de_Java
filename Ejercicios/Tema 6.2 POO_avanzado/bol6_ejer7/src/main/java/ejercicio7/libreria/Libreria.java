package ejercicio7.libreria;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Libreria {

    public static int pedirEntero() {
        Scanner sc = new Scanner(System.in);

        int num = 0;
        boolean error;
        do {
            error = false;
            try {
                num = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("En este campo solo se permiten numeros enteros");
                error = true;
            }
            sc.nextLine();
        } while (error);
        return num;
    }

    public static double pedirReal() {
        Scanner sc = new Scanner(System.in);

        double num = 0;
        boolean error;
        do {
            error = false;
            try {
                num = sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("En este campo solo se permiten numeros reales");
                error = true;
            }
            sc.nextLine();
        } while (error);

        return num;
    }
}
