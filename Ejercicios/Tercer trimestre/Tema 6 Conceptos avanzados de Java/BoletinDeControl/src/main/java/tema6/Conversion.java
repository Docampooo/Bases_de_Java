
package tema6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Conversion {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int opcion = 0;
    double euro = 0;
    double libra = 0;
    boolean error;

    do {
      System.out.println("---------------------------------------------------------------------------------------");

      System.out.println("elige una opcion");
      System.out.println("1º conversor de euros a libras");
      System.out.println("2º conversor de libras a euros");
      System.out.println("3º salir");
      System.out.println("---------------------------------------------------------------------------------------");
      do {
        error = false;
        try {
          opcion = sc.nextInt();
        } catch (InputMismatchException e) {
          System.out.println("Unicamente se permite una opcion entre 1 y 3");
          error = true;
        }
        sc.nextLine();
      } while (error);

      switch (opcion) {

        case 1:
          System.out.println("inserta la cantidad de euros que quieras pasar a libras:  ");
          do {
            error = false;
            try {
              euro = sc.nextDouble();
              while (euro < 0) {
                System.out.println("no se aceptan numeros negativos, introduce otro");
                euro = sc.nextDouble();
              }
            } catch (NumberFormatException | InputMismatchException e) {
              System.out.println("Solo se admiten numeros reales");
              error = true;
            }
            sc.nextLine();
          } while (error);

          libra = euro * 0.84;
          System.out.printf("la conversion equivalente es %.2f  libras \n", libra);
          break;
        case 2:
          System.out.println("inserta la cantidad de libras que quieras pasar a euros");
          do {
            error = false;
            try {
              libra = sc.nextDouble();
            } catch (InputMismatchException e) {
              System.out.println("Solo se admiten numeros reales");
              error = true;
            }
            sc.nextLine();
          } while (error);
          
          while (libra < 0) {
            System.out.println("no se aceptan numeros negativos, introduce otro");
            libra = sc.nextDouble();
          }
          euro = libra * 1.14;
          System.out.printf("la conversion equivalente es %.2f  euros \n", euro);
          break;
        case 3:
          System.out.println("has salido");
          break;
        default:
          System.out.println("Opcion fuera de rango");
      }
    } while (opcion != 3);

  }
}
